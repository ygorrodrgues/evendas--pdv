using System;
using System.Collections.Generic;
using System.Text;
using Dominio;
using System.Data;
using System.Web.UI.WebControls;

namespace Negocio
{
    public class CarrinhoNegocio
    {
        public static void ListarGrid(GridView gv, Carrinho carrinho)
        {
            DataSet carrinhoSource = new DataSet();

            DataTable tabela = new DataTable();

            tabela.Columns.Add("Imagem");
            tabela.Columns.Add("Descricao");
            tabela.Columns.Add("Preco");
            tabela.Columns.Add("Qtde");
            tabela.Columns.Add("IdProduto");
            tabela.Columns.Add("ValorTotal");

            foreach (ItemVenda itemVenda in carrinho.ListaItemVenda)
            {
                decimal valorTotal = itemVenda.Qtde * itemVenda.Produto.Preco;
                tabela.Rows.Add(itemVenda.Produto.UrlImagem, itemVenda.Produto.Descricao, itemVenda.Produto.Preco.ToString("C2"), itemVenda.Qtde, itemVenda.Produto.IdProduto, valorTotal.ToString("C2"));
            }

            carrinhoSource.Tables.Add(tabela);

            gv.DataSource = carrinhoSource;
            gv.DataBind();
        }

        public Carrinho AdicionarItemVenda(Carrinho carrinho, int IdProduto, int qtde)
        {
            if (qtde > 0)
            {
                ItensVenda itensVenda = carrinho.ListaItemVenda;
                ItemVenda itemVenda = itensVenda.ItemVenda(IdProduto);
                int indice = itensVenda.IndexOf(itemVenda);
                itensVenda.RemoveAt(indice);
                itemVenda.Qtde = qtde;
                itensVenda.Insert(indice, itemVenda);
            }
            else
            {
                RemoverItemVenda(carrinho, IdProduto);
            }           

            return carrinho;
        }

        public Carrinho RemoverItemVenda(Carrinho carrinho, int IdProduto)
        {
            ItensVenda itensVenda = carrinho.ListaItemVenda;
            ItemVenda itemVenda = itensVenda.ItemVenda(IdProduto);
            itensVenda.Remove(itemVenda);

            return carrinho;
        }
    }
}
