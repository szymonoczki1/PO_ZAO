public class Stack {
	private String [] elements;
	public int size;

	public Stack(){
		elements = new String[10];
		size = 0;
	}

	public void push(String element){
		if (size == elements.length){
			resize();
		}

		elements[size] = element;
		size++;
	}
	public String pop(){
		if (size == 0){
			throw new IllegalStateException("stack is empty");
		}
		size--;
		String pop_value = elements[size];
		elements[size] = null;
		
		return pop_value;
	}

	public String peek(){
		if (size == 0){
			throw new IllegalStateException("stack is empty");
		}
		return elements[size-1];
	}

	private void resize(){
		String [] new_array = new String[size * 2];
		System.arraycopy(elements, 0, new_array, 0, size);
		elements = new_array;
	}
}
