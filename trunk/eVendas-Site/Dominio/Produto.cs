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

        private string nome;

        public string Nome
        {
            get { return nome; }
            set { nome = value; }
        }
        
        private decimal custo;

        public decimal Custo
        {
            get { return custo; }
            set { custo = value; }
        }

        private string urlImagem;

        public string UrlImagem
        {
            get { return urlImagem; }
            set { urlImagem = value; }
        }

    }
}
