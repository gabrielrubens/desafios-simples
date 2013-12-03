package br.com.gabrielrubens.fibonacci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.gabrielrubens.fibonacci.FibonacciIterator;

public class FibonacciIteratorTest {

	@Test
	public void deveRetornarZeroParaOPrimeiro() {
		FibonacciIterator fibonacciIterator = new FibonacciIterator();
		Assert.assertEquals(0L, fibonacciIterator.next(), 0);
	}

	@Test
	public void deveRetornarZeroUmEUmParaOsTresPrimeiros() {
		FibonacciIterator fibonacciIterator = new FibonacciIterator();

		List<Long> esperado = Arrays.asList(0L, 1L, 1L);
		List<Long> recebido  = buscaQuantidadeDeElementos(fibonacciIterator, 3);

		Assert.assertEquals(esperado, recebido);
	}

	@Test
	public void deveRetornarOsDesPrimeirosResultDos() {
		FibonacciIterator fibonacciIterator = new FibonacciIterator();

		List<Long> esperado = Arrays.asList(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L,
				21L, 34L);
		List<Long> recebido = buscaQuantidadeDeElementos(fibonacciIterator, 10);

		Assert.assertEquals(esperado, recebido);
	}

	@Test
	public void deveRetornarOResultadoPassandoTresComoNumeroInicial() {
		FibonacciIterator fibonacciIterator = new FibonacciIterator(3L);

		List<Long> esperado = Arrays.asList(3L, 5L, 8L, 13L, 21L, 34L);
		List<Long> recebido = buscaQuantidadeDeElementos(fibonacciIterator, 6);

		Assert.assertEquals(esperado, recebido);
		Assert.assertTrue(fibonacciIterator.hasNext());
	}

	@Test
	public void deveRetornarOResultadoPassandoQuatroComoNumeroInicial() {
		FibonacciIterator fibonacciIterator = new FibonacciIterator(4L);

		List<Long> esperado = Arrays.asList(5L, 8L, 13L, 21L, 34L);
		List<Long> recebido = buscaQuantidadeDeElementos(fibonacciIterator, 5); 
				/*new ArrayList<>();
		recebido.add(fibonacciIterator.next());
		recebido.add(fibonacciIterator.next());
		recebido.add(fibonacciIterator.next());
		recebido.add(fibonacciIterator.next());
		recebido.add(fibonacciIterator.next());*/

		Assert.assertEquals(esperado, recebido);
		Assert.assertTrue(fibonacciIterator.hasNext());
	}

	private List<Long> buscaQuantidadeDeElementos(
			FibonacciIterator fibonacciIterator, int quantidade) {
		List<Long> recebido = new ArrayList<>();
		for (int i = 1; i <= quantidade; i++) {
			recebido.add(fibonacciIterator.next());
		}
		return recebido;
	}
}
