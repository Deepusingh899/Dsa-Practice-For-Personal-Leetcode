package Queue;
import java.util.*;

public class QueueUsingJCF {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println("Queue: " + queue);
        System.out.println("Removed element: " + queue.poll());
        System.out.println("Queue after removal: " + queue);
    }
}