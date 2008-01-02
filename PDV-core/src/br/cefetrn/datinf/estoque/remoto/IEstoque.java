package br.cefetrn.datinf.estoque.remoto;

import dominio.Produto;
import dominio.TipoPagamento;
import java.util.ArrayList;
import java.util.HashMap;



public interface IEstoque {

	public Produto buscarProduto(long id); 
        public HashMap<Integer, String> tiposPagamento(); 
}
