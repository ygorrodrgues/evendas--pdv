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
            Session.Add("carrinho", Carrinho);

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
        CarrinhoNegocio carrinhoNegocio = new CarrinhoNegocio();
        Produto produtoNovo = new Produto();
        produtoNovo.IdProduto = int.Parse(e.CommandArgument.ToString());

        carrinhoNegocio.AdicionarProduto(Carrinho, produtoNovo, 1, false);

        Session.Add("carrinho", Carrinho);

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
