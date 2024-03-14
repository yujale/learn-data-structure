# 一、数组 Array

数组是一种顺序存储的线性表，所有元素的内存地址都是连续的

```java
int[] array = new int[]{11,22,33};
```

![](https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/4a02ea7e00e64fa1afab4a87405b332d~tplv-k3u1fbpfcp-zoom-in-crop-mark:1512:0:0:0.awebp?)

- 在很多编程语言中，数组有个致命的缺点， 无法动态修改容量。

- 实际开发中我们希望数组的容量是动态变化的。

# 二、动态数组（Dynamic Array）

动态数组是指在声明时没有确定数组大小的数组，可以根据用户需求可以自动增加或者减少数组空间，有效的利用空间。

## 接口设计

- size() 获取数组中元素的个数
- isEmpty() 判断数组是否为空
- contains(E) 查找数组中是否有元素e
- get(index) 获取指定位置的元素
- set(index, e) 修改index位置的元素为e
- add(index, e) 向数组中指定位置添加一个元素
- addLast(e) 向数组末尾添加一个元素
- addFirst(e) 向数组头部添加一个元素
- remove(index) 删除指定位置的元素，并返回删除的元素
- removeFirst() 删除数组中的第一个元素，并返回删除的元素
- removeLast() 删除数组中的最后一个元素，并返回删除的元素
- removeElement(e) 删除数组中的元素e
- indexOf(E) 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
- toString() 将数组转化为字符串

```java
public class NewArray<E> {

  private int size;
  private Object[] elements;    // 设置elements数组默认的初始化空间
  private static final int DEFAULT_CAPACITY = 10;

  public int size() {
  }

  public boolean isEmpty() {
  }

  public boolean contains(E element) {
  }

  public E get(int index) {
  }

  public E set(int index, E element) {
  }

  public void add(int index, E element) {
  }

  public void add(E element) {
  }

  public E remove(int index) {
  }

  public E removeFirst() {
  }

  public E removeLast() {
  }

  public boolean removeElement(E element) {
  }

  public int indexOf(E element) {
  }

  private E elements(int index) {
  }

}
```

# 三、动态数组的实现

## 1 构造方法

如果构建的数组空间小于默认空间，则会以默认空间构建数组。

```java
public class NewArray<E> {

  private int size;
  private Object[] elements;    // 设置elements数组默认的初始化空间
  private static final int DEFAULT_CAPACITY = 10;

  public NewArray() {
    this(DEFAULT_CAPACITY);
  }

  public NewArray(int initialCapacity) {
    //  initialCapacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY:initialCapacity;
    if (initialCapacity > 0) {
      this.elements = new Object[initialCapacity];
    } else if (initialCapacity == 0) {
      this.elements = DEFAULT_CAPACITY_EMPTY_ELEMENTS;
    } else {
      throw new IllegalArgumentException("Illegal Capacity: " +
          initialCapacity);
    }
  }
}
```
## 2 数组中元素的数量

- size 的值，即为元素的数量
```java
public int size() {
  return size;
}
```

## 3 数组是否为空

- 通过判断 size 的值是否为 0

```java
public boolean isEmpty() {
  return size == 0;
}
```

## 4 数组中是否包含某个元素

- 通过 indexOf() 方法，判断元素是否存在，如果存在，则返回元素的索引，如果不存在，则返回 -1
```java
public boolean contains(E element) {
  return indexOf(element) >= 0;
}
```

## 5 获取指定位置的元素

- 通过 get() 方法，获取指定位置的元素
```java
public E get(int index) {
  rangeCheck(index);
  return elements(index);
}
```

## 6 设置指定位置的元素

- 通过 set() 方法，设置指定位置的元素
```java
public E set(int index, E element) {
  rangeCheck(index);
  E oldValue = elements(index);
  elements[index] = element;
  return oldValue;
}
```

## 7 在指定位置添加元素

- 通过 add() 方法，在指定位置添加元素
```java
public void add(int index, E element) {
  rangeCheckForAdd(index);
  ensureCapacity(size + 1);
  System.arraycopy(elements, index, elements, index + 1, size - index);
  elements[index] = element;
  size++;
}
```

## 8 在数组末尾添加元素

- 通过 add() 方法，在数组末尾添加元素
```java
public void add(E element) {
  add(size, element);
}
```

## 9 删除指定位置的元素

- 通过 remove() 方法，删除指定位置的元素
```java
public E remove(int index) {
  rangeCheck(index);
  E oldValue = elements(index);
  int numMoved = size - index - 1;
  if (numMoved > 0)
    System.arraycopy(elements, index + 1, elements, index, numMoved);
  elements[--size] = null; // clear to let GC do its work
  return oldValue;
}
```

## 10 删除数组中的第一个元素

- 通过 removeFirst() 方法，删除数组中的第一个元素
```java
public E removeFirst() {
  return remove(0);
}
```

## 11 删除数组中的最后一个元素

- 通过 removeLast() 方法，删除数组中的最后一个元素
```java
public E removeLast() {
  return remove(size - 1);
}
```

## 12 删除数组中的指定元素

- 通过 removeElement() 方法，删除数组中的指定元素
```java

public boolean removeElement(E element) {
  int index = indexOf(element);
  if (index >= 0) {
    remove(index);
    return true;
  }
  return false;
}
```

## 13 数组扩容

- 通过 ensureCapacity() 方法，数组扩容
```java

private void ensureCapacity(int minCapacity) {
  if (minCapacity - elements.length > 0)
    grow(minCapacity);
}

private void grow(int minCapacity) {
  int oldCapacity = elements.length;
  int newCapacity = oldCapacity + (oldCapacity >> 1);
  if (newCapacity - minCapacity < 0)
    newCapacity = minCapacity;
  if (newCapacity - MAX_ARRAY_SIZE > 0)
    newCapacity = hugeCapacity(minCapacity);
  // minCapacity is usually close to size, so this is a win:
  elements = Arrays.copyOf(elements, newCapacity);
}

private static int hugeCapacity(int minCapacity) {
  if (minCapacity < 0) // overflow
    throw new OutOfMemoryError();
  return (minCapacity > MAX_ARRAY_SIZE) ?
      Integer.MAX_VALUE :
      MAX_ARRAY_SIZE;
}
```

## 14 数组缩容

- 通过 trimToSize() 方法，数组缩容
```java

public void trimToSize() {
  modCount++;
  if (size < elements.length) {
    elements = (size == 0)
        ? EMPTY_ELEMENTDATA
        : Arrays.copyOf(elements, size);
  }
}
```

## 15 数组中元素的索引

- 通过 indexOf() 方法，获取元素的索引
```java

public int indexOf(E element) {
  if (element == null) {
    for (int i = 0; i < size; i++)
      if (elements[i] == null)
        return i;
  } else {
    for (int i = 0; i < size; i++)
      if (element.equals(elements[i]))
        return i;
  }
  return -1;
}
```

## 16 清空数组

- 通过 clear() 方法，清空数组
```java

public void clear() {
  // clear to let GC do its work
  for (int i = 0; i < size; i++)
    elements[i] = null;
  size = 0;
}
```

## 17 打印数组

- 通过 toString() 方法，打印数组
```java

public String toString() {
  if (size == 0)
    return "[]";
  else {
    StringBuilder sb = new StringBuilder(size).append("[");
    for (int i = 0; i < size; i++) {
      if (i == size - 1) {
        sb.append(elements[i]);
      } else {
        sb.append(elements[i]).append(", ");
      }
    }
    return sb.append("]").toString();
  }
}
```
