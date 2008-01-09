using System;
using System.Collections.Generic;
using System.Text;

namespace Dominio
{
    public class Cartao
    {
        private int idCartao;

        public int IdCartao
        {
            get { return idCartao; }
            set { idCartao = value; }
        }

        private Cliente cliente;

        public Cliente Cliente
        {
            get { return cliente; }
            set { cliente = value; }
        }

        private decimal limite;

        public decimal Limite
        {
            get { return limite; }
            set { limite = value; }
        }

    }
}
