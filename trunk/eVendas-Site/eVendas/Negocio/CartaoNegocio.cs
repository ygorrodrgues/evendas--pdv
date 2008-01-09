using System;
using System.Collections.Generic;
using System.Text;
using System.Data;
using DAL;
using Dominio;

namespace Negocio
{
    public class CartaoNegocio
    {
        public Cartao SelectCartaoPorCliente(Cliente cliente)
        {
            CartaoDAL cartaoDal = new CartaoDAL();
            return cartaoDal.SelectCartaoPorCliente(cliente);
        }
    }
}
