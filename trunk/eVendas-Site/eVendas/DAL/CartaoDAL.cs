using System;
using System.Collections.Generic;
using System.Text;
using System.Data;
using System.Web;
using System.Configuration;
using System.Data.Sql;
using System.Data.SqlClient;
using Dominio;

namespace DAL
{
    public class CartaoDAL
    {
        private string strConexao = System.Configuration.ConfigurationSettings.AppSettings["conexao_banco"].ToString();

        public Cartao SelectCartaoPorCliente(Cliente cliente)
        {
            SqlConnection con = new SqlConnection(strConexao);
            string sql = "SELECT * FROM SelectCartaoPorCliente WHERE ID_CLIENTE = " + cliente.IdCliente;
            SqlCommand cmd = new SqlCommand(sql, con);

            con.Open();
            Cartao cartao;
            try
            {
                SqlDataReader dr = cmd.ExecuteReader();

                if (dr.Read())
                {
                    cartao = new Cartao();
                    cartao.Cliente = cliente;
                    cartao.IdCartao = int.Parse(dr["id_cartao"].ToString());
                    cartao.Limite = decimal.Parse(dr["limite"].ToString());
                }
                else
                {
                    cartao = null;
                }
            }
            finally
            {
                con.Close();
            }

            return cartao;
        }
    }
}
