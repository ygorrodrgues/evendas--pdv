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
            if (Session["itemVenda"] != null)
            {
                Carrinho carrinho = AdicionarItemVenda((ItemVenda)Session["itemVenda"], 1, false);
                Session.Add("carrinho", carrinho);

                Session.Remove("itemVenda");
            }

            ListarCarrinho();
        }
    }

    private void ListarCarrinho()
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

            if (carrinho.ListaItemVenda.Count == 0)
            {
                throw new Exception();
            }

            foreach (ItemVenda itemVenda in carrinho.ListaItemVenda)
            {
                decimal valorTotal = itemVenda.Qtde * itemVenda.Produto.Custo;
                tabela.Rows.Add(itemVenda.Produto.UrlImagem, itemVenda.Produto.Nome, itemVenda.Produto.Custo.ToString("C2"), itemVenda.Qtde, itemVenda.Produto.IdProduto, valorTotal.ToString("C2"));
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
            ((TextBox)e.Row.FindControl("txtQuantidade")).Text = qtde.ToString();
            decimal valorTotal = decimal.Parse(e.Row.Cells[ClnValorTotal].Text.Substring(2));
            total += valorTotal;
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
        int IdProduto = int.Parse(e.CommandArgument.ToString());
        int qtde = int.Parse(((TextBox)((ImageButton)sender).Parent.FindControl("txtQuantidade")).Text);

        ItensVenda itensVenda = carrinho.ListaItemVenda;
        ItemVenda itemVenda = itensVenda.ItemVenda(IdProduto);

        carrinho = AdicionarItemVenda(itemVenda, qtde, true);
        
        Session.Add("carrinho", carrinho);

        ListarCarrinho();
    }

    private Carrinho AdicionarItemVenda(ItemVenda NovoItemVenda, int qtde, bool atualizar)
    {
        Carrinho carrinho = (Carrinho)Session["carrinho"];
        ItensVenda itensVenda = carrinho.ListaItemVenda;
        ItemVenda itemVenda = itensVenda.ItemVenda(NovoItemVenda.Produto.IdProduto);
        int indice = itensVenda.IndexOf(itemVenda);

        if (indice == -1)
        {
            itensVenda.Add(NovoItemVenda);
        }
        else if (indice >= 0 && qtde > 0 && atualizar)
        {
            itensVenda.RemoveAt(indice);
            NovoItemVenda.Qtde = qtde;
            itensVenda.Insert(indice, NovoItemVenda);       
        }
        else if (indice >= 0 && qtde == 0)
        {
            carrinho = RemoverItemVenda(NovoItemVenda);
        }

        return carrinho;
    }

    private Carrinho RemoverItemVenda(ItemVenda itemVenda)
    {
        Carrinho carrinho = (Carrinho)Session["carrinho"];
        ItensVenda itensVenda = carrinho.ListaItemVenda;
        itensVenda.Remove(itemVenda);

        Session.Add("carrinho", carrinho);

        return carrinho;
    }

    protected void removerItemVenda_Command(object sender, CommandEventArgs e)
    {
        Carrinho carrinho = (Carrinho)Session["carrinho"];
        ItensVenda itensVenda = carrinho.ListaItemVenda;
        ItemVenda itemVenda = itensVenda.ItemVenda(int.Parse(e.CommandArgument.ToString()));

        carrinho = RemoverItemVenda(itemVenda);

        Session.Add("carrinho", carrinho);

        ListarCarrinho();
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
