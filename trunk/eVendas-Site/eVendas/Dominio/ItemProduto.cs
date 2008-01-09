using System;
using System.Collections.Generic;
using System.Text;

namespace Dominio
{
    public class ItensProduto : List<ItemProduto>
    {
        public ItemProduto ItemProduto(int IdProduto)
        {
            foreach (ItemProduto itemProduto in this)
            {
                if (itemProduto.Produto.IdProduto == IdProduto)
                    return itemProduto;
            }
            return null;
        }
    }

    public class ItemProduto
    {
        private int idItemProduto;

        public int IdItemProduto
        {
            get { return idItemProduto; }
            set { idItemProduto = value; }
        }

        private int qtde;

        public int Qtde
        {
            get { return qtde; }
            set { qtde = value; }
        }

        private Produto produto;

        public Produto Produto
        {
            get { return produto; }
            set { produto = value; }
        }

        private Loja loja;

        public Loja Loja
        {
            get { return loja; }
            set { loja = value; }
        }

        private decimal precoItemProduto;

        public decimal PrecoItemProduto
        {
            get { return precoItemProduto; }
            set { precoItemProduto = value; }
        }
    }
}
