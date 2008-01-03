package br.cefetrn.datinf.estoque.remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;
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
import br.cefetrn.datinf.estoque.persistencia.FabricaDao;
import br.cefetrn.datinf.estoque.persistencia.ItemVendaDao;
import br.cefetrn.datinf.estoque.persistencia.VendaDao;

public interface IEstoque extends Remote {
	public void realizarTroca(int numCupomTroca, Collection<ItemVenda> itens) throws CupomDeTrocaNaoExistenteException, SQLException, RemoteException ;

	public Venda recuperarVenda(int numVenda) throws VendaNaoExistenteException, SQLException, RemoteException ;

	public int registrarCupomDeTroca(CupomDeTroca cupom) throws SQLException, RemoteException ;
	
	public long registrarVenda(Venda umaVenda) throws RemoteException;
	
	//public void registrarItens(Collection<ItemVenda> itens, long idVenda);
	//public void registrarPagamentos(Collection<Pagamento> pagamentos, long idVenda) throws SQLException;
	public Collection<Produto> buscarProdutosCategoria(Categoria categoria)throws RemoteException;
	public Collection<Produto> buscarProdutosSubCategoria(SubCategoria subCategoria)throws RemoteException;
	public Produto buscarProduto(int id)throws RemoteException;
	
}
