using System;
using System.Collections.Generic;
using System.Text;
using Dominio;

namespace Negocio
{
    public class CarrinhoNegocio
    {
        public int AdicionarProduto(Carrinho carrinho, Produto produto, int qtde, bool atualizar)
        {
            int qtdeAtualizada = -1;

            ProdutoNegocio produtoNegocio = new ProdutoNegocio();
            produto = produtoNegocio.Select(produto);

            if (produto != null)
            {
                ItemVenda itemVendaNovo = new ItemVenda();

                ItemProdutoNegocio itemProdutoNegocio = new ItemProdutoNegocio();
                itemVendaNovo.ItemProduto = itemProdutoNegocio.VerificaQuantidade(produto, qtde);
                itemVendaNovo.Qtde = itemVendaNovo.ItemProduto.Qtde;

                if (itemVendaNovo.ItemProduto != null)
                {
                    qtdeAtualizada = itemVendaNovo.Qtde;
                    carrinho = AdicionarItemVenda(carrinho, itemVendaNovo, atualizar);
                }
                
            }
            return qtdeAtualizada;
        }

        private Carrinho AdicionarItemVenda(Carrinho carrinho, ItemVenda itemVendaNovo, bool atualizar)
        {
            ItensVenda itensVenda = carrinho.ListaItemVenda;
            ItemVenda itemVenda = itensVenda.ItemVenda(itemVendaNovo.ItemProduto.Produto.IdProduto);
            int indice = itensVenda.IndexOf(itemVenda);

            if (indice == -1)
            {
                itensVenda.Add(itemVendaNovo);
            }
            else if (indice >= 0 && atualizar && itemVendaNovo.Qtde > 0)
            {
                itensVenda.RemoveAt(indice);
                itensVenda.Insert(indice, itemVendaNovo);
            }
            else if (indice >= 0 && itemVendaNovo.Qtde == 0)
            {
                carrinho = RemoverItemVenda(carrinho, itemVenda);
            }
            
            return carrinho;
        }

        public Carrinho RemoverItemVenda(Carrinho carrinho, ItemVenda itemVenda)
        {
            ItensVenda itensVenda = carrinho.ListaItemVenda;
            itensVenda.Remove(itemVenda);

            return carrinho;
        }

        public ItemVenda RecuperarItemVenda(Carrinho carrinho, Produto produto)
        {
            ItensVenda itensVenda = carrinho.ListaItemVenda;
            ItemVenda itemVenda = itensVenda.ItemVenda(produto.IdProduto);

            return itemVenda;
        }
    }
}
