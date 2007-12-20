package br.cefetrn.datinf.pdv;


import java.util.ArrayList;
import java.util.Date;

import br.cefetrn.datinf.pdv.dominio.Funcionario;
import br.cefetrn.datinf.pdv.dominio.Item;
import br.cefetrn.datinf.pdv.dominio.Pagamento;
import br.cefetrn.datinf.pdv.dominio.Produto;
import br.cefetrn.datinf.pdv.dominio.Venda;

public interface ISistema {

	//quais os parametros  VENDA
	public Venda iniciarVenda();	
	//
	public Item entrarItem(long itemId, int qtd);
	public Venda finalizarVenda();
	public void fazerPagamento(double quantia);
	public ArrayList<Pagamento> tiposPagamento();
	
}
