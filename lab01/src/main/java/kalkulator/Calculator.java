package kalkulator;

public class Calculator {
	private double state = 0;
	private double memory = 0;

	public double getMemory(){
		return this.memory;
	}

	public void clearMemory(){
		this.memory = 0;
	}

	public void saveInMemory(){
		this.memory = this.state;
	}

	public double getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void add(int value){
		state += value;
	}

	public void mult(int value){
		state *= value;
	}

	public void sub(int value){
		state -= value;
	}

	public void div(int value){
		if (value != 0){
			state = state/value;
		} else {
			throw new java.lang.IllegalArgumentException("dzielenie przez zero");
		}
	}

	public void addMem(){
		state += memory;
	}

	public void multMem(){
		state *= memory;
	}

	public void subMem(){
		state -= memory;
	}

	public void divMem(){
		if (memory != 0){
			state = state/memory;
		} else {
			throw new java.lang.IllegalArgumentException("dzielenie przez zero");
		}
	}
}
