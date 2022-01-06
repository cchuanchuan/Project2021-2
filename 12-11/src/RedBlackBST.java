
public class RedBlackBST<K extends Comparable<K>, V> {

    private class Node {

        K key;

        V value;

        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;

    private int size;

    public int size(){
        return size;
    }

    public RedBlackBST() {
        root = null;
        size = 0;
    }


    public Iterable<K> keys(){
        if (isEmpty()) return new Queue<K>();
        return keys(min(), max());
    }
    public Iterable<K> keys(K lo, K hi) {
        if (lo == null)
            throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null)
            throw new IllegalArgumentException("second argument to keys() is null");

        Queue<K> queue = new Queue<K>();
        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
        keys(root, queue, lo, hi);
        return queue;
    }

    //    // add the keys between lo and hi in the subtree rooted at x
//    // to the queue
    private void keys(Node node, Queue<K> queue, K lo, K hi) {
        if (node == null) return;
        int cmplo = lo.compareTo(node.key);
        int cmphi = hi.compareTo(node.key);
        if (cmplo < 0) keys(node.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(node.key);
        if (cmphi > 0) keys(node.right, queue, lo, hi);
    }


    public void put(K key, V value) {
        root = put(root, key, value);
    }


    private Node put(Node node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = put(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = put(node.right, key, value);
        } else {
            // key.compareTo(node.key) == 0
            node.value = value;
        }

        return node;
    }

    private Node getNode(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else { // if key.compareTo(node.key) > 0
            return getNode(node.right, key);
        }
    }

    private Node minimum(Node node) {

        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private K min() {
        if (root == null){
            return null;
        }

        return min(root);
    }
    private K min(Node node){
        if (node.left == null) {
            return node.key;
        }
        return min(node.left);
    }

    private K max() {
        if (root == null){
            return null;
        }

        return max(root);
    }
    private K max(Node node){
        if (node.right == null) {
            return node.key;
        }
        return max(node.right);
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }

        return null;
    }

    private Node remove(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {

            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;

        }
    }


    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }


    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " 不存在！");
        }

        node.value = newValue;
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

}