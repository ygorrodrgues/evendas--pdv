package br.cefetrn.datinf.estoque.persistencia.sgbd;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import br.cefetrn.datinf.estoque.dominio.Categoria;
import br.cefetrn.datinf.estoque.dominio.CupomDeTroca;
import br.cefetrn.datinf.estoque.dominio.Produto;
import br.cefetrn.datinf.estoque.dominio.Venda;
import br.cefetrn.datinf.estoque.excecoes.VendaNaoExistenteException;
import br.cefetrn.datinf.estoque.negocio.Estoque;

public class Main {
	
	public static void main(String[] args) {
		Estoque e = new Estoque();
		
		/*try {
			Venda v = e.recuperarVenda(1);
			System.out.println(v.getData().toString());
			System.out.println(new CupomDeTrocaDaoSgbd().existe(1));
			CupomDeTroca cupom = new CupomDeTroca();
			cupom.setValor(111.11);
			cupom.setVenda(new Venda());
			e.registrarCupomDeTroca(cupom);
			
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VendaNaoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Categoria categoria = new Categoria();
		categoria.setId(1);
		Collection<Produto> p = e.buscarProdutosCategoria(categoria);
		for (Produto produto : p) {
			System.out.println(produto.getDescricao());
		}
		
		System.out.println("Teoricamente deu certo");
	}

}
