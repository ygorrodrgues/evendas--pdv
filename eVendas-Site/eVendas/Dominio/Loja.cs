using System;
using System.Collections.Generic;
using System.Text;

namespace Dominio
{
    public class Loja
    {
        private int idLoja;

        public int IdLoja
        {
            get { return idLoja; }
            set { idLoja = value; }
        }

        private string nome;

        public string Nome
        {
            get { return nome; }
            set { nome = value; }
        }

    }
}
