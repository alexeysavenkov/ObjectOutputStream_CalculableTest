package client;

import java.io.Serializable;

import common.Calculable;

public class CalculableImpl implements Calculable, Serializable {

	@Override
	public double calc() {
		System.out.println("Calculating...");
		return 42;
	}

}
