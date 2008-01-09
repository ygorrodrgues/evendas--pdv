using System;
using System.Collections.Generic;
using System.Text;
using Dominio;
using System.Data;
using System.Web;
using System.Configuration;
using System.Data.Sql;
using System.Data.SqlClient;

namespace DAL
{
    public class LojaDAL
    {
        private string strConexao = System.Configuration.ConfigurationSettings.AppSettings["conexao_banco"].ToString();

        public Loja SelectLojaWeb()
        {
            Loja loja;
            SqlConnection con = new SqlConnection(strConexao);
            string sql = "SELECT ID_LOJA FROM Loja WHERE NOME_LOJA = 'WEB'";
            SqlCommand cmd = new SqlCommand(sql, con);

            con.Open();

            try
            {
                loja = new Loja();
                loja.IdLoja = int.Parse(cmd.ExecuteScalar().ToString());
                loja.Nome = "WEB";
            }
            catch
            {
                loja = null;
            }
            finally
            {
                con.Close();
            }

            return loja;
        }
    }
}
