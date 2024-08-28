package exercises.generics.queue2021;

import javax.sound.midi.SysexMessage;

public class Main {
    public static void main(String[] args) {
        MessageQueue<Integer> queue = new MessageQueue<>(3);

        queue.enqueue(1);
        queue.dequeue();

    }
}
