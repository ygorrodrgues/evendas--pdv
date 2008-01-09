using System;
using System.Collections.Generic;
using System.Text;
using Dominio;
using DAL;

namespace Negocio
{
    public class ItemVendaNegocio
    {
        public bool VerificaQuantidadeItensVenda(Venda venda)
        {
            bool retorno = true;

            ItemProdutoNegocio itemProdutoNegocio = new ItemProdutoNegocio();
            ItemProduto itemProduto;
            
            foreach (ItemVenda itemVenda in venda.ItensVenda)
            {
                itemProduto = itemProdutoNegocio.VerificaQuantidade(itemVenda.ItemProduto.Produto, itemVenda.Qtde);

                if (itemProduto.Qtde != itemVenda.Qtde)
                {
                    return false;   
                }
            }

            return retorno;
        }
    }
}
