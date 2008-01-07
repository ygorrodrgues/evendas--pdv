using System;
using System.Collections.Generic;
using System.Text;
using System.Data;
using DAL;
using Dominio;

namespace Negocio
{
    public class UsuarioNegocio
    {
        public Usuario AutenticarUsuario(Usuario usuario)
        {
            UsuarioDAL dal = new UsuarioDAL();
            return dal.AutenticarUsuario(usuario);
        }
    }
}
