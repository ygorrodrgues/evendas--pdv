<%@ Page Language="C#" MasterPageFile="~/eVendas.master" AutoEventWireup="true" CodeFile="Carrinho.aspx.cs" Inherits="visao_Carrinho" Title="eVendas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<form id="form" runat="server">
    <div id="divCarrinho">
        <div id="divFormCarrinho" runat="server">
                <asp:GridView ID="GVCarrinho" runat="server" AutoGenerateColumns="False" CssClass="gridView" Width="760px" OnRowDataBound="GridView1_RowDataBound" ShowFooter="True">
                    <Columns>
                        <asp:ImageField DataImageUrlField="Imagem" InsertVisible="False">
                            <ControlStyle Height="50px" Width="50px" />
                            <ItemStyle HorizontalAlign="Center" />
                        </asp:ImageField>
                        <asp:BoundField DataField="Descricao" HeaderText="Descri&#231;&#227;o" >
                            <HeaderStyle HorizontalAlign="Left" />
                        </asp:BoundField>
                        <asp:TemplateField HeaderText="Quantidade">
                            <ItemTemplate>                         
                                <asp:TextBox ID="txtQuantidade" runat="server" CssClass="textboxQtde" Width="50px"></asp:TextBox><asp:ImageButton CssClass="imgCenter" ID="atualizarQuantidade" runat="server" ImageUrl="~/images/atualizar.png" OnCommand="atualizarQuantidade_Command" CommandName="produto" CommandArgument='<%# DataBinder.Eval(Container.DataItem, "IdProduto")%>'/>
                            </ItemTemplate>
                            <ItemStyle HorizontalAlign="Left" />
                            <HeaderStyle HorizontalAlign="Left" />
                        </asp:TemplateField>
                        <asp:TemplateField HeaderText="Remover Item">
                            <ItemTemplate>
                                <asp:ImageButton ID="removerItemVenda" runat="server" ImageUrl="~/images/remover.png" CommandName="produto" CommandArgument='<%# DataBinder.Eval(Container.DataItem, "IdProduto")%>' OnCommand="removerItemVenda_Command"/>
                            </ItemTemplate>
                            <ItemStyle HorizontalAlign="Center" />
                            <HeaderStyle HorizontalAlign="Center" />
                        </asp:TemplateField>
                        <asp:BoundField DataField="Preco" HeaderText="Valor Unit&#225;rio" >
                            <ItemStyle HorizontalAlign="Right" />
                            <HeaderStyle HorizontalAlign="Right" />
                        </asp:BoundField>
                        <asp:BoundField HeaderText="Valor Total" DataField="ValorTotal">
                            <ItemStyle HorizontalAlign="Right" />
                            <HeaderStyle HorizontalAlign="Right" />
                        </asp:BoundField>
                        <asp:BoundField DataField="Qtde" HeaderText="Qtde" Visible="False" />
                    </Columns>
                    <EmptyDataRowStyle CssClass="gridViewItem" />
                    <RowStyle CssClass="gridViewItem" />
                    <EditRowStyle CssClass="gridViewItem" />
                    <SelectedRowStyle CssClass="gridViewItem" />
                    <PagerStyle CssClass="gridViewItem" />
                    <HeaderStyle CssClass="gridViewHeader" />
                    <FooterStyle CssClass="gridViewFooterTotal" />                
                </asp:GridView>  
        </div>
        <div id="labelMensagem" runat="server">
            <asp:Label ID="lblMensagem" runat="server" Text="Não há itens no carrinho." CssClass="labelMensagem"></asp:Label>
            <br /><br />
            <asp:ImageButton ID="imgVoltarALoja" runat="server" ImageUrl="~/images/voltar_loja.png" OnClick="imgVoltarALoja_Click"/>
        </div>
    </div>
</form>
</asp:Content>

