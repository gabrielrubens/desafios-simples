package br.com.gabrielrubens.fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.gabrielrubens.fibonacci.FibonacciIterator;

public class FibonacciIteratorTest {
	private FibonacciIterator fibonacciIterator;
	
	@Test
	public void deveRetornarZeroParaOPrimeiro() {
		FibonacciIterator fibonacciIterator = new FibonacciIterator();
		Assert.assertEquals(0L, fibonacciIterator.next(), 0);
	}

	@Test
	public void deveRetornarZeroUmEUmParaOsTresPrimeiros() {
		fibonacciIterator = new FibonacciIterator();

		List<Long> esperado = Arrays.asList(0L, 1L, 1L);
		List<Long> recebido  = buscaQuantidadeDeElementos(fibonacciIterator, 3);

		Assert.assertEquals(esperado, recebido);
	}

	@Test
	public void deveRetornarOsDesPrimeirosResultDos() {
		fibonacciIterator = new FibonacciIterator();

		List<Long> esperado = Arrays.asList(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L,
				21L, 34L);
		List<Long> recebido = buscaQuantidadeDeElementos(fibonacciIterator, 10);

		Assert.assertEquals(esperado, recebido);
	}

	@Test
	public void deveRetornarOResultadoPassandoTresComoNumeroInicial() {
		fibonacciIterator = new FibonacciIterator(3L);

		List<Long> esperado = Arrays.asList(3L, 5L, 8L, 13L, 21L, 34L);
		List<Long> recebido = buscaQuantidadeDeElementos(fibonacciIterator, 6);

		Assert.assertEquals(esperado, recebido);
		Assert.assertTrue(fibonacciIterator.hasNext());
	}

	@Test
	public void deveRetornarOResultadoPassandoQuatroComoNumeroInicial() {
		fibonacciIterator = new FibonacciIterator(4L);
		
		List<Long> esperado = Arrays.asList(5L, 8L, 13L, 21L, 34L);
		List<Long> recebido = buscaQuantidadeDeElementos(fibonacciIterator, 5); 

		Assert.assertEquals(esperado, recebido);
		Assert.assertTrue(fibonacciIterator.hasNext());
	}

	@Test
	public void deveRetornarOResultadoPassando4ComoNumeroInicialE35ComoFinal() {
		fibonacciIterator = new FibonacciIterator(4L, 35L);
		
		List<Long> esperado = Arrays.asList(5L, 8L, 13L, 21L, 34L, 34L);
		List<Long> recebido = buscaQuantidadeDeElementos(fibonacciIterator, 6); 

		Assert.assertEquals(esperado, recebido);
		Assert.assertFalse(fibonacciIterator.hasNext());
	}

	@Test(expected=IllegalArgumentException.class)
	public void deveRetornarExceptionCadoONumeroFinalSejaMenorQueOInicial() {
		fibonacciIterator = new FibonacciIterator(35L, 4L);
	}
	
	private List<Long> buscaQuantidadeDeElementos(FibonacciIterator fibonacciIterator, int qtd) {
		List<Long> recebido = new ArrayList<>();
		for (int i = 1; i <= qtd; i++) {
			recebido.add(fibonacciIterator.next());
		}
		return recebido;
	}
}