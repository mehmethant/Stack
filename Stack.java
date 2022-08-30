import Exceptions.StackOverFlowException;
import Exceptions.StackUnderFlowException;

public class Stack {
    int[] stack;
    int top;
    int capacity;

    Stack(int size) {
        top = -1;
        stack = new int[size];
        capacity = size;
    }

    public void push(int data) throws StackOverFlowException {
        if (!isFull()) {
            stack[++top] = data;
        } else {
            throw new StackOverFlowException("Stack is Full");
        }
    }

    public int pop() throws StackUnderFlowException {
        if (!isEmpty()) {
            return stack[top--];
        }else {
            throw new StackUnderFlowException("Stack is Empty");
        }
    }

    public int peek() throws StackUnderFlowException {
        if(!isEmpty()){
            return stack[top];
        }
        else {
            throw new StackUnderFlowException("Stack is Empty");
        }
    }

    public boolean isFull() {
        return capacity - 1 == top;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
