using System;
using System.Collections.Generic;
using System.Text;
using System.Data;
using DAL;

namespace Negocio
{
    public class CategoriaProdutoNegocio
    {
        public DataSet Select()
        {
            CategoriaProdutoDAL dal = new CategoriaProdutoDAL();

            return dal.Select();
        }        
    }
}
