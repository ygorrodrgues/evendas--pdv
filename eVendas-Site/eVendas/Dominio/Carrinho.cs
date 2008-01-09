using System;
using System.Collections.Generic;
using System.Text;

namespace Dominio
{
    public class Carrinho
    {
        private ItensVenda listaItemVenda;

        public ItensVenda ListaItemVenda
        {
            get 
            {
                if (listaItemVenda == null)
                    listaItemVenda = new ItensVenda();

                return listaItemVenda; 
            }
            set { listaItemVenda = value; }
        }	
    }
}
