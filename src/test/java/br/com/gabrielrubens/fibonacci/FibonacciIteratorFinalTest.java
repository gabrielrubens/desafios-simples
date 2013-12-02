package br.com.gabrielrubens.fibonacci;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FibonacciIteratorFinalTest {
	private List<Integer> esperado;
	private List<Integer> recebido;
	private FibonacciIteratorFinal finonacci;
	
	@Before
	public void setUp(){
		recebido = new ArrayList<Integer>();
		finonacci = new FibonacciIteratorFinal();
	}
	
	@Test
	public void deveRetonarZeroComoPrimeiroElementoEHasnextIgualATrue() {
		assertEquals(0, finonacci.value(), 0);
		assertTrue(finonacci.hasNext());
	}

	@Test
	public void deveRetonarZeroUmeUmComoPrimeirosElementos() {
		esperado = Arrays.asList(0,1,1);
		
		recebido.add(finonacci.value());
		finonacci = finonacci.next();
		recebido.add(finonacci.value());
		finonacci = finonacci.next();
		recebido.add(finonacci.value());
		
		assertEquals(esperado, recebido);
		assertTrue(finonacci.hasNext());
	}
	
	@Test
	public void deveRetonarOsOitoPrimeirosElementos() {
		esperado = Arrays.asList(0,1,1,2,3,5,8,13);
		recebido.add(finonacci.value());
		
		for(int i=0; i <= 6; i++){
			finonacci = finonacci.next();
			recebido.add(finonacci.value());
		}
		
		assertEquals(esperado, recebido);
		assertTrue(finonacci.hasNext());
	}
}