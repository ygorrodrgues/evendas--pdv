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

public partial class visao_index : System.Web.UI.Page
{
    private Carrinho carrinho;
    protected Carrinho Carrinho
    {
        get
        {
            if (Session["carrinho"] == null)
            {
                carrinho = new Carrinho();
                return carrinho;
            }
            else
            {
                carrinho = (Carrinho)Session["carrinho"];
                return carrinho;
            }
        }

        set { carrinho = value; }
    }

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            //Carrega os dados para o Repeater
            DataSet catalogoSource = new DataSet();
            catalogoSource.ReadXml(MapPath("Catalogo.xml"));
            catalogo.DataSource = catalogoSource;
            catalogo.DataBind();
        }

        lblQtdCarrinho.Text = Carrinho.ListaItemVenda.Count.ToString();
    }

    protected void btnAdicionarCarrinho_Command(object sender, CommandEventArgs e)
    {
        DataSet catalogoSource = new DataSet();
        catalogoSource.ReadXml(MapPath("Catalogo.xml"));

        ItemVenda itemVendaNovo = new ItemVenda();
        itemVendaNovo.Qtde = 1;
        
        Produto produtoNovo = new Produto();
        DataRow dr = (DataRow)catalogoSource.Tables[0].Select("ID = " + e.CommandArgument.ToString()).GetValue(0);
        produtoNovo.IdProduto = int.Parse(dr["id"].ToString());
        produtoNovo.Descricao = dr["descricao"].ToString();
        produtoNovo.Preco = decimal.Parse(dr["preco"].ToString());
        produtoNovo.UrlImagem = dr["urlImagem"].ToString();
        produtoNovo.Texto = dr["texto"].ToString();

        itemVendaNovo.Produto = produtoNovo;

        Session.Add("carrinho", Carrinho);

        Carrinho.ListaItemVenda.Add(itemVendaNovo);

        Response.Redirect("Carrinho.aspx");
    }
}
