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
            ProdutoNegocio produtoNegocio = new ProdutoNegocio();
            catalogo.DataSource = produtoNegocio.Select();
            catalogo.DataBind();

            CategoriaProdutoNegocio categoriaProdutoNegocio = new CategoriaProdutoNegocio();
            menuCategorias.DataSource = categoriaProdutoNegocio.Select();
            menuCategorias.DataBind();

            IdentificarUsuario();                
        }

        lblQtdCarrinho.Text = Carrinho.ListaItemVenda.Count.ToString();
    }

    protected void btnAdicionarCarrinho_Command(object sender, CommandEventArgs e)
    {
        DataSet catalogoSource = new DataSet();
        ProdutoNegocio negocio = new ProdutoNegocio();
        catalogoSource = negocio.Select();

        ItemVenda itemVendaNovo = new ItemVenda();
        itemVendaNovo.Qtde = 1;
        
        Produto produtoNovo = new Produto();
        DataRow dr = (DataRow)catalogoSource.Tables[0].Select("ID_PRODUTO = " + e.CommandArgument.ToString()).GetValue(0);
        produtoNovo.IdProduto = int.Parse(dr["id_produto"].ToString());
        produtoNovo.Descricao = dr["descricao_produto"].ToString();
        produtoNovo.Custo = decimal.Parse(dr["custo"].ToString());
        produtoNovo.UrlImagem = dr["Imagem_caminho"].ToString();
        produtoNovo.Nome = dr["nome_produto"].ToString();

        itemVendaNovo.Produto = produtoNovo;

        Session.Add("carrinho", Carrinho);
        Session.Add("itemVenda", itemVendaNovo);

        Response.Redirect("Carrinho.aspx");
    }
    protected void btnLogin_Click(object sender, EventArgs e)
    {
        Usuario usuario = new Usuario();
        usuario.Login = txtUsuario.Text;
        usuario.Senha = txtSenha.Text;

        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();

        usuario = usuarioNegocio.AutenticarUsuario(usuario);
        if (usuario != null)
        {
            Session.Add("usuario", usuario);

            IdentificarUsuario();
        }
        else
            RegisterClientScriptBlock("falhaAutenticacao", "<script>alert('Login e/ou Senha inválidos!');</script>");
    }

    private void IdentificarUsuario()
    {
        if (Session["usuario"] != null)
        {
            divFormularioLogin.Visible = !(divAreaAutenticada.Visible = true);

            Usuario usuario = (Usuario)Session["usuario"];

            lblUsuario.Text = usuario.Login;
        }
        else
            divFormularioLogin.Visible = !(divAreaAutenticada.Visible = false);
    }
}
