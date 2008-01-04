package br.cefetrn.datinf.pdv.negocio;


import br.cefetrn.datinf.estoque.excecoes.VendaNaoExistenteException;
import br.cefetrn.datinf.estoque.remoto.IEstoque;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import br.cefetrn.datinf.estoque.dominio.ItemProduto;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.Venda;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorVenda{
	
	private static ControladorVenda controladorVenda = null;
	private double subTotal;
        private IEstoque estoque = null;
        /***
         * 
         * @param venda
         * @param id do produto
         * @param qtd de itens
         * @return item criado 
         */
        
        public Venda buscarVenda(int idVenda){
            try {
                Venda venda = this.estoque.recuperarVenda(idVenda);
                return venda;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }
        
        public void setarEstoqueRemoto(IEstoque estoque){
            this.estoque = estoque;
        }
        
	public ItemProduto recuperarItem(long codigoProduto) throws RemoteException {
            ItemProduto itemProduto = this.estoque.SelectItemProdutoByCodigoProduto(codigoProduto, 1);
                //Gambiarra antes do RMI tah pronto
		/*Produto produto = new Produto();
                produto.setId(codigoProduto);
                produto.setNome("uebba");
                produto.setPreco(0);*/
                
               
                /*itemProduto.setId(1);
                itemProduto.setPreco(5.00);
                itemProduto.setProduto(produto);*/
                //fim da gabiarra
                //Criando um novo item       
		//ItemVenda itemVenda = new ItemVenda();
                //este produto deve sero retornado pelo remoto
		//itemVenda.setItemProduto(itemProduto);
                //itemVenda.setQtde(qtde);
				
		return itemProduto;
	}
		
	
	/**public IEstoque	remotoEstoque() {
                Object o;
                try {
                    if(estoque==null){
                        System.out.println("aqui 68");
                        o = Naming.lookup("rmi://localhost/estoque");
                        estoque = (IEstoque)o;
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
		return estoque;
	}*/
        
        /*public ICredito	remotoCredito() {
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
	}*/
	
	private ControladorVenda(){
            //estoque = remotoEstoque();
        }
	
	public static ControladorVenda getInstance() {
		//controladorVenda = (controladorVenda == null ? new ControladorVenda() : controladorVenda);
		if(controladorVenda==null){
			controladorVenda = new ControladorVenda();
		}
		return controladorVenda;
	}

	public ItemProduto buscarItemProduto(long id) {
		// TODO Auto-generated method stub		
		return null;
	}
        
        public HashMap<Integer,String> tiposPagamento(){
            return null;
        }
        public String solicitarAprovacaoDeCompra(String numeroCartao,double valorCompra,
    		int qtdParcelas,String identPDV){
        	
    	//String mensagem = iCredito.solicitarAprovacaoDeCompra(numeroCartao, valorCompra, qtdParcelas, identPDV);
    	
    	return "Aprovado";
        }
}
