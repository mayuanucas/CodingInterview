package my.util;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/18
 */
public class LinkedList<E> extends AbstractSequentialList<E>
        implements List<E>, Deque<E>, Cloneable, java.io.Serializable {

    private static final long serialVersionUID = 5925321407958119471L;

    transient int size = 0;

    transient Node<E> first;

    transient Node<E> last;

    public LinkedList() {
    }

    public LinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    @Override
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size-1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


}
