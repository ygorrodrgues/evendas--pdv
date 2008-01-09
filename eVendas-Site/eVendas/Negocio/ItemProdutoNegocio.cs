using System;
using System.Collections.Generic;
using System.Text;
using Dominio;
using DAL;

namespace Negocio
{
    public class ItemProdutoNegocio
    {
        public ItemProduto VerificaQuantidade(Produto produto, int qtd)
        {
            ItemProdutoDAL itemProdutoDal = new ItemProdutoDAL();
            ItemProduto itemProduto = itemProdutoDal.VerificaQuantidade(produto, qtd);

            return itemProduto;
        }
    }
}
