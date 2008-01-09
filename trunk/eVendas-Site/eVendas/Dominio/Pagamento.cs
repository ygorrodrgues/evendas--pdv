using System;
using System.Collections.Generic;
using System.Text;

namespace Dominio
{
    public class Pagamento
    {
        private int idPagamento;

        public int IdPagamento
        {
            get { return idPagamento; }
            set { idPagamento = value; }
        }

        private int tipoPagamento;

        public int TipoPagamento
        {
            get { return tipoPagamento; }
            set { tipoPagamento = value; }
        }

        private Venda venda;

        public Venda Venda
        {
            get { return venda; }
            set { venda = value; }
        }

        private decimal valorPagamento;

        public decimal ValorPagamento
        {
            get { return valorPagamento; }
            set { valorPagamento = value; }
        }

        private Parcelas parcelas;

        public Parcelas Parcelas
        {
            get { return parcelas; }
            set { parcelas = value; }
        }

        private int qtdeParcelas;

        public int QtdeParcelas
        {
            get { return qtdeParcelas; }
            set { qtdeParcelas = value; }
        }

    }
}
