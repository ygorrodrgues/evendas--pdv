package br.cefetrn.datinf.estoque;

import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.dominio.CupomDeTroca;
import br.cefetrn.datinf.estoque.dominio.ItemVenda;
import br.cefetrn.datinf.estoque.dominio.Pagamento;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;
import br.cefetrn.datinf.estoque.dominio.Venda;
import br.cefetrn.datinf.estoque.excecoes.CupomDeTrocaNaoExistenteException;
import br.cefetrn.datinf.estoque.excecoes.VendaNaoExistenteException;
import br.cefetrn.datinf.estoque.negocio.Estoque;
import br.cefetrn.datinf.estoque.remoto.IEstoque;

public class EstoqueRemoto implements IEstoque {
	
	private Estoque estoque;
	
	public EstoqueRemoto() {
		estoque = new Estoque();
	}

	public void realizarTroca(int numCupomTroca, Collection<ItemVenda> itens) throws CupomDeTrocaNaoExistenteException, SQLException {
		estoque.realizarTroca(numCupomTroca, itens);		
	}

	public Venda recuperarVenda(int numVenda) throws VendaNaoExistenteException, SQLException {
		return estoque.recuperarVenda(numVenda);
	}

	public int registrarCupomDeTroca(CupomDeTroca cupom) throws SQLException {
		return estoque.registrarCupomDeTroca(cupom);		
	}
	
	public long registrarVenda(Venda umaVenda){
		return estoque.registrarVenda(umaVenda);
	}
	
	public void registrarItens(Collection<ItemVenda> itens, long idVenda){
		estoque.registrarItens(itens, idVenda);
	}
	public void registrarPagamentos(Collection<Pagamento> pagamentos, long idVenda){
		estoque.registrarPagamentos(pagamentos, idVenda);
	}
	
	public Collection<Produto> buscarProdutosCategoria(Categoria categoria){
		return estoque.buscarProdutosCategoria(categoria);
	}
	public Collection<Produto> buscarProdutosSubCategoria(SubCategoria subCategoria){
		return estoque.buscarProdutosSubCategoria(subCategoria);
	}
	public Produto buscarProduto(int id){
		return estoque.buscarProduto(id);
	}
}
