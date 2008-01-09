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
    public class PagamentoDAL
    {
        private string strConexao = System.Configuration.ConfigurationSettings.AppSettings["conexao_banco"].ToString();

        public bool InserirPagamento(Venda venda, SqlTransaction tran)
        {
            bool retorno = true;
            
            SqlCommand cmd = new SqlCommand("InserirPagamento", tran.Connection);
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.Parameters.AddWithValue("@id_tipo_pagamento", (int)venda.Pagamento.TipoPagamento);
            cmd.Parameters.AddWithValue("@id_venda", venda.IdVenda);
            cmd.Parameters.AddWithValue("@valor_pagamento", venda.Pagamento.ValorPagamento);
            cmd.Parameters.AddWithValue("@id_pagamento", 0);
            cmd.Parameters["@id_pagamento"].Direction = ParameterDirection.Output;

            cmd.Transaction = tran;

            try
            {
                cmd.ExecuteNonQuery();
                venda.Pagamento.IdPagamento = int.Parse(cmd.Parameters["@id_pagamento"].Value.ToString());
            }
            catch (Exception e)
            {
                throw new Exception();
            }

            if(venda.Pagamento.TipoPagamento == (int)TipoPagamento.tipoPagamento.CARTAO)
            {
                ParcelaDAL parcelaDal = new ParcelaDAL();
                parcelaDal.InserirParcelas(venda.Pagamento, tran);
                /*
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
                    foreach (Parcela parcela in venda.Pagamento.Parcelas)
                    {
                        cmd.Parameters["@id_pagamento"].Value = venda.Pagamento.IdPagamento;
                        cmd.Parameters["@id_cartao"].Value = parcela.Cartao;
                        cmd.Parameters["@valor_vencimento"].Value = parcela.ValorVencimento;
                        cmd.Parameters["@numero_parcela"].Value = numeroParcela++;
                        cmd.ExecuteNonQuery();
                    }
                }
                catch (Exception e)
                {
                    throw new Exception();
                }
                */
            }
            return retorno;
        }
    }
}
