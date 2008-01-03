package br.cefetrn.datinf.estoque.negocio;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.dominio.CupomDeTroca;
import br.cefetrn.datinf.estoque.dominio.ItemVenda;
import br.cefetrn.datinf.estoque.dominio.PagamentoCartao;
import br.cefetrn.datinf.estoque.dominio.PagamentoCupomDeTroca;
import br.cefetrn.datinf.estoque.dominio.PagamentoDinheiro;
import br.cefetrn.datinf.estoque.dominio.Parcela;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;
import br.cefetrn.datinf.estoque.dominio.Pagamento;
import br.cefetrn.datinf.estoque.dominio.Venda;
import br.cefetrn.datinf.estoque.excecoes.CupomDeTrocaNaoExistenteException;
import br.cefetrn.datinf.estoque.excecoes.VendaNaoExistenteException;
import br.cefetrn.datinf.estoque.persistencia.CupomDeTrocaDao;
import br.cefetrn.datinf.estoque.persistencia.FabricaDao;
import br.cefetrn.datinf.estoque.persistencia.ItemVendaDao;
import br.cefetrn.datinf.estoque.persistencia.PagamentoDao;
import br.cefetrn.datinf.estoque.persistencia.ParcelaDao;
import br.cefetrn.datinf.estoque.persistencia.VendaDao;

public class Estoque implements Serializable{

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
		//TODO:Não recupera venda sem item associado(não permitir o cadastro de venda sem item)
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
			itemDAO.trocar(item);
		}
		return codCupom;		
	}
	
	public long registrarVenda(Venda umaVenda) throws SQLException{
		FabricaDao fabrica = FabricaDao.getInstance();
		long idVenda = 0;
		VendaDao vendaDao = fabrica.getVendaDao();
		idVenda = vendaDao.registrarVenda(umaVenda.getFuncionario().getId(), umaVenda.getPdv().getID(), umaVenda.getCliente().getId(), new Date());
		umaVenda.setId(idVenda);
		this.registrarItensVenda(umaVenda.getItens());
		this.registrarPagamentos(umaVenda.getPagamentos());
			
		return idVenda;
	}
	
	public void registrarItensVenda(Collection<ItemVenda> itens) throws SQLException{
		FabricaDao fabrica = FabricaDao.getInstance();
		ItemVendaDao dao = fabrica.getItemDeVendaDao();
		for(ItemVenda iten: itens){
			dao.registrarItemDeVenda(iten);
		}
		
	}
	
	public void registrarPagamentos(Collection<Pagamento> pagamentos) throws SQLException{
		for(Pagamento pag: pagamentos){
			switch (pag.getTipo()) {
			case Cartao:
				this.registrarPagamentoCartao((PagamentoCartao) pag);
				break;
			case Dinheiro:
				this.registrarPagamentoDinheiro((PagamentoDinheiro) pag);	
				break;
			case Troca:
				this.registrarPagamentoTroca((PagamentoCupomDeTroca) pag);
				break;			
			}
			
		}
	}
	
	public void registrarPagamentoCartao(PagamentoCartao pagamento) throws SQLException{
		FabricaDao fabrica = FabricaDao.getInstance();
		PagamentoDao dao = fabrica.getPagamentoDAO();
		long idPagamento = dao.registrarPagamento(pagamento);
		pagamento.setId(idPagamento);
		System.out.println("id do pagamento em estoque: "+idPagamento);
		this.registrarParcelas(pagamento.getParcelas());
	}
	
	public void registrarParcelas(Collection<Parcela> parcelas) throws SQLException{
		FabricaDao fabrica = FabricaDao.getInstance();
		ParcelaDao dao = fabrica.getParcelaDao();
		int numeroParcela=1;//indica se é a primeira, segunda... parcela
		for(Parcela parcela: parcelas){
			dao.registrarParcela(parcela, numeroParcela);
			++numeroParcela;
		}
	}
	
	public void registrarPagamentoDinheiro(PagamentoDinheiro pagamento) throws SQLException{
		FabricaDao fabrica = FabricaDao.getInstance();
		PagamentoDao dao = fabrica.getPagamentoDAO();
		long idPagamento = dao.registrarPagamento(pagamento);
		pagamento.setId(idPagamento);
		System.out.println("id do pagamento em estoque: "+idPagamento);
	}
	
	public void registrarPagamentoTroca(PagamentoCupomDeTroca pagamento) throws SQLException{
		
		FabricaDao fabrica = FabricaDao.getInstance();
		PagamentoDao dao = fabrica.getPagamentoDAO();
		long idPagamento = dao.registrarPagamento(pagamento);
		pagamento.setId(idPagamento);
		System.out.println("id do pagamento em estoque: "+idPagamento);
		this.ligarTrocaAoPagamento(pagamento.getCupom());
	}
	
	public void ligarTrocaAoPagamento(CupomDeTroca cupomDeTroca) throws SQLException{
		FabricaDao fabrica = FabricaDao.getInstance();
		CupomDeTrocaDao dao = fabrica.getCupomDeTrocaDao();
		dao.ligarTrocaAoPagamento(cupomDeTroca);
	}
	
	public Collection<Produto> buscarProdutosCategoria(Categoria categoria){
		FabricaDao fabrica = FabricaDao.getInstance();
		Collection<Produto> produtos = null;
		try {
			produtos = fabrica.getProdutoDao().recuperarProdutosCategoria(categoria.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produtos;
	}
	public Collection<Produto> buscarProdutosSubCategoria(SubCategoria subCategoria){
		FabricaDao fabrica = FabricaDao.getInstance();
		Collection<Produto> produtos = null;
		try {
			produtos = fabrica.getProdutoDao().recuperarProdutosSubCategoria(subCategoria);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Produto buscarProduto(int id){
		FabricaDao fabrica = FabricaDao.getInstance();
		Produto produto = null;
		try {
			produto = fabrica.getProdutoDao().recuperarProduto(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produto;
	}
}
