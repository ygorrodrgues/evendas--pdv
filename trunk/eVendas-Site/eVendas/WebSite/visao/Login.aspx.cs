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
using Negocio;
using Dominio;

public partial class visao_Login : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {
        IdentificarUsuario();
    }

    private void IdentificarUsuario()
    {
        if (Session["usuario"] != null)
        {
            lblMensagem.Visible = !(divFormularioLogin.Visible = false);

            Usuario usuario = (Usuario)Session["usuario"];

            if (Request["compra"] != null)
            {
                Response.Redirect("FinalizarVenda.aspx");
            }
            else
            {
                lblMensagem.Text = "Olá, " + usuario.Login;
            }            
        }
        else
        {
            lblMensagem.Visible = divFormularioLogin.Visible = true;
            lblMensagem.Text = "Para continuar é necessário estar logado.";
        }
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
            lblMensagem.Text = "Login e/ou Senha inválidos!";
    }
}
