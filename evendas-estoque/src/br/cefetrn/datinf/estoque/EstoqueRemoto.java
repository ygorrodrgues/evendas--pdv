package br.cefetrn.datinf.estoque;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.dominio.CupomDeTroca;
import br.cefetrn.datinf.estoque.dominio.ItemProduto;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.SubCategoria;
import br.cefetrn.datinf.estoque.dominio.Venda;
import br.cefetrn.datinf.estoque.excecoes.VendaNaoExistenteException;
import br.cefetrn.datinf.estoque.negocio.Estoque;
import br.cefetrn.datinf.estoque.remoto.IEstoque;

@SuppressWarnings("serial")
public class EstoqueRemoto implements IEstoque, Serializable {
	
	private Estoque estoque;
	
	public EstoqueRemoto() throws RemoteException {
		UnicastRemoteObject.exportObject(this);
		estoque = new Estoque();
	}

	/*public void realizarTroca(int numCupomTroca, Collection<ItemVenda> itens) throws CupomDeTrocaNaoExistenteException, SQLException, RemoteException  {
		estoque.realizarTroca(numCupomTroca, itens);		
	}*/

	public Venda recuperarVenda(int numVenda) throws VendaNaoExistenteException, SQLException, RemoteException {
		return estoque.recuperarVenda(numVenda);
	}

	public int registrarCupomDeTroca(CupomDeTroca cupom) throws SQLException, RemoteException {
		return estoque.registrarCupomDeTroca(cupom);		
	}
	
	public long registrarVenda(Venda umaVenda)throws RemoteException{
		try {
			System.out.println(umaVenda.getValor());
			return estoque.registrarVenda(umaVenda);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/*public void registrarItens(Collection<ItemVenda> itens, long idVenda){
		try {
			estoque.registrarItensVenda(itens);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*public void registrarPagamentos(Collection<Pagamento> pagamentos, long idVenda) throws SQLException{
		estoque.registrarPagamentos(pagamentos);
	}*/
	
	public Collection<Produto> buscarProdutosCategoria(Categoria categoria)throws RemoteException{
		return estoque.buscarProdutosCategoria(categoria);
	}
	public Collection<Produto> buscarProdutosSubCategoria(SubCategoria subCategoria)throws RemoteException{
		return estoque.buscarProdutosSubCategoria(subCategoria);
	}
	public Produto buscarProduto(int id)throws RemoteException{
		return estoque.buscarProduto(id);
	}

	@Override
	public ItemProduto SelectItemProdutoByCodigoProduto(long codProduto, int idLoja) throws RemoteException {
		return estoque.SelectItemProdutoByCodigoProduto(codProduto, idLoja);
	}
}
