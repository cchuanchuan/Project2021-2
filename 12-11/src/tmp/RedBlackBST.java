//package tmp;
//
//import java.util.NoSuchElementException;
//
//public class RedBlackBST<Key extends Comparable<Key>, Value> {
//    private static final boolean RED = true;
//    private static final boolean BLACK = false;
//
//    private Node root; // root of the BST
//
//    // BST helper node data type
//    private class Node{
//        private Key key; 			// key
//        private Value value;		// associated data
//        private Node left, right; 	//links to left and right subtree
//        private boolean color; 		// color of parent link
//        private int size; 			// subtree count
//
//        public Node(Key key, Value value, boolean color, int size) {
//            this.key = key;
//            this.value = value;
//            this.color = color;
//            this.size = size;
//        }
//    }
//
//    // initialize the empty tree
//    public RedBlackBST() {
//
//    }
//
//    /*
//     * Node helper methods
//     */
//
//    // is the node red? false if the node is null.
//    private boolean isRed(Node node) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // number of node is subtree rooted at node;
//    // 0 if node is null
//    private int size(Node node) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // returns the number of key-value pairs in the tree
//    public int size() {
//        return size(root);
//    }
//
//    // is the tree empty?
//    public boolean isEmpty() {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    /*
//     * Standard BST search
//     */
//
//    // returns the value associated with the given key.
//    public Value get(Key key) {
//        if(key == null)
//            throw new IllegalArgumentException("Key cannot be null.");
//        return get(root, key);
//    }
//
//    // Value associated with the given key in subtree rooted
//    // at node; null if no such key
//    private Value get(Node node, Key key) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // Does this tree contains the given key?
//    public boolean contains(Key key) {
//        return get(key) != null;
//    }
//
//    /*
//     * Red-Black tree insertion
//     */
//
//    // Inserts the specified key-value pair into the tree.
//    // overwrites the old value with the new value if the tree
//    // already contains the key.
//    // Deletes the specified key from the tree if the value is null.
//
//    public void put(Key key, Value value) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // insert the key-value pair in the subtree rooted at node
//
//    private Node put(Node node, Key key, Value value) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    /*
//     * Red-Black tree deletion
//     */
//
//    // Removes the smallest key and associated value from the tree
//    public void deleteMin() {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // delete the key-value pair with the minimum key rooted at node
//    private Node deleteMin(Node node) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // Removes the largest key and value associated from the tree.
//    public void deleteMax() {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // delete the key-value pair with the maximum key rooted at node
//    private Node deleteMax(Node node) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // Removes the specified key and its associated value from the tree
//    public void delete(Key key) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // delete the key-value pair with the given key rooted at node
//    private Node delete(Node node, Key key) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    /*
//     * Red-Black Tree helper functions
//     */
//
//    // make a left-leaning link lean to the right
//    private Node rotateRight(Node node) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // make a right-leaning link lean to the left
//    private Node rotateLeft(Node node) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // flip the colors of a node and its two children
//    private void flipColors(Node node) {
//        // Node must have opposite color of its two children
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // Assuming that node is red and both node.left and node.left.left
//    // are black, make node.left or one of its children red.
//    private Node moveRedLeft(Node node) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // Assuming that node is red and both node.right and node.right.left
//    // are black, make node.right or one of its children red.
//    private Node moveRedRight(Node node) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // restore red-black tree invariant
//    private Node balance(Node node) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    /*
//     * Utility functions
//     */
//    // Returns the height of the BST
//    public int height() {
//        return height(root);
//    }
//
//    private int height(Node node) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    /*
//     * Ordered tree methods
//     */
//
//    // Returns the smallest key
//    public Key min() {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    private Node min(Node node) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // Returns the largest key
//    public Key max() {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    private Node max(Node node) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    //	// Returns all the keys in the tree as an iterable
//    public Iterable<Key> keys(){
//        if (isEmpty()) return new Queue<Key>();
//        return keys(min(), max());
//    }
//    public Iterable<Key> keys(Key lo, Key hi) {
//        if (lo == null)
//            throw new IllegalArgumentException("first argument to keys() is null");
//        if (hi == null)
//            throw new IllegalArgumentException("second argument to keys() is null");
//
//        Queue<Key> queue = new Queue<Key>();
//        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
//        keys(root, queue, lo, hi);
//        return queue;
//    }
//
//    //    // add the keys between lo and hi in the subtree rooted at x
////    // to the queue
//    private void keys(Node node, Queue<Key> queue, Key lo, Key hi) {
//        if (node == null) return;
//        int cmplo = lo.compareTo(node.key);
//        int cmphi = hi.compareTo(node.key);
//        if (cmplo < 0) keys(node.left, queue, lo, hi);
//        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(node.key);
//        if (cmphi > 0) keys(node.right, queue, lo, hi);
//    }
//
//    /*
//     * Check integrity of red-black tree
//     */
//
//    private boolean check() {
//        if(!isBST())
//            System.out.println("Not a valid BST.");
//        if(!isBalanced())
//            System.out.println("Not balanced.");
//
//        return isBST() && isBalanced();
//    }
//
//    // do all paths from root to leaf have same number of black edges?
//    private boolean isBalanced() {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//    // does every path from the root to a leaf have the given number of black links?
//    private boolean isBalanced(Node node, int black) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//    // does this binary tree satisfy symmetric order?
//    private boolean isBST() {
//        return isBST(root, null, null);
//    }
//
//
//    // is the tree rooted at node a BST with all keys strictly
//    // between min and max
//    private boolean isBST(Node node, Key min, Key max) {
//        throw new UnsupportedOperationException("Method not implemented yet.");
//    }
//
//}
