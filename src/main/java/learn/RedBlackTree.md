# 红黑树

## TreeMap 中左旋代码
```java
public class RedBlackTree {

    private void rotateLeft(Map.Entry<K, V> p) {
        if (null != p){
            Entry<K,V> r = p.right;
            p.right = r.left;
            if (null != r.left){
                r.left.patent = p;
            }
            r.parent = p.parent;
            if (null == p.parent){
                root = r;
            }else if (p.parent.left = p){
                p.parent.left = r;
            }else {
                p.parent.right = r;
            }
            r.left = p;
            p.parent = r;
        }
    }
}
```

## TreeMap 中右旋代码
```java
public class RedBlackTree{
    private void rotateRight(Entry<K, V> p){
        if (null != p){
            Entry<K,V> l = p.left;
            p.left = l.right;
            if (null != l.right){
                l.right.parent = p;
            }
            l.parent = p.parent;
            if (null == p.parent){
                root = l;
            }else if (p.parent.right = p){
                l.parent.right = l;
            }else {
                l.parent.left = l;
            }
            l.right = p;
            p.parent = l;
        }
    }
}
```

## TreeMap 中寻找节点后继
```java
public class RedBlackTree{
    static <K,V> TreeMap<K,V> successor(Entre<K,V> t){
        if (null == t){
            return null;
        }else if (null != t.right){
            // 1.当 t 的右子节点不为空时,后继节点为右子树的最小节点
            Entry<K,V> p = t.right;
            while (null != p.left){
                p = p.left;
            }
            return p;
        }else {
            // 2.当 t 的右子节点为空时,后继节点为第一个向左走的祖先
            Entry<K,V> p = t.parent;
            Entry<K,V> ch = t;
            while (null != p && p.right==ch){
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }
}
```