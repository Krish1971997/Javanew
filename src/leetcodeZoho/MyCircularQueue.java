package leetcodeZoho;

class MyCircularQueue {

	public static void main(String[] args) {
		MyCircularQueue circularQueue = new MyCircularQueue(3);
		// Enqueue elements
		System.out.println("Enqueue 1: " + circularQueue.enQueue(1)); // return true
		System.out.println("Enqueue 2: " + circularQueue.enQueue(2)); // return true
		System.out.println("Enqueue 3: " 	+ circularQueue.enQueue(3)); // return true
		System.out.println("Enqueue 4: " + circularQueue.enQueue(4)); // return false, queue is full

		// Display front and rear elements
		System.out.println("Front: " + circularQueue.Front()); // return 1
		System.out.println("Rear: " + circularQueue.Rear()); // return 3

		// Dequeue elements
		System.out.println("Dequeue: " + circularQueue.deQueue()); // return true
		System.out.println("Enqueue 4: " + circularQueue.enQueue(4)); // return true

		// Display front and rear elements after dequeue
		System.out.println("Front: " + circularQueue.Front()); // return 2
		System.out.println("Rear: " + circularQueue.Rear()); // return 4
	}

	private int[] queue;
	private int front;
	private int rear;
	private int size;
	private int capacity;

	public MyCircularQueue(int k) {
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
