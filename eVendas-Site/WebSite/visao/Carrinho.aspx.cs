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
    private decimal total = 0;
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            ListarGridCarrinho();
        }
    }

    private void ListarGridCarrinho()
    {
        DataSet carrinhoSource = new DataSet();
        Carrinho carrinho;

        if (Session["carrinho"] == null)
        {
            carrinho = new Carrinho();
        }
        else
        {
            carrinho = (Carrinho)Session["carrinho"];
        }

        DataTable tabela = new DataTable();
        tabela.Columns.Add("Imagem");
        tabela.Columns.Add("Descricao");
        tabela.Columns.Add("Preco");
        tabela.Columns.Add("Qtde");
        tabela.Columns.Add("IdProduto");

        foreach (ItemVenda itemVenda in carrinho.ListaItemVenda)
        {
            tabela.Rows.Add(itemVenda.Produto.UrlImagem, itemVenda.Produto.Descricao, itemVenda.Produto.Preco.ToString("C2"), itemVenda.Qtde, itemVenda.Produto.IdProduto);
        }

        carrinhoSource.Tables.Add(tabela);

        GridView1.DataSource = carrinhoSource;
        GridView1.DataBind();
    }

    protected void GridView1_RowDataBound(object sender, GridViewRowEventArgs e)
    {
        if(e.Row.RowType == DataControlRowType.DataRow)
        {
            int qtde = int.Parse(((DataSet)GridView1.DataSource).Tables[0].Rows[e.Row.RowIndex].ItemArray.GetValue(3).ToString());
            ((TextBox)e.Row.FindControl("txtQuantidade")).Text = qtde.ToString();
            decimal valorUnitario = decimal.Parse(e.Row.Cells[3].Text.Substring(2));
            decimal valorTotal = qtde * valorUnitario;
            total += valorTotal;
            e.Row.Cells[4].Text = valorTotal.ToString("C2");
        }
        if (e.Row.RowType == DataControlRowType.Footer)
        {
            e.Row.Cells[3].Text = "TOTAL";
            e.Row.Cells[4].Text = total.ToString("C2");
        }
    }

    protected void atualizarQuantidade_Command(object sender, CommandEventArgs e)
    {
        ItensVenda itensVenda = ((Carrinho)Session["carrinho"]).ListaItemVenda;
        ItemVenda itemVenda = itensVenda.ItemVenda(int.Parse(e.CommandArgument.ToString()));
        int indice = itensVenda.IndexOf(itemVenda);
        itensVenda.RemoveAt(indice);
        itemVenda.Qtde = int.Parse(((TextBox)((ImageButton)sender).Parent.FindControl("txtQuantidade")).Text);
        itensVenda.Insert(indice, itemVenda);
        Carrinho carrinho = new Carrinho();
        carrinho.ListaItemVenda = itensVenda;

        Session.Add("carrinho", carrinho);

        ListarGridCarrinho();
    }
}
