using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using Dominio;
using Negocio;

public partial class visao_Carrinho : System.Web.UI.Page
{
    private const int ClnQuantidade = 2;
    private const int ClnValorUnitario = 4;
    private const int ClnValorTotal = 5;

    private decimal total = 0;

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            if (Request["listar"] != null)
            {
                if(Request["listar"].ToString() == "1")
                    AtualizarCarrinho();
            }
            else
            {
                ListarCarrinho(null);
            }            
        }
    }

    private void AtualizarCarrinho()
    {
        Carrinho carrinho = (Carrinho)Session["carrinho"];
        CarrinhoNegocio carrinhoNegocio = new CarrinhoNegocio();
        int qtdAtualizada;
        ArrayList produtos = new ArrayList();
        ItemVenda itemVenda = new ItemVenda();
        
        for (int contador = 0;contador < carrinho.ListaItemVenda.Count; contador++)//(ItemVenda itemVenda in carrinho.ListaItemVenda)
        {
            itemVenda.Qtde = carrinho.ListaItemVenda[contador].Qtde;
            qtdAtualizada = carrinhoNegocio.AdicionarProduto(carrinho, carrinho.ListaItemVenda[contador].ItemProduto.Produto, carrinho.ListaItemVenda[contador].Qtde, true);
            if (qtdAtualizada < itemVenda.Qtde)
            {
                produtos.Add(carrinho.ListaItemVenda[contador].ItemProduto.Produto);
            }
        }

        ListarCarrinho(produtos);
    }

    private void ListarCarrinho(ArrayList produtos)
    {
        try
        {
            Carrinho carrinho = (Carrinho)Session["carrinho"];

            DataSet carrinhoSource = new DataSet();

            DataTable tabela = new DataTable();

            tabela.Columns.Add("Imagem");
            tabela.Columns.Add("Nome");
            tabela.Columns.Add("Custo");
            tabela.Columns.Add("Qtde");
            tabela.Columns.Add("IdProduto");
            tabela.Columns.Add("ValorTotal");
            tabela.Columns.Add("Mensagem");

            if (carrinho.ListaItemVenda.Count == 0)
            {
                throw new Exception();
            }

            string mensagem = "";

            foreach (ItemVenda itemVenda in carrinho.ListaItemVenda)
            {
                if (produtos != null)
                    if(produtos.Contains(itemVenda.ItemProduto.Produto))// itemVenda.ItemProduto.Produto.IdProduto == idProduto)
                        mensagem = "1";
                else
                    mensagem = "0";

                decimal valorTotal = itemVenda.Qtde * itemVenda.ItemProduto.PrecoItemProduto;
                tabela.Rows.Add(itemVenda.ItemProduto.Produto.UrlImagem, itemVenda.ItemProduto.Produto.Nome, itemVenda.ItemProduto.PrecoItemProduto.ToString("C2"), itemVenda.Qtde, itemVenda.ItemProduto.Produto.IdProduto, valorTotal.ToString("C2"), mensagem);
            }

            carrinhoSource.Tables.Add(tabela);

            GVCarrinho.DataSource = carrinhoSource;
            GVCarrinho.DataBind();

            divFormCarrinho.Visible = !(labelMensagem.Visible = false);
        }
        catch (Exception e)
        {
            divFormCarrinho.Visible = !(labelMensagem.Visible = true);
        }
    }

    protected void GridView1_RowDataBound(object sender, GridViewRowEventArgs e)
    {
        if(e.Row.RowType == DataControlRowType.DataRow)
        {
            int qtde = int.Parse(((DataSet)GVCarrinho.DataSource).Tables[0].Rows[e.Row.RowIndex].ItemArray.GetValue(3).ToString());
            string mensagem = ((DataSet)GVCarrinho.DataSource).Tables[0].Rows[e.Row.RowIndex].ItemArray.GetValue(6).ToString();

            ((TextBox)e.Row.FindControl("txtQuantidade")).Text = qtde.ToString();
            decimal valorTotal = decimal.Parse(e.Row.Cells[ClnValorTotal].Text.Substring(2));
            total += valorTotal;

            if (mensagem == "1")
            {
                ((Label)e.Row.FindControl("lblQuantidade")).Text = "Garantimos apenas " + qtde + " unidades desse produto.";
            }            
        }
        if (e.Row.RowType == DataControlRowType.Footer)
        {
            e.Row.Cells[ClnValorUnitario].Text = "TOTAL";
            e.Row.Cells[ClnValorTotal].Text = total.ToString("C2");
        }
    }

    protected void atualizarQuantidade_Command(object sender, CommandEventArgs e)
    {
        Carrinho carrinho = (Carrinho)Session["carrinho"];

        CarrinhoNegocio carrinhoNegocio = new CarrinhoNegocio();
        Produto produtoNovo = new Produto();
        produtoNovo.IdProduto = int.Parse(e.CommandArgument.ToString());
        int qtde = int.Parse(((TextBox)((ImageButton)sender).Parent.FindControl("txtQuantidade")).Text);

        int qtdeAtualizada = carrinhoNegocio.AdicionarProduto(carrinho, produtoNovo, qtde, true);

        Session.Add("carrinho", carrinho);

        ArrayList produtos = new ArrayList();

        if (qtdeAtualizada < qtde)
        {
            produtos.Add(produtoNovo);
            ListarCarrinho(produtos);
        }
        else
        {
            ListarCarrinho(null);
        }
    }

    protected void removerItemVenda_Command(object sender, CommandEventArgs e)
    {
        CarrinhoNegocio carrinhoNegocio = new CarrinhoNegocio();

        Produto produto = new Produto();
        produto.IdProduto = int.Parse(e.CommandArgument.ToString());

        Carrinho carrinho = (Carrinho)Session["carrinho"];

        ItemVenda itemVenda = carrinhoNegocio.RecuperarItemVenda(carrinho, produto);
        carrinho = carrinhoNegocio.RemoverItemVenda(carrinho, itemVenda);

        Session.Add("carrinho", carrinho);

        ListarCarrinho(null);
    }
    protected void imgVoltarALoja_Click(object sender, ImageClickEventArgs e)
    {
        Response.Redirect("index.aspx");
    }
    protected void imgFinalizarPedido_Click(object sender, ImageClickEventArgs e)
    {
        if (Session["usuario"] == null)
            Response.Redirect("Login.aspx?compra=s");
        else
            Response.Redirect("FinalizarVenda.aspx");
    }
}
