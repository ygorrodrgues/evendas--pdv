package br.cefetrn.datinf.pdv.negocio;


import br.cefetrn.datinf.credito.remoto.ICredito;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import br.cefetrn.datinf.estoque.remoto.IEstoque;


import dominio.ItemProduto;
import dominio.ItemVenda;
import dominio.Produto;
import java.util.HashMap;

public class ControladorVenda{
	
	private IEstoque iEstoque = null;
        private ICredito iCredito = null;
	private static ControladorVenda controladorVenda = null;
	//private Venda venda = null;//= new Venda();
	private double subTotal;
        /***
         * 
         * @param venda
         * @param id do produto
         * @param qtd de itens
         * @return item criado 
         */
	public ItemProduto recuperarItem(long codigoProduto) {
                //ItemProduto itemProduto = remotoEstoque().buscarItemProduto(id);
                //Gambiarra antes do RMI tah pronto
				Produto produto = new Produto();
                produto.setId(codigoProduto);
                produto.setNome("uebba");
                produto.setPreco(0);
                
                ItemProduto itemProduto = new ItemProduto();
                itemProduto.setId(1);
                itemProduto.setPreco(5.00);
                itemProduto.setProduto(produto);
                //fim da gabiarra
                //Criando um novo item       
		//ItemVenda itemVenda = new ItemVenda();
                //este produto deve sero retornado pelo remoto
		//itemVenda.setItemProduto(itemProduto);
                //itemVenda.setQtde(qtde);
				
		return itemProduto;
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
        
        public ICredito	remotoCredito() {
		Object o;
		try {
			if(iCredito!=null){
				o = Naming.lookup("rmi://localhost//credito");
				iCredito = (ICredito)o;
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
		return iCredito;
	}
	
	private ControladorVenda(){}
	
	public static ControladorVenda getInstance() {
		//controladorVenda = (controladorVenda == null ? new ControladorVenda() : controladorVenda);
		if(controladorVenda==null){
			controladorVenda = new ControladorVenda();
		}
		return controladorVenda;
	}

	/*public Venda iniciarVenda() {
		//data? fucionario? 
		//func - no login ... sessao!!
		venda = new Venda();		
		//venda.setFuncionario(funcionario);	
		
		return venda;
	}*/

	/*public Venda getVenda() {
		return venda;
	}*/

	public ItemProduto buscarItemProduto(long id) {
		// TODO Auto-generated method stub		
		return null;
	}
        
        public HashMap<Integer,String> tiposPagamento(){
            return iEstoque.tiposPagamento();
        }
        public String solicitarAprovacaoDeCompra(String numeroCartao,double valorCompra,
    		int qtdParcelas,String identPDV){
        	
    	String mensagem = iCredito.solicitarAprovacaoDeCompra(numeroCartao, valorCompra, qtdParcelas, identPDV);
    	
    	return mensagem;
    }
}
