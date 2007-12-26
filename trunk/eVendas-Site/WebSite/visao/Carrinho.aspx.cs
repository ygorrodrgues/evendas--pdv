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
            CarrinhoNegocio.ListarGrid(GridView1, (Carrinho)Session["carrinho"]);
        }
    }

    protected void GridView1_RowDataBound(object sender, GridViewRowEventArgs e)
    {
        if(e.Row.RowType == DataControlRowType.DataRow)
        {
            int qtde = int.Parse(((DataSet)GridView1.DataSource).Tables[0].Rows[e.Row.RowIndex].ItemArray.GetValue(3).ToString());
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
        Carrinho carrinhoSessao = (Carrinho)Session["carrinho"];
        int IdProduto = int.Parse(e.CommandArgument.ToString());
        int qtde = int.Parse(((TextBox)((ImageButton)sender).Parent.FindControl("txtQuantidade")).Text);

        CarrinhoNegocio carrinhoNegocio = new CarrinhoNegocio();
        carrinhoSessao = carrinhoNegocio.AdicionarItemVenda(carrinhoSessao, IdProduto, qtde);
        
        Session.Add("carrinho", carrinhoSessao);

        CarrinhoNegocio.ListarGrid(GridView1, (Carrinho)Session["carrinho"]);
    }

    protected void removerQuantidade_Command(object sender, CommandEventArgs e)
    {
        Carrinho carrinhoSessao = (Carrinho)Session["carrinho"];
        int IdProduto = int.Parse(e.CommandArgument.ToString());

        CarrinhoNegocio carrinhoNegocio = new CarrinhoNegocio();
        carrinhoSessao = carrinhoNegocio.RemoverItemVenda(carrinhoSessao, IdProduto);

        Session.Add("carrinho", carrinhoSessao);

        CarrinhoNegocio.ListarGrid(GridView1, (Carrinho)Session["carrinho"]);
    }
}
