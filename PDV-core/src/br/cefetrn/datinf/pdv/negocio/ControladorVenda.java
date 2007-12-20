package br.cefetrn.datinf.pdv.negocio;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

import br.cefetrn.datinf.estoque.remoto.IEstoque;
import br.cefetrn.datinf.pdv.dominio.Funcionario;
import br.cefetrn.datinf.pdv.dominio.Item;
import br.cefetrn.datinf.pdv.dominio.Produto;
import br.cefetrn.datinf.pdv.dominio.Venda;
import br.cefetrn.datinf.pdv.negocio.interfac.IControladorVenda;

public class ControladorVenda implements IControladorVenda{
	
	private IEstoque iEstoque = null;	
	private static IControladorVenda controladorVenda = null;
	private Venda venda = null;//= new Venda();
	private double subTotal;

	public Item inserirItem(long id, int qtd) {
		Produto produto = remotoEstoque().buscarProduto(id);
		Item item = new Item();
		item.setProduto(produto);
		item.setQtd(qtd);
		//precisa??
		item.setVenda(venda);
		venda.adicionarItem(item);
		this.subTotal(qtd,produto.getPreco());		
		return item;
	}
	
	public void subTotal(int qtd, double preco){
		double valor =  qtd*preco;
		subTotal+=subTotal+valor;
		venda.setValorTotal(subTotal);
	}
	
	public IEstoque	remotoEstoque() {
		Object o;
		try {
			if(iEstoque!=null){
				o = Naming.lookup("rmi://localhost//estoque");
				iEstoque = (IEstoque)o;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iEstoque;
	}
	
	private ControladorVenda(){}
	
	public static IControladorVenda getInstance() {
		//controladorVenda = (controladorVenda == null ? new ControladorVenda() : controladorVenda);
		if(controladorVenda==null){
			controladorVenda = new ControladorVenda();
		}
		return controladorVenda;
	}

	public Venda iniciarVenda() {
		//data? fucionario? 
		//func - no login ... sessao!!
		venda = new Venda();		
		//venda.setFuncionario(funcionario);	
		
		return venda;
	}

	public Venda getVenda() {
		return venda;
	}

	public Produto buscarProduto(long id) {
		// TODO Auto-generated method stub
		
		
		return null;
	}
}
