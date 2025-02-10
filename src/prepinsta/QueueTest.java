package prepinsta;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> queue=new PriorityQueue();
		System.out.println(queue.add(5));
		System.out.println(queue.offer(10));
		System.out.println(queue);
	}

}
