package data.structure._05_stack;

import java.util.ArrayList;

public class NewStack<E> {

    private final ArrayList<E> list = new ArrayList<>();

    /**
     * 创建一个新的栈对象。
     */
    public NewStack() {
    }

    /**
     * 将元素推入栈顶。
     *
     * @param element 要推入栈的元素
     * @return 返回推入的元素
     */
    public E push(E element) {
        list.add(element);
        return element;
    }

    /**
     * 弹出栈顶的元素。
     *
     * @return 返回被弹出的元素
     * @throws IllegalStateException 如果栈为空，则抛出异常
     */
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.remove(list.size() - 1);
    }

    /**
     * 返回栈中元素的数量。
     *
     * @return 返回栈中元素的数量
     */
    public int size() {
        return list.size();
    }

    /**
     * 检查栈是否为空。
     *
     * @return 如果栈为空，则返回 true；否则返回 false
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 返回栈顶的元素，但不将其从栈中移除。
     *
     * @return 返回栈顶的元素
     * @throws IllegalStateException 如果栈为空，则抛出异常
     */
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    /**
     * 清空栈中的所有元素。
     */
    public void clear() {
        list.clear();
    }

}