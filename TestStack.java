import Exceptions.StackOverFlowException;
import Exceptions.StackUnderFlowException;

import org.junit.*;

import static org.junit.Assert.*;

public class TestStack {
    Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = new Stack(5);
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public void testPush() {
        try {
            stack.push(1);
            stack.push(2);
            stack.push(4);
            stack.push(5);
            assertEquals(stack.peek(), 5);
            stack.pop();
            assertEquals(stack.peek(), 4);
            stack.push(7);
            assertEquals(stack.peek(), 7);
        }catch (StackUnderFlowException  | StackOverFlowException ignored){

        }
    }

    @Test
    public void testPop() {
        try {
            stack.pop();
            fail();
        } catch (StackUnderFlowException ignored) {
            assertEquals(ignored.getMessage(), "Stack is Empty");
        }

        try {
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(7);
            assertEquals(7, stack.peek());
            stack.pop();
            stack.pop();
            assertEquals(4, stack.peek());

        } catch (StackOverFlowException | StackUnderFlowException e) {
            fail();
        }
    }

    @Test
    public void testPeek() {
        try {
            stack.peek();
            fail();
        } catch (StackUnderFlowException ignored) {
            assertEquals(ignored.getMessage(), "Stack is Empty");

        }

        try {
            stack.push(1);
            assertEquals(1, stack.peek());
            stack.push(2);
            assertEquals(2, stack.peek());
            stack.pop();
            assertEquals(1, stack.peek());
        } catch (StackUnderFlowException | StackOverFlowException e) {
            fail();
        }

        try {
            stack.pop();
            stack.peek();
            fail();
        } catch (StackUnderFlowException ignored) {
            assertEquals(ignored.getMessage(), "Stack is Empty");

        }

    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());

        try {

            stack.push(1);
            assertFalse(stack.isEmpty());
            stack.pop();
            assertTrue(stack.isEmpty());

        } catch (StackOverFlowException | StackUnderFlowException ignored) {
            fail();
        }
    }

    @Test
    public void testIsFull() {
        assertFalse(stack.isFull());
        try {
            for (int i = 0; i < 4; i++) {
                stack.push(i);
                assertFalse(stack.isFull());
            }
            stack.push(5);
            assertTrue(stack.isFull());

            for (int i=0;i<4;i++){
                stack.pop();
                assertFalse(stack.isFull());
            }
        } catch (StackOverFlowException |StackUnderFlowException ignored) {
            fail();
        }
    }
}
