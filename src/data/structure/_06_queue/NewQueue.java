package data.structure._06_queue;

import java.util.LinkedList;
import java.util.List;

/**
 * 单向队列
 *
 * @param <E> 队列中元素的类型
 */
public class NewQueue<E> {

    // 使用链表作为底层数据结构
    private final List<E> list = new LinkedList<>();

    /**
     * 获取队列中元素的数量
     *
     * @return 队列中元素的数量
     */
    public int size() {
        return list.size();
    }

    /**
     * 检查队列是否为空
     *
     * @return 如果队列为空，则返回 true；否则返回 false
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 将元素添加到队列的末尾
     *
     * @param element 要添加到队列的元素
     */
    public void enQueue(E element) {
        list.add(element);
    }

    /**
     * 移除并返回队列中的第一个元素
     *
     * @return 队列中的第一个元素
     * @throws IndexOutOfBoundsException 如果队列为空，则抛出异常
     */
    public E deQueue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return list.remove(0);
    }

    /**
     * 获取队列中的第一个元素，但不移除它
     *
     * @return 队列中的第一个元素
     * @throws IndexOutOfBoundsException 如果队列为空，则抛出异常
     */
    public E front() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return list.get(0);
    }

}
