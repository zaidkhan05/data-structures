import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;
////////////////////////////////////////////////////////////////////////////////////////
class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;
    public TreeNode(E e) {
        element = e;
    }
}
////////////////////////////////////////////////////////////////////////////////////////
interface Tree<E> extends Iterable<E>{
    public boolean search(E e);
    public boolean insert(E e);
    public boolean delete(E e);
    public void inorder();
    public void postorder();
    public void preorder();
    public int getSize();
    public boolean isEmpty();
}
////////////////////////////////////////////////////////////////////////////////////////
abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public void inorder() {
    }
    @Override
    public void postorder() {
    }
    @Override
    public void preorder() {
    }
    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }
}
////////////////////////////////////////////////////////////////////////////////////////
class BST<E extends Comparable<E>> extends AbstractTree<E>{
    protected TreeNode<E> root;
    protected int size = 0;
    public BST() {
    }
    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }
    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                return true;
        }
        return false;
    }
    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }
        size++;
        return true;
    }
    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }
    @Override
    public void inorder() {
        inorder(root);
    }
    protected void inorder(TreeNode<E> root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }
    @Override
    public void postorder() {
        postorder(root);
    }
    protected void postorder(TreeNode<E> root) {
        if (root == null)
            return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }
    @Override
    public void preorder() {
        preorder(root);
    }
    protected void preorder(TreeNode<E> root) {
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }
    public static class TreeNode<E extends Comparable<E>>{
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;
        public TreeNode(E e) {
            element = e;
        }
    }
    @Override
    public int getSize() {
        return size;
    }
    public TreeNode<E> getRoot() {
        return root;
    }
    public ArrayList<TreeNode<E>> path(E e) {
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> current = root;
        while (current != null) {
            list.add(current);
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else
                break;
        }
        return list;
    }
    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                break;
        }
        if (current == null)
            return false;
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else {
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            current.element = rightMost.element;
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                parentOfRightMost.left = rightMost.left;
        }
        size--;
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new InorderIterator();
    }

    private class InorderIterator implements Iterator<E> {
        private ArrayList<E> list = new ArrayList<>();
        private int current = 0;
        public InorderIterator() {
            inorder();
        }
        private void inorder() {
            inorder(root);
        }
        private void inorder(TreeNode<E> root) {
            if (root == null)
                return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }
        @Override
        public boolean hasNext() {
            if (current < list.size())
                return true;
            return false;
        }
        @Override
        public E next() {
            return list.get(current++);
        }
        @Override
        public void remove() {
            delete(list.get(current));
            list.clear();
            inorder();
        }
    }
    public void clear() {
        root = null;
        size = 0;
    }
    int depth(TreeNode<E> root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
    }
    int max(TreeNode<E> root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max((int) root.element, Math.max(max(root.left), max(root.right)));
        }
    }
    int tree_sum(TreeNode<E> root) {
        if (root == null) {
            return 0;
        } else {
            return ((Integer) root.element) + tree_sum(root.left) + tree_sum(root.right);
        }
    }
    int tree_average(TreeNode<E> root) {
        if (root == null) {
            return 0;
        } else {
            return (tree_sum(root) / getSize());
        }
    }
    boolean tree_is_balanced(TreeNode<E> root) {
        if (root == null) {
            return true;
        } else {
            if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
                return false;
            } else {
                return tree_is_balanced(root.left) && tree_is_balanced(root.right);
            }
        }
    }
    boolean isBST(TreeNode<E> root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean isBST(TreeNode<E> root, int min, int max) {
        if (root == null) {
            return true;
        }
        if ((Integer) root.element < min || (Integer) root.element > max) {
            return false;
        }
        return isBST(root.left, min, (Integer) root.element - 1) && isBST(root.right, (Integer) root.element + 1, max);
    }
}
////////////////////////////////////////////////////////////////////////////////////////




public class Assignment8 {

    public static void main(String[] args) {
        //e
        int pre[] = {2, 1, 3};    // pre-order
        int in[]  = {1, 2, 3};     // in-order

    // 3 parameter means - 3 items in pre-order and 3 items in in-order
        BST<Integer> tree = new BST<>();
        System.out.println("Tree e");
        System.out.println("Binary search tree ? " + tree.isBST(tree.getRoot()));
        System.out.println("Depth: " + tree.depth(tree.getRoot()));
        System.out.println("Max: " + tree.max(tree.getRoot()));
        System.out.println("Sum: " + tree.tree_sum(tree.getRoot()));
        System.out.println("Average: " + tree.tree_average(tree.getRoot()));
        System.out.println("Is Balanced ? " + tree.tree_is_balanced(tree.getRoot()));
        System.out.println();
        //f

        

        
    }
}

/*
Objective of this assignment is to reinforce understanding of Binary Trees and recursion.
Write a program to implement Binary Trees. You use the Node class from the Java Library, or write
your own Binary Tree Class, and implement the methods listed below. Hint, review section 25.2
(starts on p. 930) in the text for designing and implenting binary trees using linked lists.
Data is provided for this assignment. The data is in the form of sample tree arrays, listed in the
additional data file that is attached to the Assignment as a file called A8-BT-testdata.txt.
You are NOT going to read this data from the file into your program !
You will hard code the test data that is provided in A8-BT-testdata.txt, i.e., copy and paste the data.
In addition, note that the sample trees use pre order and in order traversals, as indicated by the
sample data array names. For example, the array named, double pre[ ] is data used for pre-order
traversal, and the array named double in[ ] is for in-order traversal. After the insertion of data for each
tree, you must determine whether the tree is a binary search tree or not, and provide that information
in your test results.
HINT: Create one tree at a time, using the data provided for that tree, execute the methods on that
tree, write the results to the screen, and get a screenshot of each output.
METHODS
1. depth
if root is NULL, return -1
otherwise, determine maximum of the depths of the left and right subtrees, add 1 and return
2. max
test that root is not NULL
get the max in the left subtree, the max in the right subtree, and the data value in root
 return the largest of these three values
ignore a subtree if it is empty
3. tree_sum
returns the sum of the values in all the nodes in the tree
4. tree_average
returns the average of the values in all the nodes in the tree
5. tree_is_balanced
returns true if and only if the tree is balanced
this means that the absolute value of the difference in depth between the
two subtrees of root is no more than 1.
it also means that both the left and the right subtree are balanced.
An empty tree is considered to be balanced.
if root is empty, the tree is balanced
otherwise, if either the right or the left subtree is not balanced,
then the tree is not balanced
otherwise, if the difference in depths between the left and right subtrees
is greater than one then the tree is not balanced
otherwise, the tree is balanced
TEST: To test the above methods, create 6 trees, one at a time, using the sample data and
write your results in the listed form shown below
Tree_Name
Binary search tree ? Yes or no // indicate whether the tree is a BST
Depth
Max
Sum
Average
Is Balanced ? 
 */