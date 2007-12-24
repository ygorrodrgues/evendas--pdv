using System;
using System.Collections.Generic;
using System.Text;

namespace Dominio
{
    public class Produtos : List<Produto>
    {
    }

    public class Produto
    {
        private int idProduto;

        public int IdProduto
        {
            get { return idProduto; }
            set { idProduto = value; }
        }

        private string descricao;

        public string Descricao
        {
            get { return descricao; }
            set { descricao = value; }
        }

        private string texto;

        public string Texto
        {
            get { return texto; }
            set { texto = value; }
        }
        
        private decimal preco;

        public decimal Preco
        {
            get { return preco; }
            set { preco = value; }
        }

        private string urlImagem;

        public string UrlImagem
        {
            get { return urlImagem; }
            set { urlImagem = value; }
        }

    }
}
