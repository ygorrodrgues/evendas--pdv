<%@ Page Language="C#" MasterPageFile="~/eVendas.master" AutoEventWireup="true" CodeFile="index.aspx.cs" Inherits="visao_index" Title="eVendas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<form id="form" runat="server">
    <div id="opcoes">
        <div id="carrinho" class="div_titulo">
            <p id="ptitulo" class="p_titulo"><a href="Carrinho.aspx"><img src="../images/carrinho.gif" alt="Carrinho"/> <asp:Label ID="lblQtdCarrinho" runat="server" Text="0"></asp:Label> produto(s) no seu carrinho</a></p>
        </div>
        <div id="categoria">
            <asp:Repeater ID="menuCategorias" runat="server">
                <HeaderTemplate>
                    <div id="titulo_categoria"><p>Categorias de Produtos</p></div>
                    <div id="item_categoria">
                        <ul>
                </HeaderTemplate>
                <ItemTemplate>
                    <li><%# DataBinder.Eval(Container.DataItem, "descricao_categoria")%></li>
                </ItemTemplate>
                <FooterTemplate>
                        </ul>
                    </div>
                </FooterTemplate>
            </asp:Repeater>
        </div>
        <div id="login">
            <div id="titulo_login" class="div_titulo">
                <p class="p_titulo"><img src="../images/icn_seta_grd.png" class="img_titulo" alt=""/> Login de Usuário</p>
            </div>
            <div>
                    <div id="divFormLogin">                    
                            <div id="usuario"><div id="labelUsuario" class="label">Usuário: </div><div id="textboxUsuario"><asp:TextBox CssClass="textbox" ID="txtUsuario" runat="server"></asp:TextBox></div></div>
                            <div id="senha"><div id="labelSenha" class="label">Senha: </div><div id="textboxSenha"><asp:TextBox CssClass="textbox" ID="txtSenha" runat="server"></asp:TextBox></div></div>
                            <div id="botaoLogin"><asp:Button ID="btnLogin" CssClass="button" runat="server" Text="Login" /></div>
                    </div>
            </div>
        </div>
        <div id="promocao">
            <div id="titulo_promocao" class="div_titulo">
                <p class="p_titulo"><img src="../images/icn_seta_grd.png" class="img_titulo" alt=""/> Promoção do Dia</p>
            </div>
            <div>
                    <div id="imageProduto"><asp:Image ID="imgProduto" runat="server" ImageUrl="~/images/produtos/tv_lcd_gradiente_promocao.jpg" /></div>
                    <div id="labelProduto"><asp:Label ID="lblProduto" CssClass="label" runat="server" Text='TV LCD 20" GRADIENTE (LCD2030)'></asp:Label></div>
                    <div id="labelDePor"><div id="lblDe" class="label">De:</div><div id="lblPor" class="label">Por:</div></div>
                    <div id="labelPrecoDePor">
                        <div id="divLblPrecoDe" class="label">
                            <asp:Label ID="lblPrecoDe" runat="server" Text="R$ 2.099,00"></asp:Label>
                        </div>
                        <div id="divLblPrecoPor" class="label">
                            <asp:Label ID="lblPrecoPor" runat="server" Text="R$ 1.099,00"></asp:Label>
                        </div>
                    </div>
            </div>
        </div>
    </div>
    <div id="conteudo">
        <div class="div_titulo">
            <p class="p_titulo"><img src="../images/icn_seta_grd.png" class="img_titulo" alt=""/> Destaques</p>
        </div>
        <div id="itensDestaque"> 
            <asp:Repeater ID="catalogo" runat="server">
                <HeaderTemplate>
                    <div class="itensDestaque">                        
                </HeaderTemplate>

                <ItemTemplate>
                    <div class="itemDestaque"> 
                        <div class="itemDestaqueHeader"><%# DataBinder.Eval(Container.DataItem, "nome_produto")%></div>
                        <div>
                            <div class="itemDestaqueImagem"><asp:Image ID="imgProduto" runat="server" ImageUrl='<%# DataBinder.Eval(Container.DataItem, "url_Imagem")%>' /></div>
                            <div class="itemDestaqueDescricao">
                                <div class="itemDestaqueDescricaoTitulo"><%# DataBinder.Eval(Container.DataItem, "nome_produto")%></div>
                                <div class="itemDestaqueDescricaoTexto"><%# DataBinder.Eval(Container.DataItem, "descricao")%></div>
                            </div>
                        </div>
                        <div class="itemDestaqueFooter">
                            <div class="itemDestaqueFooterPrice">R$: <%# DataBinder.Eval(Container.DataItem, "custo")%></div>
                            <div class="itemDestaqueFooterDetalhes">
                                <div class="divBtnAdicionarCarrinho"><asp:ImageButton ID="btnAdicionarCarrinho" ImageUrl="~/images/btn_adicionar_carrinho.png" runat="server" CommandName="id" CommandArgument='<%# DataBinder.Eval(Container.DataItem, "id_produto")%>' OnCommand="btnAdicionarCarrinho_Command" /></div>
                                <div class="divBtnDetalhes"><asp:ImageButton ID="btnDetalhes" ImageUrl="~/images/btn_detalhes.png" runat="server" /></div>
                            </div>
                        </div>
                    </div>
                 </ItemTemplate>

                <FooterTemplate>
                    </div>
                </FooterTemplate>
            </asp:Repeater>
        </div>
    </div>
    <div id="gambiarra"></div>
</form>
</asp:Content>