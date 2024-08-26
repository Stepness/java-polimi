package session;

import java.rmi.server.ExportException;
import java.util.LinkedList;
import java.util.List;

public class Stack<T> {

    private LinkedList<T> data = new LinkedList<>();
    private final int size;

    public Stack(int size) {
        this.size = size;
    }

    public Stack() {
        this(10);
    }

    public void push(T elem) throws Exception {
        if (size == data.size()){
            throw new Exception();
        }
        data.addLast(elem);
    }

    public T pop() throws Exception {
        if (!data.isEmpty()) {
            return data.removeLast();
        }
        throw new Exception();
    }

    public static void main(String[] args) throws Exception {
        Stack<String> stack = new Stack<>(2);

        stack.push("20");
        stack.push("21");
        System.out.println(stack.pop());
    }
}
