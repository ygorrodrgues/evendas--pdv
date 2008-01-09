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
    public class ParcelaDAL
    {
        private string strConexao = System.Configuration.ConfigurationSettings.AppSettings["conexao_banco"].ToString();

        public bool InserirParcelas(Pagamento pagamento, SqlTransaction tran)
        {
            SqlCommand cmd = new SqlCommand("InserirParcelas", tran.Connection);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@id_pagamento", 0);
            cmd.Parameters.AddWithValue("@id_cartao", 0);
            cmd.Parameters.AddWithValue("@valor_vencimento", 0);
            cmd.Parameters.AddWithValue("@numero_parcela", 0);

            cmd.Transaction = tran;

            try
            {
                int numeroParcela = 0;
                foreach (Parcela parcela in pagamento.Parcelas)
                {
                    cmd.Parameters["@id_pagamento"].Value = pagamento.IdPagamento;
                    cmd.Parameters["@id_cartao"].Value = parcela.Cartao.IdCartao;
                    cmd.Parameters["@valor_vencimento"].Value = parcela.ValorVencimento;
                    cmd.Parameters["@numero_parcela"].Value = numeroParcela++;
                    cmd.ExecuteNonQuery();
                }
            }
            catch (Exception e)
            {
                throw new Exception();
            }
            return true;
        }
    }
}
