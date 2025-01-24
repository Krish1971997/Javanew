package leetcodeZoho;

public class MyCircularQueue {

	public static void main(String[] args) {
		CustomQueue customQueue = new CustomQueue(3);
		// Enqueue elements
		System.out.println("Enqueue 1: " + customQueue.enQueue(1)); // return true
		System.out.println("Enqueue 2: " + customQueue.enQueue(2)); // return true
		System.out.println("Enqueue 3: " 	+ customQueue.enQueue(3)); // return true
		System.out.println("Enqueue 4: " + customQueue.enQueue(4)); // return false, queue is full

		// Display front and rear elements
		System.out.println("Front: " + customQueue.Front()); // return 1
		System.out.println("Rear: " + customQueue.Rear()); // return 3

		// Dequeue elements
		System.out.println("Dequeue: " + customQueue.deQueue()); // return true
		System.out.println("Enqueue 4: " + customQueue.enQueue(4)); // return true

		// Display front and rear elements after dequeue
		System.out.println("Front: " + customQueue.Front()); // return 2
		System.out.println("Rear: " + customQueue.Rear()); // return 4
	}
}

class CustomQueue{
	private int[] queue;
	private int front;
	private int rear;
	private int size;
	private int capacity;

	public CustomQueue(int k) {
		this.queue = new int[k];
		this.front = 0;
		this.rear = -1;
		this.size = 0;
		this.capacity = k;
	}

	public boolean enQueue(int value) {
		if (!isFull()) {
			rear = (rear + 1) % capacity;
			queue[rear] = value;
			size++;
			return true;
		}
		return false;
	}

	public boolean deQueue() {
		if (!isEmpty()) {
			front = (front + 1) % capacity;
			size--;
			return true;
		}
		return false;
	}

	public int Front(){
		return isEmpty() ? -1 : queue[front];
	}

	public int Rear() {
		return isEmpty() ? -1 : queue[rear];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}
}
