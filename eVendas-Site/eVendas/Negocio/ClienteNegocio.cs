using System;
using System.Collections.Generic;
using System.Text;
using System.Data;
using DAL;
using Dominio;

namespace Negocio
{
    public class ClienteNegocio
    {
        public DataSet SelectEndereco(Usuario usuario)
        {
            ClienteDAL dal = new ClienteDAL();
            return dal.SelectEndereco(usuario);
        }

        public Cliente SelectPorUsuario(Usuario usuario)
        {
            ClienteDAL dal = new ClienteDAL();
            return dal.SelectPorUsuario(usuario);
        }
    }
}
