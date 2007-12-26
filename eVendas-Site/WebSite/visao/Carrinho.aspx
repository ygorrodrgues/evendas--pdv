<%@ Page Language="C#" MasterPageFile="~/eVendas.master" AutoEventWireup="true" CodeFile="Carrinho.aspx.cs" Inherits="visao_Carrinho" Title="eVendas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<div id="divCarrinho">
    <div id="divFormCarrinho">
        <form id="form" runat="server">
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" CssClass="gridView" Width="760px" OnRowDataBound="GridView1_RowDataBound" ShowFooter="True">
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
                            <asp:ImageButton ID="removerQuantidade" runat="server" ImageUrl="~/images/remover.png" OnCommand="removerQuantidade_Command"  CommandName="produto" CommandArgument='<%# DataBinder.Eval(Container.DataItem, "IdProduto")%>'/>
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
        </form>
    </div>    
</div>
</asp:Content>

