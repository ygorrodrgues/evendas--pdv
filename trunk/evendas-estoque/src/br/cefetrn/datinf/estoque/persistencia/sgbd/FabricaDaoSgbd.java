package br.cefetrn.datinf.estoque.persistencia.sgbd;

import br.cefetrn.datinf.estoque.persistencia.CategoriaDao;
import br.cefetrn.datinf.estoque.persistencia.CupomDeTrocaDao;
import br.cefetrn.datinf.estoque.persistencia.FabricaDao;
import br.cefetrn.datinf.estoque.persistencia.ItemProdutoDao;
import br.cefetrn.datinf.estoque.persistencia.ItemVendaDao;
import br.cefetrn.datinf.estoque.persistencia.LojaDao;
import br.cefetrn.datinf.estoque.persistencia.MedidaDao;
import br.cefetrn.datinf.estoque.persistencia.PagamentoDao;
import br.cefetrn.datinf.estoque.persistencia.ParcelaDao;
import br.cefetrn.datinf.estoque.persistencia.ProdutoDao;
import br.cefetrn.datinf.estoque.persistencia.SubCategoriaDao;
import br.cefetrn.datinf.estoque.persistencia.VendaDao;

public class FabricaDaoSgbd extends FabricaDao {
	
	private VendaDao vendaDao;
	private ItemVendaDao itemDeVendaDao;
	private ProdutoDao produtoDao;
	private CupomDeTrocaDao cupomDeTrocaDao;
	private PagamentoDao pagamentoDao;
	private ParcelaDao parcelaDao;
	private LojaDao lojaDao;
	private ItemProdutoDao itemProdutoDao;
	private CategoriaDao categoriaDao;
	private SubCategoriaDao subCategoriaDao;
	private MedidaDao medidaDao;
	
	public FabricaDaoSgbd() {	}

	@Override
	public ItemVendaDao getItemDeVendaDao() {
		if(itemDeVendaDao == null) itemDeVendaDao = new ItemVendaDaoSgbd();
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

	@Override
	public ParcelaDao getParcelaDao() {
		if(this.parcelaDao == null) this.parcelaDao = new ParcelaDaoSgbd();
		return this.parcelaDao;
	}

	@Override
	public LojaDao getLojaDao() {
		if(this.lojaDao == null) this.lojaDao = new LojaDaoSgbd();
		return this.lojaDao;
	}

	@Override
	public ItemProdutoDao getItemProdutoDao() {
		if(this.itemProdutoDao == null) this.itemProdutoDao = new ItemProdutoDaoSgbd();
		return this.itemProdutoDao;
	}

	@Override
	public CategoriaDao getCategoriaDao() {
		if(this.categoriaDao == null) this.categoriaDao = new CategoriaDaoSgbd();
		return this.categoriaDao;
	}

	@Override
	public MedidaDao getMedidaDaoDao() {
		if(this.medidaDao == null) this.medidaDao = new MedidaDaoSgbd();
		return this.medidaDao;
	}

	@Override
	public SubCategoriaDao getSubCategoriaDao() {
		if(this.subCategoriaDao == null) this.subCategoriaDao = new SubCategoriaDaoSgbd();
		return this.subCategoriaDao;
	}	

}
