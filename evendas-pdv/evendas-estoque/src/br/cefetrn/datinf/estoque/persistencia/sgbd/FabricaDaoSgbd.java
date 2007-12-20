package br.cefetrn.datinf.estoque.persistencia.sgbd;

import br.cefetrn.datinf.estoque.persistencia.CupomDeTrocaDao;
import br.cefetrn.datinf.estoque.persistencia.FabricaDao;
import br.cefetrn.datinf.estoque.persistencia.ItemDeVendaDao;
import br.cefetrn.datinf.estoque.persistencia.PagamentoDao;
import br.cefetrn.datinf.estoque.persistencia.ProdutoDao;
import br.cefetrn.datinf.estoque.persistencia.VendaDao;

public class FabricaDaoSgbd extends FabricaDao {
	
	private VendaDao vendaDao;
	private ItemDeVendaDao itemDeVendaDao;
	private ProdutoDao produtoDao;
	private CupomDeTrocaDao cupomDeTrocaDao;
	private PagamentoDao pagamentoDao;
	
	public FabricaDaoSgbd() {	}

	@Override
	public ItemDeVendaDao getItemDeVendaDao() {
		if(itemDeVendaDao == null) itemDeVendaDao = new ItemDeVendaDaoSgbd();
		return itemDeVendaDao;
	}

	@Override
	public ProdutoDao getProdutoDao() {
		if(produtoDao == null) produtoDao = new ProdutoDaoSgbd();
		return produtoDao;
	}

	@Override
	public VendaDao getVendaDao() {
		if(vendaDao == null) vendaDao = new VendaDaoSgbd();
		return vendaDao;
	}

	@Override
	public CupomDeTrocaDao getCupomDeTrocaDao() {
		if(cupomDeTrocaDao == null) cupomDeTrocaDao = new CupomDeTrocaDaoSgbd();
		return cupomDeTrocaDao;
	}
	
	

	@Override
	public PagamentoDao getPagamentoDAO() {
		if(pagamentoDao == null) pagamentoDao = new PagamentoDaoSgbd();
		return pagamentoDao;
	}	

}
