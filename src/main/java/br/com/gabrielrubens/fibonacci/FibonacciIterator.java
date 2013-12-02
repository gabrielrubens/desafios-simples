package br.com.gabrielrubens.fibonacci;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Long> {
	private Long n1 = 1L;
	private Long n2 = 1L;
	private Long result = 0L;

	public FibonacciIterator(){
		this.n1 = 1L;
		this.n2 = 1L;
		this.result = 0L;
	}
	public FibonacciIterator(Long inicio){
		this.n1 = inicio;
		this.n2 = 1L;
		this.result = inicio;
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
		return true;
	}

	public void remove() {
		throw new RuntimeException("Operação não permitida!");
	}
}
