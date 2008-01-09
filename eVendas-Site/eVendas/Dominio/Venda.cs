using System;
using System.Collections.Generic;
using System.Text;

namespace Dominio
{
    public class Venda
    {
        private int idVenda;

        public int IdVenda
        {
            get { return idVenda; }
            set { idVenda = value; }
        }

        private Cliente cliente;

        public Cliente Cliente
        {
            get { return cliente; }
            set { cliente = value; }
        }

        private DateTime data;

        public DateTime Data
        {
            get { return data; }
            set { data = value; }
        }

        private ItensVenda itensVenda;

        public ItensVenda ItensVenda
        {
            get { return itensVenda; }
            set { itensVenda = value; }
        }

        private Pagamento pagamento;

        public Pagamento Pagamento
        {
            get { return pagamento; }
            set { pagamento = value; }
        }
    }
}
