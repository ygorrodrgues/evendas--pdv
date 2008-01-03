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
    public class UsuarioDAL
    {
        private string strConexao = System.Configuration.ConfigurationSettings.AppSettings["conexao_banco"].ToString();

        public Usuario AutenticarUsuario(Usuario usuario)
        {
            SqlConnection con = new SqlConnection(strConexao);
            SqlCommand cmd = new SqlCommand("AutenticarUsuario", con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@login", usuario.Login);
            cmd.Parameters.AddWithValue("@senha", usuario.Senha);

            Usuario usuarioAutenticado = usuario;
            con.Open();
            try
            {
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr.Read())
                {
                    usuarioAutenticado.Email = dr["email"].ToString();
                    usuarioAutenticado.IdUsuario = int.Parse(dr["id_usuario"].ToString());
                }
                else
                {
                    usuarioAutenticado = null;
                }
            }
            catch (Exception e)
            {
                usuarioAutenticado = null;
            }
            finally
            {
                con.Close();
            }

            return usuarioAutenticado;
        }
    }
}
