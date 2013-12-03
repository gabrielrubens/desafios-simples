package br.com.gabrielrubens.fibonacci;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Long> {
	private Long n1 = 1L;
	private Long n2 = 1L;
	private Long result = 0L;
	private Long fim;
	private boolean usaFim;

	public FibonacciIterator(){
		this.n1 = 1L;
		this.n2 = 1L;
		this.result = 0L;
	}
	public FibonacciIterator(Long inicio){
		this.configuraValores(inicio);
		this.result = inicio;
	}

	public FibonacciIterator(Long inicio, Long fim){
		this(inicio);
		if(fim<inicio) throw new IllegalArgumentException("O numero inicial deve ser maior que final");
		this.usaFim = true;
		this.fim = fim;
	}
	
	private void configuraValores(Long inicio) {
		FibonacciIterator fibonacciTemp = new FibonacciIterator();
		Long anterior = 0L;
		Long atual = 0L;
		
		for (long i=0; i<inicio;i++) {
			atual = fibonacciTemp.next();
			if(atual <= inicio) {
				anterior = atual;
			}
		}
		
		this.n1 = anterior;
		this.n2 = fibonacciTemp.next();
	}

	public Long next() {
		if(!hasNext()) return result;
		
		if(result == 0) {
			result++;
			return 0L;
		} else if(result <= 2 && n2 == 1) {
			result++;
			return 1L;
		}
		
		result = n1+n2;
		n1=n2;
		n2 = result;
		
		return result;
	}

	public boolean hasNext() {
		if(!usaFim) return true;
		return fim >= (n1+n2);
	}

	public void remove() {
		throw new RuntimeException("Operação não permitida!");
	}
}
