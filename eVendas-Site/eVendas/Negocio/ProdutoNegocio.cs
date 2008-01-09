using System;
using System.Collections.Generic;
using System.Text;
using System.Data;
using DAL;
using Dominio;

namespace Negocio
{
    public class ProdutoNegocio
    {
        public DataSet Select()
        {
            ProdutoDAL dal = new ProdutoDAL();
            return dal.Select();
        }

        public Produto Select(Produto produto)
        {
            ProdutoDAL dal = new ProdutoDAL();
            return dal.Select(produto);
        }
    }
}
