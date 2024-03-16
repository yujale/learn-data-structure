package data.structure._06_queue;

/**
 * 循环单端队列
 */
public class CircleQueue<E> {
    private int front; // 队首指针，指向队列中第一个元素
    private int rear; // 队尾指针，指向队列中最后一个元素的下一个位置
    private E[] elements; // 保存队列元素的数组
    private int size; // 队列中元素的数量

    private static final int DEFAULT_CAPACITY = 10; // 默认容量

    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;

    /**
     * 构造一个具有默认容量的循环队列
     */
    public CircleQueue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 构造一个具有指定容量的循环队列
     *
     * @param capacity 循环队列的容量
     */
    public CircleQueue(int capacity) {
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
        // 将队列中所有元素置为 null
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        size = 0;
        front = 0; // 重置队首指针
    }

    /**
     * 计算元素在数组中的索引
     *
     * @param index 元素在队列中的索引
     * @return 元素在数组中的索引
     */
    private int index(int index) {
        return (front + index) % elements.length;
    }

    /**
     * 向队尾插入一个元素
     *
     * @param element 要插入的元素
     */
    public void enQueue(E element) {
        ensureCapacity(size + 1); // 确保容量
        elements[rear] = element; // 将元素插入到队尾
        rear = (rear + 1) % elements.length; // 更新队尾指针
        size++; // 队列大小加 1
    }

    /**
     * 从队首移除一个元素并返回
     *
     * @return 被移除的队首元素
     */
    public E deQueue() {
        E frontElement = elements[front]; // 获取队首元素
        elements[front] = null; // 将队首元素置为 null
        front = (front + 1) % elements.length; // 更新队首指针
        size--; // 队列大小减一
        return frontElement;
    }

    /**
     * 获取队首元素但不移除
     *
     * @return 队首元素
     * @throws IllegalStateException 如果队列为空，则抛出异常
     */
    public E front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[front];
    }

    /**
     * 获取队尾元素但不移除
     *
     * @return 队尾元素
     * @throws IllegalStateException 如果队列为空，则抛出异常
     */
    public E rear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements[(rear - 1 + elements.length) % elements.length];
    }

    /**
     * 确保容量足够
     *
     * @param capacity 需要确保的容量
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 扩容为原来的 1.5 倍
        if (newCapacity - capacity < 0) {
            newCapacity = capacity; // 新容量小于所需容量，则直接使用所需容量
        }
        if (newCapacity - MAX_CAPACITY > 0) {
            newCapacity = capacity > MAX_CAPACITY ? Integer.MAX_VALUE : MAX_CAPACITY; // 最大容量检查
        }
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = (E[]) newElements;
        front = 0; // 更新队首指针
        rear = size; // 更新队尾指针
    }

    /**
     * 返回循环队列的字符串表示形式
     *
     * @return 循环队列的字符串表示形式
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capacity = ").append(elements.length).append(", size = ").append(size)
                .append(", front = ").append(front).append(", [");
        // 遍历数组，将元素添加到字符串中
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
