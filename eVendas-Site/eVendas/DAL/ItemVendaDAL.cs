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
    public class ItemVendaDAL
    {
        private string strConexao = System.Configuration.ConfigurationSettings.AppSettings["conexao_banco"].ToString();

        public bool InserirItensVenda(Venda venda, SqlTransaction tran)
        {
            bool retorno = true;
            SqlCommand cmd = new SqlCommand("spRegistrarItemVenda", tran.Connection);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@idVenda", 0);
            cmd.Parameters.AddWithValue("@idItemProduto", 0);
            cmd.Parameters.AddWithValue("@descricaoEstadoItemVenda", "");
            cmd.Parameters.AddWithValue("@qtde", 0);

            cmd.Transaction = tran;

            try
            {
                foreach (ItemVenda itemVenda in venda.ItensVenda)
                {
                    cmd.Parameters["@idVenda"].Value = venda.IdVenda;
                    cmd.Parameters["@idItemProduto"].Value = itemVenda.ItemProduto.IdItemProduto;
                    cmd.Parameters["@descricaoEstadoItemVenda"].Value = "ENTREGUE";
                    cmd.Parameters["@qtde"].Value = itemVenda.Qtde;

                    cmd.ExecuteNonQuery();
                }
            }
            catch (Exception e)
            {
                throw new Exception();
            }

            return retorno;
        }
    }
}
