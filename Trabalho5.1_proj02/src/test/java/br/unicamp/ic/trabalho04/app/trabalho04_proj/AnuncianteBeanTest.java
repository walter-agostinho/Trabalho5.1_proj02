package br.unicamp.ic.trabalho04.app.trabalho04_proj;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnuncianteBeanTest {
	

	Double ValorProduto1 = 15.00;
	Double ValorProduto2 = 5.00;
	Double ValorProduto3 = 10.00;
	
	Double Desconto = 0.5;

	private ProdutoBean NovoProduto(Double valor) {
	    return new ProdutoBean("00AB00", "Produto A", "Descritivo do Produto", valor, "NOVO");
	    
	}
	 private ArrayList<AnuncioBean> ListaDeAnuncios() {
	        final ArrayList<AnuncioBean> anuncios = new ArrayList<AnuncioBean>();
	        anuncios.add(NovoAnuncio(ValorProduto1));
	        anuncios.add(NovoAnuncio(ValorProduto2));
	        anuncios.add(NovoAnuncio(ValorProduto3));

	        return anuncios;
	    }
	 private AnuncianteBean NovoAnunciante() {
	        return new AnuncianteBean("John", "781.757.680-70", ListaDeAnuncios());
	    }
	public AnuncioBean NovoAnuncio(Double valor) {
		
	    try {
	        final URL url = new URL("https://junit.org/junit5/");
	        
	        final ArrayList<URL> fotos = new ArrayList<URL>();
	        fotos.add(url);
	        fotos.add(url);

	        return new AnuncioBean(NovoProduto(valor), fotos, Desconto);
	    } catch (MalformedURLException ex) {
	        return new AnuncioBean(NovoProduto(valor), new ArrayList<URL>(), Desconto);
	    }
	}
	
	@Test
    public void testAddAnuncio() {
        final AnuncianteBean a1 = NovoAnunciante();
        a1.addAnuncio(NovoAnuncio(ValorProduto1));

        Assertions.assertEquals(4, a1.getAnuncios().size());
    }

    @Test
    public void testRemoveAnuncio() {
        final AnuncianteBean a1 = NovoAnunciante();
        a1.removeAnuncio(0);

        Assertions.assertEquals(2, a1.getAnuncios().size());
    }

    @Test
    public void testValorMedioAnuncios() {
        final AnuncianteBean a = NovoAnunciante();
        Assertions.assertEquals(5, a.valorMedioAnuncios());
    }

}