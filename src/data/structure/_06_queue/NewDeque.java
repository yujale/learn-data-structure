package data.structure._06_queue;

import java.util.LinkedList;
import java.util.List;

/**
 * 双端队列的实现
 *
 * @param <E> 队列中元素的类型
 */
public class NewDeque<E> {

    // 使用链表作为底层数据结构
    private final List<E> list = new LinkedList<>();

    /**
     * 获取双端队列中元素的数量
     *
     * @return 队列中元素的数量
     */
    public int size() {
        return list.size();
    }

    /**
     * 检查双端队列是否为空
     *
     * @return 如果队列为空，则返回 true；否则返回 false
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 从队尾入队
     *
     * @param element 要添加到队列的元素
     */
    public void enQueueRear(E element) {
        list.add(element);
    }

    /**
     * 从队头入队
     *
     * @param element 要添加到队列的元素
     */
    public void enQueueFront(E element) {
        // 将元素添加到链表的头部位置
        list.add(0, element);
    }

    /**
     * 从队尾出队
     *
     * @return 队列中的最后一个元素
     * @throws IndexOutOfBoundsException 如果队列为空，则抛出异常
     */
    public E deQueueRear() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque is empty");
        }
        // 移除并返回链表的最后一个元素
        return list.remove(list.size() - 1);
    }

    /**
     * 从队头出队
     *
     * @return 队列中的第一个元素
     * @throws IndexOutOfBoundsException 如果队列为空，则抛出异常
     */
    public E deQueueFront() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque is empty");
        }
        // 移除并返回链表的第一个元素
        return list.remove(0);
    }

    /**
     * 获取双端队列的头部元素
     *
     * @return 队列中的第一个元素
     * @throws IndexOutOfBoundsException 如果队列为空，则抛出异常
     */
    public E front() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque is empty");
        }
        // 返回链表的第一个元素，但不移除它
        return list.get(0);
    }

    /**
     * 获取双端队列的尾部元素
     *
     * @return 队列中的最后一个元素
     * @throws IndexOutOfBoundsException 如果队列为空，则抛出异常
     */
    public E rear() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Deque is empty");
        }
        // 返回链表的最后一个元素，但不移除它
        return list.get(list.size() - 1);
    }

    /**
     * 清空双端队列中的所有元素
     */
    public void clear() {
        list.clear();
    }

    /**
     * 检查双端队列是否包含指定的元素
     *
     * @param element 要检查的元素
     * @return 如果队列包含指定的元素，则返回 true；否则返回 false
     */
    public boolean contains(E element) {
        return list.contains(element);
    }

    /**
     * 返回双端队列的字符串表示形式
     *
     * @return 双端队列的字符串表示形式
     */
    @Override
    public String toString() {
        return "NewDeque{" +
                "list=" + list +
                '}';
    }

}
