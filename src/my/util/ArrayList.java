package my.util;

import sun.misc.SharedSecrets;

import java.util.*;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/17
 */
public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable {
    public static void main() {
        List list = new java.util.ArrayList();
    }

    private static final long serialVersionUID = 3469756327917257639L;

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    private int size;

    public ArrayList(int initialCapacity) {
        if (0 < initialCapacity) {
            this.elementData = new Object[initialCapacity];
        } else if (0 == initialCapacity) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity" + initialCapacity);
        }
    }

    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public ArrayList(Collection<? extends E> c) {
        this.elementData = c.toArray();
        if (0 != (size = elementData.length)) {
            // 如果 size 为 0 ,即传入的是空集合
            if (elementData.getClass() != Object[].class) {
                this.elementData = Arrays.copyOf(elementData, size, Object[].class);
            }
        } else {
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    public void trimToSize() {
        modCount++;
        if (size < elementData.length) {
            elementData = (0 == size)
                    ? EMPTY_ELEMENTDATA
                    : Arrays.copyOf(elementData, size);
        }
    }

    public void ensureCapacity(int minCapacity) {
        int minExpand = (elementData != EMPTY_ELEMENTDATA)
                ? 0
                : DEFAULT_CAPACITY;
        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        if (minCapacity > elementData.length) {
            grow(minCapacity);
        }
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        if (newCapacity > MAX_ARRAY_SIZE) {
            newCapacity = hugeCapacity(minCapacity);
        }
        this.elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        // overflow
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return 0 == size;
    }

    @Override
    public int indexOf(Object o) {
        if (null == o) {
            for (int i = 0; i < size; i++) {
                if (null == elementData[i]) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        return 0 <= indexOf(o);
    }

    @Override
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);
        System.arraycopy(elementData, index, element, index + 1,
                size - index);
        elementData[index] = element;
        size++;
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("序号越界" + index);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("序号越界" + index);
        }
    }

    E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public E remove(int index) {
        rangeCheckForAdd(index);

        modCount++;
        E oldValue = elementData(index);

        int numMoved = size - index - 1;
        if (0 < numMoved) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (0 < numMoved) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    @Override
    public boolean remove(Object o) {
        if (null == o) {
            for (int index = 0; index < size; index++) {
                if (null == elementData[index]) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        modCount++;
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }

        size = 0;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size + numNew);
        System.arraycopy(a, 0, elementData, size, numNew);
        size += numNew;
        return 0 != numNew;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size + numNew);

        int numRemoved = size - index;
        if (0 < numRemoved) {
            System.arraycopy(elementData, index, elementData, size, numRemoved);
        }
        System.arraycopy(a, 0, elementData, index, numNew);
        size += numNew;
        return 0 != numNew;
    }

    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        int expectedModCount = modCount;
        s.defaultWriteObject();

        s.writeInt(size);

        for (int i = 0; i < size; i++) {
            s.writeObject(elementData[i]);
        }

        if (expectedModCount != modCount) {
            throw new ConcurrentModificationException();
        }
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        elementData = EMPTY_ELEMENTDATA;

        s.defaultReadObject();

        s.readInt();

        if (0 < size) {
            // be like clone(), allocate array based upon size not capacity
            int capacity = calculateCapacity(elementData, size);
            SharedSecrets.getJavaOISAccess().checkArray(s, Object[].class, capacity);
            ensureCapacityInternal(size);

            Object[] a = elementData;
            // Read in all elements in the proper order.
            for (int i = 0; i < size; i++) {
                a[i] = s.readObject();
            }
        }
    }

}
