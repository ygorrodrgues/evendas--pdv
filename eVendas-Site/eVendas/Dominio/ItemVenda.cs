using System;
using System.Collections.Generic;
using System.Text;

namespace Dominio
{
    public class ItensVenda : List<ItemVenda>
    {
        public ItemVenda ItemVenda(int IdProduto)
        {
            foreach (ItemVenda itemVenda in this)
            {
                if (itemVenda.ItemProduto.Produto.IdProduto == IdProduto)
                    return itemVenda;
            }
            return null;
        }
    }

    public class ItemVenda
    {
        private int id;

        public int Id
        {
            get { return id; }
            set { id = value; }
        }

        private int qtde;

        public int Qtde
        {
            get { return qtde; }
            set { qtde = value; }
        }

        private Venda venda;

        public Venda Venda
        {
            get { return venda; }
            set { venda = value; }
        }

        private ItemProduto itemProduto;

        public ItemProduto ItemProduto
        {
            get { return itemProduto; }
            set { itemProduto = value; }
        }
	
    }
}
