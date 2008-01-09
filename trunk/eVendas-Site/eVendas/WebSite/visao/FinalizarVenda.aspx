<%@ Page Language="C#" MasterPageFile="~/eVendas.master" AutoEventWireup="true" CodeFile="FinalizarVenda.aspx.cs" Inherits="visao_FinalizarVenda" Title="eVendas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<div id="ItensCompra">
<form id="form" runat="server">
    <div id="divItensCompra">
        <div id="divFormItensCompra" runat="server">
            <asp:GridView ID="GVItensCompra" runat="server" AutoGenerateColumns="False" CssClass="gridView" Width="760px" OnRowDataBound="GVItensCompra_RowDataBound" ShowFooter="True">
                <FooterStyle CssClass="gridViewFooterTotal" />
                <EmptyDataRowStyle CssClass="gridViewItem" />
                <Columns>
                    <asp:BoundField DataField="Nome" HeaderText="Nome" >
                        <ItemStyle HorizontalAlign="Left" />
                        <HeaderStyle HorizontalAlign="Left" />
                    </asp:BoundField>
                    <asp:BoundField DataField="quantidade" HeaderText="Quantidade" >
                        <ItemStyle HorizontalAlign="Right" />
                        <HeaderStyle HorizontalAlign="Right" />
                    </asp:BoundField>
                    <asp:BoundField DataField="custo" HeaderText="Valor Unit&#225;rio" >
                        <ItemStyle HorizontalAlign="Right" />
                        <HeaderStyle HorizontalAlign="Right" />
                    </asp:BoundField>
                    <asp:BoundField DataField="valorTotal" HeaderText="Valor Total" >
                        <ItemStyle HorizontalAlign="Right" />
                        <HeaderStyle HorizontalAlign="Right" />
                    </asp:BoundField>
                </Columns>
                <RowStyle CssClass="gridViewItem" />
                <EditRowStyle CssClass="gridViewItem" />
                <SelectedRowStyle CssClass="gridViewItem" />
                <PagerStyle CssClass="gridViewItem" />
                <HeaderStyle CssClass="gridViewHeader" />
            </asp:GridView>
            <div id="divEndereco" class="divCaixa">
                <asp:Label ID="lblTituloEndereco" runat="server" Text="ENDEREÇO DE ENTREGA" CssClass="labelTitulo"></asp:Label><br />
                <asp:Label ID="lblNome" runat="server" CssClass="labelTitulo"></asp:Label><br />
                <asp:Label ID="lblLogradouro" runat="server" Text=""></asp:Label><br />
                <asp:Label ID="lblMunicipio" runat="server" Text=""></asp:Label>
            </div>
            <div id="divPagamento" class="divCaixa">
                <asp:Label ID="lblTituloPagamento" runat="server" Text="ESCOLHA A FORMA DE PAGAMENTO" CssClass="labelTitulo"></asp:Label><br /><br />
                <asp:CustomValidator ID="validaPagamento" runat="server" ErrorMessage="* Selecione uma Forma de Pagamento!" OnServerValidate="validaPagamento_ServerValidate" CssClass="labelMensagem"></asp:CustomValidator><br />
                <asp:RadioButton ID="rbBoleto" runat="server" GroupName="formaPagamento" Text="" AutoPostBack="True" OnCheckedChanged="rbBoleto_CheckedChanged" /><asp:Image ID="imgBoleto" runat="server" ImageUrl="~/images/boleto_bancario.png" AlternateText="Boleto Bancário" ImageAlign="middle"/>
                <asp:RadioButton ID="rbCartao" runat="server" GroupName="formaPagamento" Text="" AutoPostBack="True" OnCheckedChanged="rbCartao_CheckedChanged" /><asp:Image ID="imgCartao" runat="server" ImageUrl="~/images/cartao_evendas.png" AlternateText="Cartão eVendas" ImageAlign="middle"/>
                <asp:DropDownList ID="ddlParcelas" runat="server" Enabled="False">
                    <asp:ListItem Selected="True" Value="0">Parcelas</asp:ListItem>
                    <asp:ListItem Value="3">3x</asp:ListItem>
                    <asp:ListItem Value="6">6x</asp:ListItem>
                    <asp:ListItem Value="9">9x</asp:ListItem>
                </asp:DropDownList>
            </div>
            &nbsp; &nbsp;
            <div id="divFecharPedido">
                <asp:ImageButton ID="imgFecharPedido" runat="server" ImageUrl="~/images/fechar_pedido.png"/>
            </div>         
        </div>        
    </div>
</form>
</div>
</asp:Content>

