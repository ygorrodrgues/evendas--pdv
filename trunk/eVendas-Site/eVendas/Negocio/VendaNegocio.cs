using System;
using System.Collections.Generic;
using System.Text;
using System.Data;
using DAL;
using Dominio;

namespace Negocio
{
    public class VendaNegocio
    {
        public bool Inserir(Venda venda)
        {
            bool retorno = true;

            ItemVendaNegocio itemVendaNegocio = new ItemVendaNegocio();
            if (itemVendaNegocio.VerificaQuantidadeItensVenda(venda))
            {
                if (venda.Pagamento.TipoPagamento == (int)TipoPagamento.tipoPagamento.CARTAO)
                {
                    ParcelaNegocio parcelaNegocio = new ParcelaNegocio();
                    parcelaNegocio.GerarParcelas(venda);
                }
                VendaDAL dal = new VendaDAL();
                retorno = dal.Inserir(venda);
            }
            else
            {
                retorno = false;
            }

            return retorno;
        }
    }
}
