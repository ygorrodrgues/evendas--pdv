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

public partial class visao_FinalizarVenda : System.Web.UI.Page
{
    private const int ClnValorUnitario = 2;
    private const int ClnValorTotal = 3;
    private decimal total = 0;

    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            if (Session["usuario"] == null && ((Carrinho)Session["carrinho"]).ListaItemVenda.Count > 0)
            {
                Response.Redirect("Carrinho.aspx");
            }
            else if (((Carrinho)Session["carrinho"]).ListaItemVenda.Count == 0)
            {
                Response.Redirect("index.aspx");
            }
            ListarItensCompra();
            ListarDadosCliente();
        }
    }

    private void ListarItensCompra()
    {
        try
        {
            Carrinho carrinho = (Carrinho)Session["carrinho"];

            DataSet carrinhoSource = new DataSet();

            DataTable tabela = new DataTable();

            tabela.Columns.Add("Nome");
            tabela.Columns.Add("quantidade");
            tabela.Columns.Add("custo");
            tabela.Columns.Add("valorTotal");

            if (carrinho.ListaItemVenda.Count == 0)
            {
                throw new Exception();
            }

            foreach (ItemVenda itemVenda in carrinho.ListaItemVenda)
            {
                decimal valorTotal = itemVenda.Qtde * itemVenda.ItemProduto.PrecoItemProduto;
                tabela.Rows.Add(itemVenda.ItemProduto.Produto.Nome, itemVenda.Qtde, itemVenda.ItemProduto.PrecoItemProduto.ToString("C2"), valorTotal.ToString("C2"));
            }

            carrinhoSource.Tables.Add(tabela);

            GVItensCompra.DataSource = carrinhoSource;
            GVItensCompra.DataBind();            
        }
        catch (Exception e)
        {
            
        }
    }

    private void ListarDadosCliente()
    {
        ClienteNegocio clienteNegocio = new ClienteNegocio();
        Usuario usuario = (Usuario)Session["usuario"];
        DataSet ds = clienteNegocio.SelectEndereco(usuario);

        string nome = ds.Tables[0].Rows[0].ItemArray.GetValue(1).ToString();
        string logradouro = ds.Tables[0].Rows[0].ItemArray.GetValue(4).ToString() + ", " +
                            ds.Tables[0].Rows[0].ItemArray.GetValue(6).ToString() + " - " +
                            ds.Tables[0].Rows[0].ItemArray.GetValue(5).ToString();

        string municipio = ds.Tables[0].Rows[0].ItemArray.GetValue(7).ToString() + " - " +
                            ds.Tables[0].Rows[0].ItemArray.GetValue(8).ToString() + " - " +
                            ds.Tables[0].Rows[0].ItemArray.GetValue(9).ToString();


        lblNome.Text = nome;
        lblLogradouro.Text = logradouro;
        lblMunicipio.Text = municipio;
    }

    protected void GVItensCompra_RowDataBound(object sender, GridViewRowEventArgs e)
    {
        if (e.Row.RowType == DataControlRowType.DataRow)
        {
            decimal valorTotal = decimal.Parse(e.Row.Cells[ClnValorTotal].Text.Substring(2));
            total += valorTotal;
        }
        if (e.Row.RowType == DataControlRowType.Footer)
        {
            e.Row.Cells[ClnValorUnitario].Text = "TOTAL";
            e.Row.Cells[ClnValorTotal].Text = total.ToString("C2");
        }
    }

    protected void validaPagamento_ServerValidate(object source, ServerValidateEventArgs args)
    {
        args.IsValid = true;

        if (!rbBoleto.Checked && !rbCartao.Checked)
        {
            args.IsValid = false;
        }
        else if (rbCartao.Checked && ddlParcelas.SelectedIndex == 0)
        {
            validaPagamento.Text = "Selecione a quantidade de Parcelas";
            args.IsValid = false;
        }
        else
        {
            ClienteNegocio clienteNegocio = new ClienteNegocio();
            
            Pagamento pagamento = new Pagamento();
            Venda venda = new Venda();

            venda.ItensVenda = ((Carrinho)Session["carrinho"]).ListaItemVenda;
            venda.Cliente = clienteNegocio.SelectPorUsuario((Usuario)Session["usuario"]);

            pagamento.Venda = venda;
            pagamento.ValorPagamento = decimal.Parse(GVItensCompra.FooterRow.Cells[3].Text.Substring(2));

            if (rbBoleto.Checked)
            {
                pagamento.TipoPagamento = (int)TipoPagamento.tipoPagamento.DINHEIRO;
            }
            else
            {
                pagamento.TipoPagamento = (int)TipoPagamento.tipoPagamento.CARTAO;
                pagamento.QtdeParcelas = int.Parse(ddlParcelas.SelectedValue);
            }

            venda.Pagamento = pagamento;

            VendaNegocio vendaNegocio = new VendaNegocio();
            if (!vendaNegocio.Inserir(venda))
            {
                Response.Redirect("Carrinho.aspx?listar=1");
            }
            else
            {
                Session.Remove("carrinho");
                Response.Redirect("VendaFinalizada.aspx");
            }            
        }
    }
    protected void rbBoleto_CheckedChanged(object sender, EventArgs e)
    {
        if (rbBoleto.Checked)
        {
            ddlParcelas.SelectedIndex = 0;
            ddlParcelas.Enabled = false;
        }
        else
        {
            ddlParcelas.SelectedIndex = 0;
            ddlParcelas.Enabled = true;
        }
    }
    protected void rbCartao_CheckedChanged(object sender, EventArgs e)
    {
        if (!rbCartao.Checked)
        {
            ddlParcelas.SelectedIndex = 0;
            ddlParcelas.Enabled = false;
        }
        else
        {
            ddlParcelas.SelectedIndex = 0;
            ddlParcelas.Enabled = true;
        }
    }
}
