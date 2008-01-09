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
    public class ProdutoDAL
    {
        private string strConexao = System.Configuration.ConfigurationSettings.AppSettings["conexao_banco"].ToString();

        public DataSet Select()
        {
            SqlConnection con = new SqlConnection(strConexao);
            string sql = "SELECT * FROM SelectProdutoEmEstoque";
            SqlCommand cmd = new SqlCommand(sql, con);
            SqlDataAdapter da = new SqlDataAdapter(cmd);
            DataSet ds = new DataSet();
            da.Fill(ds);
            return ds;
        }

        public Produto Select(Produto produto)
        {
            SqlConnection con = new SqlConnection(strConexao);
            string sql = "SELECT * FROM SelectProduto WHERE ID_PRODUTO = "+produto.IdProduto;
            SqlCommand cmd = new SqlCommand(sql, con);

            con.Open();

            try
            {
                SqlDataReader dr = cmd.ExecuteReader();

                if (dr.Read())
                {
                    produto.Descricao = dr["descricao_produto"].ToString();
                    produto.Custo = decimal.Parse(dr["custo"].ToString());
                    produto.UrlImagem = dr["Imagem_caminho"].ToString();
                    produto.Nome = dr["nome_produto"].ToString();
                }
                else
                {
                    produto = null;
                }
            }
            finally
            {
                con.Close();
            }

            return produto;
        }
    }
}
