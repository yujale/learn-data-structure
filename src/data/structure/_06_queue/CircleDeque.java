package data.structure._06_queue;

/**
 * 循环双端队列
 */
public class CircleDeque<E> {

    private int front; // 队头指针
    private int rear; // 队尾指针，指向队列中最后一个元素的位置
    private int size; // 元素数量
    private E[] elements; // 元素
    public static final int DEFAULT_CAPACITY = 10; // 初始容量

    /**
     * 构造一个具有默认容量的循环双端队列
     */
    public CircleDeque() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 构造一个具有指定容量的循环双端队列
     *
     * @param capacity 循环双端队列的容量
     */
    public CircleDeque(int capacity) {
        elements = (E[]) new Object[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    /**
     * 获取队列中元素的数量
     *
     * @return 队列中元素的数量
     */
    public int size() {
        return size;
    }

    /**
     * 检查队列是否为空
     *
     * @return 如果队列为空，则返回 true；否则返回 false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空队列
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        front = 0;
        size = 0;
    }

    /**
     * 从队尾入队
     *
     * @param element 要入队的元素
     */
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    /**
     * 从队头入队
     *
     * @param element 要入队的元素
     */
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        front = index(-1);
        elements[front] = element;
        size++;
    }

    /**
     * 从队尾出队
     *
     * @return 被移除的队尾元素
     */
    public E deQueueRear() {
        int rearIndex = index(size - 1);
        E rear = (E) elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return rear;
    }

    /**
     * 从队头出队
     *
     * @return 被移除的队头元素
     */
    public E deQueueFront() {
        E frontElement = (E) elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    /**
     * 获取队列的头元素
     *
     * @return 队头元素
     */
    public E front() {
        return (E) elements[front];
    }

    /**
     * 获取队列的尾元素
     *
     * @return 队尾元素
     */
    public E rear() {
        return (E) elements[index(size - 1)];
    }

    /**
     * 确保容量足够
     *
     * @param capacity 需要的容量
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }

        int newCapacity = oldCapacity + (oldCapacity >> 1); // 扩容为1.5倍
        E newElements[] = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = (E) elements[index(i)];
        }
        elements = newElements;
        front = 0; // 重置front
    }

    /**
     * 索引封装映射
     *
     * @param index 需要映射的索引
     * @return 映射后的索引
     */
    private int index(int index) {
        index += front;
        if (index < 0) { // index 为负数
            return index + elements.length;
        }
        // index 为正数
        return index % elements.length;
    }

    /**
     * 返回循环双端队列的字符串表示形式
     *
     * @return 循环双端队列的字符串表示形式
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capacity=").append(elements.length).append(" size=").append(size)
                .append(" front=").append(front).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[index(i)]);
        }
        string.append("]");
        return string.toString();
    }

}
