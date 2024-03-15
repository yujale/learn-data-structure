package data.structure._03_array;

import java.util.Arrays;

public class NewArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10; // 默认容量
    private static final int ELEMENT_NOT_FOUND = -1; // 元素未找到的标志
    private Object[] elements; // 存储元素的数组
    private int size; // 数组中元素的数量
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENTS = {};

    /**
     * 构造一个具有指定初始容量的 NewArrayList 对象。
     * 
     * @param capacity 初始容量，必须大于等于 0。
     * @throws IllegalArgumentException 如果容量为负数，则抛出 IllegalArgumentException 异常。
     */
    public NewArrayList(int capacity) {
        if (capacity > 0) {
            // 创建一个具有指定容量的新数组
            elements = new Object[capacity];
        } else if (capacity == 0) {
            // 使用默认的空数组
            elements = DEFAULT_CAPACITY_EMPTY_ELEMENTS;
        } else {
            // 抛出异常，容量不能为负数
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
    }

    /**
     * 默认构造方法，默认容量为 DEFAULT_CAPACITY
     */
    public NewArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 数组最后位置添加元素
     *
     * @param element 元素
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * 在指定位置插入元素
     * 
     * @param index   要插入的位置
     * @param element 要插入的元素值
     * @throws IndexOutOfBoundsException 如果索引越界，则抛出异常
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) { // 检查索引是否有效
            throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
        }

        // 将指定位置及之后的元素向后移动一位
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }

        elements[index] = element; // 将新元素插入到指定位置
        size++; // 数组大小增加1
    }

    /**
     * 获取数组中元素的个数
     * 
     * @return 数组中元素的个数
     */
    public int size() {
        return size;
    }

    /**
     * 判断数组是否为空
     * 
     * @return 若数组为空，返回 true；否则返回 false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取指定位置的元素
     * 
     * @param index 指定位置
     * @return 指定位置的元素
     * @throws IndexOutOfBoundsException 如果索引越界，则抛出异常
     */
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
        }
        return elements[index];
    }

    /**
     * 设置指定位置的元素
     * 
     * @param index   指定位置
     * @param element 要设置的元素值
     * @return 原来指定位置的元素值
     * @throws IndexOutOfBoundsException 如果索引越界，则抛出异常
     */
    public Object set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
        }
        Object oldElements = elements[index];
        elements[index] = element;
        return oldElements;
    }

    /**
     * 查找元素在数组中的索引
     * 
     * @param element 要查找的元素
     * @return 若找到，返回元素的索引；否则返回 ELEMENT_NOT_FOUND
     */
    public int indexOf(E element) {

        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }

        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i] == element) {
                    return i;
                }
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    /**
     * 判断数组是否包含某个元素
     * 
     * @param element 要判断的元素
     * @return 若数组包含该元素，返回true；否则返回false
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 清空数组，并释放数组中的所有元素。
     * 注意：该操作会将数组的大小重置为0，但不会改变数组的容量。
     * 如果希望释放数组的内存空间，可以增加 elements = new Object[0]
     */
    public void clear() {
        // 遍历数组，将每个元素置为 null
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }

        // 将数组大小重置为0
        size = 0;
    }

    /**
     * 删除指定位置的元素。
     *
     * @param index 要删除的元素的位置
     * @return 返回被删除的元素
     * @throws IndexOutOfBoundsException 如果索引越界，则抛出异常
     */
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            // 如果索引越界，则抛出 IndexOutOfBoundsException 异常
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }

        // 保存被删除的元素
        Object removedElement = elements[index];

        // 从 index 开始，将后面的元素往前移动一位
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }

        // 将数组末尾多出来的位置设置为 null，并更新数组大小
        elements[--size] = null;

        return removedElement;
    }

    /**
     * 删除指定的元素对象。
     *
     * @param element 要删除的元素对象
     * @return 返回被删除的元素
     */
    public Object remove(E element) {
        // 调用 indexOf 方法获取元素的位置，并调用 remove(int index) 方法删除元素
        return remove(indexOf(element));
    }

    /**
     * 将数组转换为字符串形式，格式为 "size = 元素个数, [元素1, 元素2, ...]"
     * 
     * @return 转换后的字符串表示
     */
    public String toString() {
        StringBuilder builder = new StringBuilder(); // 创建 StringBuilder 对象
        builder.append("size = ").append(size).append(", ["); // 添加数组大小信息到字符串中

        // 遍历数组元素，添加到字符串中
        for (int i = 0; i < size; i++) {
            if (i != 0) { // 如果不是第一个元素，添加逗号分隔
                builder.append(", ");
            }
            builder.append(elements[i]); // 添加元素到字符串中
        }

        builder.append("]"); // 添加字符串结尾标志
        return builder.toString(); // 返回转换后的字符串
    }

    /**
     * 确保数组容量足够以容纳指定容量
     * 
     * @param capacity 所需的容量
     */
    public void ensureCapacity(int capacity) {
        int oldCapacity = elements.length; // 获取当前数组容量
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 计算新的容量，通常是原容量的1.5倍
        Object[] newElements = new Object[newCapacity]; // 创建新的数组
        // 将原数组中的元素复制到新数组中
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements; // 将原数组引用指向新数组
        System.out.println(oldCapacity + "可扩容为：" + newCapacity); // 打印扩容信息
    }

    /**
     * 将数组的容量调整为当前数组元素的大小。
     * 如果数组的大小小于等于默认容量或当前容量的一半，则不进行调整。
     * 调整后的容量为原容量的一半，如果新容量小于默认容量，则保持不变。
     * 注意：调整容量会创建一个新的数组对象，并将原数组中的元素复制到新数组中。
     */
    public void trimToSize() {
        // 获取当前数组的容量
        int oldCapacity = elements.length;

        // 计算新容量为原容量的一半
        int newCapacity = oldCapacity >> 1;

        // 如果数组大小大于等于新容量，或者原容量已经是默认容量，则不进行调整
        if (size >= newCapacity || oldCapacity <= DEFAULT_CAPACITY) {
            return;
        }

        // 创建一个新的数组对象，并将原数组中的元素复制到新数组中
        Object[] newElements = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        // 更新数组对象为新数组，并输出调整后的容量信息
        elements = newElements;
        System.out.println("size=" + oldCapacity + ", 缩容到" + newCapacity);
    }

}
