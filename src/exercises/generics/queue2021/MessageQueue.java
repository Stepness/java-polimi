package exercises.generics.queue2021;

import java.util.ArrayList;
import java.util.List;

class MessageQueue <T> {
    private List<T> data;
    private int size;

    public MessageQueue(int size) {
        data = new ArrayList<>();
        this.size = size;
    }
    public void enqueue(T value) {
        data.addFirst(value);
    }

    public T dequeue() {
        return data.removeLast();
    }
}