<%@ Page Language="C#" MasterPageFile="~/eVendas.master" AutoEventWireup="true" CodeFile="Login.aspx.cs" Inherits="visao_Login" Title="eVendas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<form id="form" runat="server">
<div id="page">
    <div id="divMensagem" runat="server">
        <asp:Label ID="lblMensagem" runat="server" Text="Para continuar é necessário estar logado." CssClass="labelMensagem"></asp:Label>
        <br /><br />
    </div>    
    <div id="FormLogin">
        <div id="divFormularioLogin" runat="server">
            <div id="divFormLogin">
                <div id="usuario"><div id="labelUsuario" class="label">Usuário: </div><div id="textboxUsuario"><asp:TextBox CssClass="textbox" ID="txtUsuario" runat="server"></asp:TextBox></div></div>
                <div id="senha"><div id="labelSenha" class="label">Senha: </div><div id="textboxSenha"><asp:TextBox TextMode="password" CssClass="textbox" ID="txtSenha" runat="server"></asp:TextBox></div></div>
                <div id="botaoLogin"><asp:Button ID="btnLogin" CssClass="button" runat="server" Text="Login" OnClick="btnLogin_Click" /></div>
            </div>
        </div>    
    </div>
</div>
</form>
</asp:Content>

