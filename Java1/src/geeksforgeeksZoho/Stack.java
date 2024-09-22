package geeksforgeeksZoho;

import java.util.EmptyStackException;

class StackExample {
    private static final int MAX_SIZE = 1000;
    private int[] array;
    private int top;

    public StackExample() {
        array = new int[MAX_SIZE];
        top = -1;
    }

    public void push(int value) {
        if (top == MAX_SIZE - 1) {
            System.out.println("Stack Overflow: Cannot push element, stack is full.");
            return;
        }
        array[++top] = value;
        System.out.println(value + " pushed to the stack.");
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = array[top--];
        System.out.println(value + " popped from the stack.");
        return value;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}

public class Stack {
    public static void main(String[] args) {
    	StackExample stack = new StackExample();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.print();
        System.out.println("Current stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        stack.pop();
        stack.push(50);
        stack.print();

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
