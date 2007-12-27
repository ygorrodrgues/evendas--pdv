package br.cefetrn.datinf.estoque.persistencia;

public abstract class FabricaDao {
	
	private static FabricaDao fabrica = null;

	private static void init() {
		String classe = Util.obterNomeFabrica();
		try {
			FabricaDao.fabrica = (FabricaDao)Class.forName(classe).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static FabricaDao getInstance() {
		if (FabricaDao.fabrica == null) FabricaDao.init();
		return FabricaDao.fabrica;
	}
	
	public abstract ProdutoDao getProdutoDao();
	
	public abstract ItemVendaDao getItemDeVendaDao();
	
	public abstract VendaDao getVendaDao();
	
	public abstract CupomDeTrocaDao getCupomDeTrocaDao();
	
	public abstract PagamentoDao getPagamentoDAO();
}