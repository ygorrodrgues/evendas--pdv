using System;
using System.Collections.Generic;
using System.Text;

namespace Dominio
{
    public class Cliente
    {
        private int idCliente;

        public int IdCliente
        {
            get { return idCliente; }
            set { idCliente = value; }
        }

        private string nome;

        public string Nome
        {
            get { return nome; }
            set { nome = value; }
        }

        private string cpf;

        public string CPF
        {
            get { return cpf; }
            set { cpf = value; }
        }

        private Usuario usuario;

        public Usuario Usuario
        {
            get { return usuario; }
            set { usuario = value; }
        }
    }
}
