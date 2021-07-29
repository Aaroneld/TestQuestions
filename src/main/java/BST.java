import java.util.Optional;

class BinarySearchTree {
    Node root = null;

    public BinarySearchTree() {}

    public BinarySearchTree(Node root) {
        this.root = root;
    }

    private void addNode(int val, Node node){
        if(val < node.getVal()){
            if(!Optional.ofNullable(node.getLeft()).isPresent()){
                node.setLeft(new Node(val));
            } else {
                addNode(val, node.getLeft());
            }
        } else {
            if(!Optional.ofNullable(node.getRight()).isPresent()){
                node.setRight(new Node(val));
            } else {
                addNode(val, node.getRight());
            }
        }
    }

    public void addNode(int val){
        if(!Optional.ofNullable(root).isPresent()){
            root = new Node(val);
        } else if (val < root.getVal()){

            if(!Optional.ofNullable(root.getLeft()).isPresent()){
                root.setLeft(new Node(val));
            } else {
                addNode(val, root.getLeft());
            }

        } else {
            if(!Optional.ofNullable(root.getRight()).isPresent()){
                root.setRight(new Node(val));
            } else {
                addNode(val, root.getRight());
            }
        }
    }

    public void printInOrderDFT(){
        if(Optional.ofNullable(root.getLeft()).isPresent()){
            printInOrderDFT(root.getLeft());
        }

        System.out.println(root.getVal());

        if(Optional.ofNullable(root.getRight()).isPresent()){
            printInOrderDFT(root.getRight());
        }
    }

    private void printInOrderDFT(Node node){
        if(Optional.ofNullable(node.getLeft()).isPresent()){
            printInOrderDFT(node.getLeft());
        }

        System.out.println(node.getVal());

        if(Optional.ofNullable(node.getRight()).isPresent()){
            printInOrderDFT(node.getRight());
        }
    }
}

class Node {
    int val;
    Node left = null;
    Node right = null;

    public Node(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

public class BST {

    public static void main(String[] args){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.addNode(5);
        binarySearchTree.addNode(3);
        binarySearchTree.addNode(7);
        binarySearchTree.addNode(1);
        binarySearchTree.addNode(2);
        binarySearchTree.printInOrderDFT();
    }

}
