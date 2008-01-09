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
    public class ClienteDAL
    {
        private string strConexao = System.Configuration.ConfigurationSettings.AppSettings["conexao_banco"].ToString();

        public DataSet SelectEndereco(Usuario usuario)
        {
            SqlConnection con = new SqlConnection(strConexao);
            string sql = "SELECT * FROM SelectClienteEndereco WHERE id_usuario = "+usuario.IdUsuario;
            SqlCommand cmd = new SqlCommand(sql, con);
            SqlDataAdapter da = new SqlDataAdapter(cmd);
            DataSet ds = new DataSet();
            da.Fill(ds);
            return ds;
        }

        public Cliente SelectPorUsuario(Usuario usuario)
        {
            SqlConnection con = new SqlConnection(strConexao);
            string sql = "SELECT * FROM SelectClientePorUsuario WHERE id_usuario = " + usuario.IdUsuario;
            SqlCommand cmd = new SqlCommand(sql, con);

            Cliente cliente = new Cliente();
            con.Open();

            try
            {
                SqlDataReader dr = cmd.ExecuteReader();

                if (dr.Read())
                {
                    cliente.IdCliente = int.Parse(dr["id_cliente"].ToString());
                    cliente.Nome = dr["nome_cliente"].ToString();
                    cliente.CPF = dr["cpf"].ToString();
                    cliente.Usuario = usuario;
                }
                else
                {
                    cliente = null;
                }
            }
            finally
            {
                con.Close();
            }

            return cliente;
        }
    }
}
