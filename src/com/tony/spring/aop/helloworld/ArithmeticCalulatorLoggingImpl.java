package com.tony.spring.aop.helloworld;

public class ArithmeticCalulatorLoggingImpl implements ArithmeticCalulator {

	@Override
	public int add(int i, int j) {

		System.out.println("The method add begins with [" + i + ", " + j + "]");

		int result = i + j;
		System.out.println("The method add ends with " + result);
		return result;
	}

	@Override
	public int sub(int i, int j) {

		System.out.println("The method sub begins with [" + i + ", " + j + "]");

		int result = i - j;
		System.out.println("The method sub ends with " + result);

		return result;
	}

	@Override
	public int mul(int i, int j) {
		System.out.println("The method multi begins with [" + i + ", " + j + "]");

		int result = i * j;
		System.out.println("The method add ends with " + result);

		return result;
	}

	@Override
	public int div(int i, int j) {
		System.out.println("The method divid begins with [" + i + ", " + j + "]");

		int result = i / j;
		System.out.println("The method add ends with " + result);

		return result;
	}

}
