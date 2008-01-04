package br.cefetrn.datinf.pdv;


import br.cefetrn.datinf.pdv.negocio.ControladorVenda;
import br.cefetrn.datinf.estoque.dominio.ItemProduto;
import br.cefetrn.datinf.estoque.dominio.ItemVenda;
import br.cefetrn.datinf.estoque.dominio.Venda;
import br.cefetrn.datinf.estoque.remoto.IEstoque;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sistema implements ISistema {

	private ControladorVenda controladorVenda; 
	//private Venda venda;
	private static ISistema pdv = null;
	
	private Sistema() {
            this.controladorVenda = ControladorVenda.getInstance();
            
        }
	
	public static ISistema getInstance() {
		if(pdv == null){
			pdv = new Sistema();
		}
		return pdv;
        }
        
	public Venda iniciarVenda() {
            Venda venda = new Venda();
            return venda;
	}
        
        public Venda buscarVenda(int idVenda){
            Venda venda = controladorVenda.buscarVenda(idVenda);
            return venda;
        }
	
	public ItemVenda entrarItem(Venda venda, long codigoProduto, int qtd) {
            try {
                 ItemProduto itemProduto = controladorVenda.recuperarItem(codigoProduto);
                 ItemVenda itemVenda = new ItemVenda();
                itemVenda.setQtde(qtd);
                itemVenda.setItemProduto(itemProduto);
                venda.adicionarItem(itemVenda);
                venda.setValor(venda.getValor() + qtd * itemVenda.getItemProduto().getPreco());

                return itemVenda;
            } catch (RemoteException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
	}
	//
        public ItemVenda criarItemVenda(long codigoProduto) {
            try {
                ItemProduto itemProduto = controladorVenda.recuperarItem(codigoProduto);
                ItemVenda itemVenda = new ItemVenda();
            
                itemVenda.setItemProduto(itemProduto);
            return itemVenda;
            } catch (RemoteException ex) {
                Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
                return null;
             }
	}
        
	//nao precisa implementar aki soh no JFORM
        public Venda finalizarVenda(Venda venda) {
		//enviar venda para o PDV??
		return null;
	}
	
	public void fazerPagamento(double quantia) {
		// TODO Auto-generated method stub
		
	}

        public HashMap<Integer, String> tiposPagamento() {
            HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(1, "DIMHEIRO");
		hashMap.put(2, "CARTAO");
		hashMap.put(3, "TICKET TROCA");
		
            return hashMap;   
        }
        public String solicitarAprovacaoDeCompra(String numeroCartao, double valorCompra, int qtdParcelas, String identPDV) {
		String mensagem = controladorVenda.solicitarAprovacaoDeCompra(numeroCartao, valorCompra, qtdParcelas, identPDV);
		return mensagem;
	}
        
          public void setarEstoqueRemoto(IEstoque estoque){
            controladorVenda.setarEstoqueRemoto(estoque);
        }
   
	
}
