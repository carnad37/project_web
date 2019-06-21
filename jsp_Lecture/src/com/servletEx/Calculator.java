package com.servletEx;

public class Calculator {

	public int add(int x, int y) {
		return x + y;
	}
	public int sub(int x, int y) {
		return x - y;
	}
	public int mul(int x, int y) {
		return x * y;
	}
	public double div(int x, int y) {
		double div = (double)x / y;
		div *= 10;
		div = Math.round(div);
		div /= 10;
		return div;
	}
}
