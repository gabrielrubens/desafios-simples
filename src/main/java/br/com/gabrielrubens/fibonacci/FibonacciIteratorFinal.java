package br.com.gabrielrubens.fibonacci;

import java.util.Iterator;

public class FibonacciIteratorFinal implements Iterator<FibonacciIteratorFinal> {

	private final Integer n1;
	private final Integer n2;
	private final Integer result;

	public FibonacciIteratorFinal() {
		this.n1 = 0;
		this.n2 = 1;
		this.result = 0;
	}

	private FibonacciIteratorFinal(Integer n1, Integer n2, Integer result) {
		this.n1 = n1;
		this.n2 = n2;
		this.result = result;
	}

	public boolean hasNext() {
		return true;
	}

	public FibonacciIteratorFinal next() {
		if (result == 0)
			return new FibonacciIteratorFinal(n1, n2, result + 1);
		else if (result == 1 && n1 == 0)
			return new FibonacciIteratorFinal(n1 + 1, n2, result);
		return new FibonacciIteratorFinal(n2, result, result + n2);
	}

	@Deprecated
	public void remove() {
		throw new RuntimeException("Operação não permitida!");
	}

	public Integer value() {
		return result;
	}
}