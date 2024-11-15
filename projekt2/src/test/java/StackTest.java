import org.junit.*;
import static org.junit.Assert.assertEquals;

public class StackTest {
	@Test
	public void testPopAfterPush() {
		Stack stack = new Stack();
		stack.push("napis");
		String result = stack.pop();

		assertEquals("pop after push", "napis", result);
	}

	@Test
	public void testPeekAfterPush() {
		Stack stack = new Stack();
		stack.push("napis");
		String result = stack.peek();

		assertEquals("peek after push", "napis", result);
	}

	@Test(expected = IllegalStateException.class)
	public void testPopOnEmptyStack(){
		Stack stack = new Stack();
		stack.pop();
	}

	@Test(expected = IllegalStateException.class)
	public void testPeekOnEmptyStack(){
		Stack stack = new Stack();
		stack.peek();
	}

	@Test
	public void testResize(){
		Stack stack = new Stack();
		for(int i = 0; i <= 15; i++){
			stack.push("" + i);
		}

		for(int i = 15; i>= 0; i--){
			assertEquals(Integer.toString(i), stack.pop());
		}
	}
}
