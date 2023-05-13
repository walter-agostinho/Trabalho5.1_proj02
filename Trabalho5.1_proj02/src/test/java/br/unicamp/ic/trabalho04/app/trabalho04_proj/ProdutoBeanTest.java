package br.unicamp.ic.trabalho04.app.trabalho04_proj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProdutoBeanTest {
	
	ProdutoBean ProdutoPrecoMaior = new ProdutoBean("00344","Produto A", "Descritivo",20.00, "Novo");
	ProdutoBean ProdutoPrecoMenor = new ProdutoBean("00332","Produto Z", "Descritivo",5.00, "Usado");
	
	
	
	@Test
	public void CompareToTest() {
		Assertions.assertEquals(1, ProdutoPrecoMaior.compareTo(ProdutoPrecoMenor));
		Assertions.assertEquals(-1, ProdutoPrecoMenor.compareTo(ProdutoPrecoMaior));
		Assertions.assertEquals(0, ProdutoPrecoMenor.compareTo(ProdutoPrecoMenor));
	}
	
	
}