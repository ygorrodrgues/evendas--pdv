using System;
using System.Collections.Generic;
using System.Text;

namespace Dominio
{
    public class Usuario
    {
        private int idUsuario;

        public int IdUsuario
        {
            get { return idUsuario; }
            set { idUsuario = value; }
        }

        private string login;

        public string Login
        {
            get { return login; }
            set { login = value; }
        }

        private string senha;

        public string Senha
        {
            get { return senha; }
            set { senha = value; }
        }

        private string email;

        public string Email
        {
            get { return email; }
            set { email = value; }
        }
    }
}
