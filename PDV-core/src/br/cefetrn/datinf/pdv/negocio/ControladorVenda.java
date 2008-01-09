package br.cefetrn.datinf.pdv.negocio;

import br.cefetrn.datinf.estoque.dominio.CupomDeTroca;
import br.cefetrn.datinf.estoque.remoto.IEstoque;
import cefetrn.datinf.tads.credito.interfaces.ICredito;
import java.rmi.RemoteException;
import br.cefetrn.datinf.estoque.dominio.ItemProduto;
import br.cefetrn.datinf.estoque.dominio.Venda;
import java.util.HashMap;

public class ControladorVenda{
	
	private static ControladorVenda controladorVenda = null;
	private double subTotal;
        private IEstoque estoque = null;
        private ICredito credito = null;
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
        
        public int registrarCupomDeTroca(CupomDeTroca umCupom){
            try {
                int numeroCupomTroca = this.estoque.registrarCupomDeTroca(umCupom);
                
                return numeroCupomTroca;
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return 0;
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

    public void ssetarCreditoRemoto(ICredito credito) {
        this.credito = credito;
    }
        
        public HashMap<Integer,String> tiposPagamento(){
            return null;
        }
        public String solicitarAprovacaoDeCompra(String numeroCartao,double valorCompra,
    		int qtdParcelas,String identPDV){
        	
    	//String mensagem = iCredito.solicitarAprovacaoDeCompra(numeroCartao, valorCompra, qtdParcelas, identPDV);
    	
    	return "Aprovado";
        }
        public void finalizarVenda(Venda venda) throws RemoteException{
            System.out.println("Chuck Norris: "+venda.getItens().size());
            this.estoque.registrarVenda(venda);
            
        }
}
