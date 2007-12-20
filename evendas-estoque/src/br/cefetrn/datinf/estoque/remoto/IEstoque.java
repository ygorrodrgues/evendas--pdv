package br.cefetrn.datinf.estoque.remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.cefetrn.datinf.estoque.dominio.Venda;

public interface IEstoque extends Remote {
	public boolean registrarVenda(Venda umaVenda) throws RemoteException;
}
