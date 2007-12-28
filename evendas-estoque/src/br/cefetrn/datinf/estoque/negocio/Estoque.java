package br.cefetrn.datinf.estoque.negocio;

import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.dominio.CupomDeTroca;
import br.cefetrn.datinf.estoque.dominio.ItemVenda;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;
import br.cefetrn.datinf.estoque.dominio.Pagamento;
import br.cefetrn.datinf.estoque.dominio.Venda;
import br.cefetrn.datinf.estoque.excecoes.CupomDeTrocaNaoExistenteException;
import br.cefetrn.datinf.estoque.excecoes.VendaNaoExistenteException;
import br.cefetrn.datinf.estoque.persistencia.FabricaDao;
import br.cefetrn.datinf.estoque.persistencia.ItemVendaDao;
import br.cefetrn.datinf.estoque.persistencia.VendaDao;

public class Estoque{

	public void realizarTroca(int numCupomTroca, Collection<ItemVenda> itens) throws CupomDeTrocaNaoExistenteException, SQLException {
		FabricaDao fabrica = FabricaDao.getInstance();
		boolean cupomOK = fabrica.getCupomDeTrocaDao().existe(numCupomTroca);
		if(!cupomOK){
			throw new CupomDeTrocaNaoExistenteException();
		}
		VendaDao vendaDAO = fabrica.getVendaDao();
		vendaDAO.realizarTroca(numCupomTroca, itens);
	}

	public Venda recuperarVenda(int numVenda) throws VendaNaoExistenteException, SQLException {
		FabricaDao fabrica = FabricaDao.getInstance();
		Venda venda = fabrica.getVendaDao().obterPorCodigo(numVenda);
		//TODO:N�o recupera venda sem item associado(n�o permitir o cadastro de venda sem item)
		if(venda == null){
			throw new VendaNaoExistenteException();
		}
		return venda;
	}

	public int registrarCupomDeTroca(CupomDeTroca cupom) throws SQLException {
		FabricaDao fabrica = FabricaDao.getInstance();
		int codCupom = fabrica.getCupomDeTrocaDao().inserir(cupom);
		ItemVendaDao itemDAO = fabrica.getItemDeVendaDao();
		for (ItemVenda item : cupom.getItens()) {
			itemDAO.remover(item);
		}
		return codCupom;		
	}
	
	public long registrarVenda(Venda umaVenda){
		FabricaDao fabrica = FabricaDao.getInstance();
		long idVenda = 0;
		try {
			idVenda = fabrica.getVendaDao().registrarVenda(umaVenda.getData(), umaVenda.getPdv().getID());
			
			this.registrarItens(umaVenda.getItens(), idVenda);
			this.registrarPagamentos(umaVenda.getPagamentos(), idVenda);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return idVenda;
	}
	
	public void registrarItens(Collection<ItemVenda> itens, long idVenda){
		
	}
	public void registrarPagamentos(Collection<Pagamento> pagamentos, long idVenda){
		
	}
	
	public Collection<Produto> buscarProdutosCategoria(Categoria categoria){
		FabricaDao fabrica = FabricaDao.getInstance();
		Collection<Produto> produtos = null;
		try {
			produtos = fabrica.getProdutoDao().recuperarProdutos(categoria);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produtos;
	}
	public Collection<Produto> buscarProdutosSubCategoria(SubCategoria subCategoria){
		FabricaDao fabrica = FabricaDao.getInstance();
		Collection<Produto> produtos = null;
		produtos = fabrica.getProdutoDao().recuperarProdutos(subCategoria);
		return null;
	}
	public Produto buscarProduto(int id){
		FabricaDao fabrica = FabricaDao.getInstance();
		Produto produto = null;
		produto = fabrica.getProdutoDao().recuperarProduto(id);
		return produto;
	}
}
