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
    public class VendaDAL
    {
        private string strConexao = System.Configuration.ConfigurationSettings.AppSettings["conexao_banco"].ToString();

        public bool Inserir(Venda venda)
        {
            bool retorno = true;
            SqlConnection con = new SqlConnection(strConexao);
            SqlCommand cmd = new SqlCommand("InserirVenda", con);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@id_func", 1);
            cmd.Parameters.AddWithValue("@id_pDV", 1);
            cmd.Parameters.AddWithValue("@id_cliente", venda.Cliente.IdCliente);
            cmd.Parameters.AddWithValue("@id_venda", 0);
            cmd.Parameters["@id_venda"].Direction = ParameterDirection.Output;

            con.Open();
            SqlTransaction tran = con.BeginTransaction();

            cmd.Transaction = tran;

            try
            {
                cmd.ExecuteNonQuery();
                venda.IdVenda = int.Parse(cmd.Parameters["@id_venda"].Value.ToString());

                ItemVendaDAL itemVendaDal = new ItemVendaDAL();
                itemVendaDal.InserirItensVenda(venda, tran);

                PagamentoDAL pagamentoDal = new PagamentoDAL();
                pagamentoDal.InserirPagamento(venda, tran);

                tran.Commit();
            }
            catch (Exception e)
            {
                tran.Rollback();
                retorno = false;
            }
            finally
            {
                con.Close();
            }

            return retorno;
        }
    }
}
