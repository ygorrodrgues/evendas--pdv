package br.cefetrn.datinf.estoque.negocio;

import java.sql.SQLException;
import java.util.Collection;

import br.cefetrn.datinf.estoque.dominio.CupomDeTroca;
import br.cefetrn.datinf.estoque.dominio.ItemVenda;
import br.cefetrn.datinf.estoque.dominio.Venda;
import br.cefetrn.datinf.estoque.excecoes.CupomDeTrocaNaoExistenteException;
import br.cefetrn.datinf.estoque.excecoes.VendaNaoExistenteException;
import br.cefetrn.datinf.estoque.persistencia.FabricaDao;
import br.cefetrn.datinf.estoque.persistencia.ItemDeVendaDao;
import br.cefetrn.datinf.estoque.persistencia.VendaDao;
import br.cefetrn.datinf.estoque.remoto.IEstoque;
/**
 * 
 * @author Gleison
 *
 */

public class Estoque implements IEstoque{

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
		ItemDeVendaDao itemDAO = fabrica.getItemDeVendaDao();
		for (ItemVenda item : cupom.getItens()) {
			itemDAO.remover(item);
		}
		return codCupom;		
	}
	
	public boolean registrarVenda(Venda umaVenda){
		FabricaDao fabrica = FabricaDao.getInstance();
		try {
			fabrica.getVendaDao().registrarVenda(umaVenda.getData(), umaVenda.getPdv().getNumero());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
