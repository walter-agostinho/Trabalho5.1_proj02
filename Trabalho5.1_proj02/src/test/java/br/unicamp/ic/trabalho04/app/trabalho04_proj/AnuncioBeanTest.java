package br.unicamp.ic.trabalho04.app.trabalho04_proj;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnuncioBeanTest {



Double ValorComDesconto= 8.0;	
Double ValorProduto = 10.00;
Double Desconto = 0.2;

private ProdutoBean NovoProduto(Double valor) {
    return new ProdutoBean("00AB00", "Produto A", "Descritivo do Produto", valor, "NOVO");
}

public AnuncioBean NovoAnuncio(Double valor,Double Desconto) {
	
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
public void TestDesconto() {
	Assertions.assertEquals(ValorComDesconto, NovoAnuncio(ValorProduto, Desconto).getValor());
}
@Test
public void TestSemDesconto() {
	Assertions.assertEquals(ValorProduto, NovoAnuncio(ValorProduto,0.0).getValor());
}
@Test
public void TestDescontoTotal() {
	Assertions.assertEquals(0.0, NovoAnuncio(ValorProduto,1.0).getValor());
}


}