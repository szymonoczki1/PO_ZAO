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

	public void setState(double state) {
		this.state = state;
	}

	public void add(double value){
		double result = state + value;
		if(Double.isInfinite(result)){
			throw new ArithmeticException("double overflow");
		}
		state = result;
	}

	public void mult(double value){
        double result = state * value;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("double overflow");
        }
        state = result;
    }

	public void sub(double value) {
        double result = state - value;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("double overflow");
        }
        state = result;
    }

	public void div(double value){
        if (value == 0) {
            throw new IllegalArgumentException("division by zero");
        }
        double result = state / value;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("double overflow");
        }
        state = result;
    }

	public void addMem(){
        double result = state + memory;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("double overflow");
        }
        state = result;
    }

	public void multMem(){
        double result = state * memory;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("double overflow");
        }
        state = result;
    }

	public void subMem(){
        double result = state - memory;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("double overflow");
        }
        state = result;
    }

	public void divMem(){
        if (memory == 0){
            throw new IllegalArgumentException("division by zero with memory");
        }
        double result = state / memory;
        if (Double.isInfinite(result)) {
            throw new ArithmeticException("double overflow");
        }
        state = result;
    }

	public void power(int exponent){
		double result = 1;
		for (int i=0; i<Math.abs(exponent); i++){
			result *= state;
			if (Double.isInfinite(result)){
				throw new ArithmeticException("double overflow");
			}
		}
		if (exponent<0){
			result = 1/result;
		}
		state = result;
	}
}
