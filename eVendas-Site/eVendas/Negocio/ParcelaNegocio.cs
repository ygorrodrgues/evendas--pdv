using System;
using System.Collections.Generic;
using System.Text;
using System.Data;
using DAL;
using Dominio;

namespace Negocio
{
    public class ParcelaNegocio
    {
        public bool GerarParcelas(Venda venda)
        {
            try
            {
                Parcelas parcelas = new Parcelas();
                Parcela parcela;

                for (int contador = 0; contador < venda.Pagamento.QtdeParcelas; contador++)
                {
                    parcela = new Parcela();

                    CartaoNegocio cartaoNegocio = new CartaoNegocio();
                    parcela.Cartao = cartaoNegocio.SelectCartaoPorCliente(venda.Cliente);
                    parcela.ValorVencimento = venda.Pagamento.ValorPagamento / venda.Pagamento.QtdeParcelas;
                    parcela.Pagamento = venda.Pagamento;

                    parcelas.Add(parcela);
                }

                venda.Pagamento.Parcelas = parcelas;
            }
            catch (Exception e)
            {
                return false;
            }
            
            return true;
        }
    }
}
