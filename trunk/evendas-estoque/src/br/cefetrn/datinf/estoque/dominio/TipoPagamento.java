package br.cefetrn.datinf.estoque.dominio;

@SuppressWarnings("unused")
public enum TipoPagamento {
	
	CARTAO{
		private double valor;
		private int nParcelas;
		
		public void setValor(double valor){
			this.valor= valor;
		}
		public double getValor(){
			return this.valor;
		}
		public void setNParcelas(int nParcelas){
			this.nParcelas = nParcelas;
		}
		public int getNParcelas(){
			return this.nParcelas;
		}
	}
	, 
	DINHEIRO{
		private double valor;
		public void setValor(double valor){
			this.valor = valor;
		}
		public double getValor(){
			return this.valor;
		}
	}	
	, 
	TICKETTROCA{
		private double valor;
		public void setValor(double valor){
			this.valor = valor;
		}
		public double getValor(){
			return this.valor;
		}
	};
	
}
