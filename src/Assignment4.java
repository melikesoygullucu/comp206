public class Assignment4 {
	public static final int CAPACITY = 1000;
	private int[] data;
	private int front = 0;
	private int size = 0;

	public int size() {
		return size;
	}

	public Assignment4() {
		this(CAPACITY);
		this.data = new int[CAPACITY];
	}

	public Assignment4(int capacity) {
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int first() {
		if (isEmpty())
			return -1;
		return data[front];
	}

	public void enqueue(int e) {
		if (size == data.length)
			throw new IllegalStateException("Queue is full");
		int avail = (front + size) % data.length;
		data[avail] = e;
		size++;
	}

	public int dequeue() {
		if (isEmpty())
			return -1;
		int answer = data[front];
		front = (front + 1) % data.length;
		size--;
		return answer;
	}

	public void display() {
		if (size == 0) {
			System.out.println("Queue is empty");
			return;
		}
		int i = front;
		for (int j = 0; j < size; j++) {
			System.out.print(data[i] + " ");
			i = (i + 1) % data.length;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment4 queue = new Assignment4();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.print("Queue elements : ");
		queue.display();

		queue.dequeue();
		queue.dequeue();
		queue.dequeue();

		System.out.print("Queue elements : ");
		queue.display();

		System.out.print("First element of queue : ");
		System.out.println(queue.first());
	}

}
