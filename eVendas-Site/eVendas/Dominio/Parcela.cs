using System;
using System.Collections.Generic;
using System.Text;

namespace Dominio
{
    public class Parcelas : List<Parcela>
    {
    }

    public class Parcela
    {
        private int idParcela;

        public int IdParcela
        {
            get { return idParcela; }
            set { idParcela = value; }
        }

        private Pagamento pagamento;

        public Pagamento Pagamento
        {
            get { return pagamento; }
            set { pagamento = value; }
        }

        private Cartao cartao;

        public Cartao Cartao
        {
            get { return cartao; }
            set { cartao = value; }
        }

        private DateTime dataVencimento;

        public DateTime DataVencimento
        {
            get { return dataVencimento; }
            set { dataVencimento = value; }
        }

        private decimal valorVencimento;

        public decimal ValorVencimento
        {
            get { return valorVencimento; }
            set { valorVencimento = value; }
        }

        private DateTime dataPagamento;

        public DateTime DataPagamento
        {
            get { return dataPagamento; }
            set { dataPagamento = value; }
        }

        private decimal valorPagamento;

        public decimal ValorPagamento
        {
            get { return valorPagamento; }
            set { valorPagamento = value; }
        }
    }
}
