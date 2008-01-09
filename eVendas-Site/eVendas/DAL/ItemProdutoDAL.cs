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
    public class ItemProdutoDAL
    {
        private string strConexao = System.Configuration.ConfigurationSettings.AppSettings["conexao_banco"].ToString();

        public ItemProduto VerificaQuantidade(Produto produto, int qtd)
        {
            LojaDAL lojaDal = new LojaDAL();
            Loja lojaWeb = lojaDal.SelectLojaWeb();

            SqlConnection con = new SqlConnection(strConexao);
            SqlCommand cmd = new SqlCommand("sp_selectitemprodutobycodigoproduto", con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@codProduto", produto.IdProduto);
            cmd.Parameters.AddWithValue("@idLoja", lojaWeb.IdLoja);

            ItemProduto itemProduto = new ItemProduto();
            con.Open();
            try
            {
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr.Read())
                {
                    int qtdeAtual = int.Parse(dr["qtd_item_produto"].ToString());
                    itemProduto.IdItemProduto = int.Parse(dr["id_item_produto"].ToString());
                    itemProduto.Produto = produto;
                    itemProduto.PrecoItemProduto = decimal.Parse(dr["preco_item_produto"].ToString());
                    itemProduto.Produto = produto;

                    if (qtd > qtdeAtual)
                    {
                        itemProduto.Qtde = qtdeAtual;
                    }
                    else
                    {
                        itemProduto.Qtde = qtd;
                    }
                }
                else
                {
                    itemProduto = null;
                }
            }
            catch (Exception e)
            {
                itemProduto = null;
            }
            finally
            {
                con.Close();
            }

            return itemProduto;
        }
    }
}
