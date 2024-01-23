import java.util.ArrayList;
import java.util.Objects;

public class BST {
    private BSTNode root;

    /**
     * Creates a BST
     */
    public BST() {
        this.root = null;
    }

    /**
     * @param c
     * checks if the root is null and inserts the node
     * inserts a colleague into a BST by calling setNode
     */
    public void insertColleague(Colleague c){
        BSTNode newNode = new BSTNode(c);

        if (root == null) {
            root = newNode;
        }
        else {
            setNode(root, newNode);
        }
    }

    /**
     * @param currentNode current node
     * @param newNode     node to be added
     *
     * takes the currentNode and the newNode and recursively calls itself inserting the newNode into place
     */
    private void setNode(BSTNode currentNode, BSTNode newNode){
        if (newNode.getC().getUserName().toLowerCase().compareTo(currentNode.getC().getUserName().toLowerCase()) < 0){
            if (currentNode.getL() == null) {
                currentNode.setL(newNode);
            }

            else {
                setNode(currentNode.getL(), newNode);
            }
        }
        else {
            if (currentNode.getR() == null) {
                currentNode.setR(newNode);
            }

            else {
                setNode(currentNode.getR(), newNode);
            }
        }
    }

    /**
     * @return rightToLeftInorderTraversal()
     * calls rightToLeftInorderTraversal() with the root as the parameter
     */
    public String printReverseAlphabetic() {
        return (rightToLeftInorderTraversal(root));
    }

    /**
     * @param currentNode current node
     * @return uniqueUsername
     * performs a RVL inorder traversal
     */
    public String rightToLeftInorderTraversal(BSTNode currentNode) {
        String uniqueUsername = "";

        if (currentNode.getR() != null) {
            uniqueUsername += rightToLeftInorderTraversal(currentNode.getR());
        }

        uniqueUsername += currentNode.getC().getUniqueUserName() + "\n";

        if (currentNode.getL() != null) {
            uniqueUsername += rightToLeftInorderTraversal(currentNode.getL());
        }

        return uniqueUsername;
    }

    /**
     * @param search username to be searched
     * @return searchTree()
     * checks if the search is equal to the root
     * calls searchTree() with the root as the parameter
     */
    public Colleague searchBST(String search) {
        if (Objects.equals(search, root.getC().getUserName())) {
            return root.getC();
        }
        else {
            return searchTree(root, search);
        }
    }

    /**
     * @param currentNode current node
     * @param search      username to be searched
     * @return Colleague()
     * Searches the tree for a Colleague by its username
     */
    public Colleague searchTree(BSTNode currentNode, String search) {
        if (currentNode == null) {
            return null;
        }

        else if (Objects.equals(currentNode.getC().getUserName(), search)) {
            return currentNode.getC();
        }

        else if (currentNode.getC().getUserName().toLowerCase().compareTo(search.toLowerCase()) > 0) {
            return searchTree(currentNode.getL(), search);
        }

        else {
            return searchTree(currentNode.getR(), search);
        }
    }

    /**
     * @return InorderTraversal()
     * calls InorderTraversal() with the root and an array as the parameters
     */
    public ArrayList<Colleague> printBST() {
        ArrayList<Colleague> colleagues = new ArrayList<>();
        return (InorderTraversal(root, colleagues));
    }

    /**
     * @param currentNode current node
     * @param colleagues  an array of a list of colleagues
     * @return colleagues
     * performs an in order traversal to print the BST
     */
    public ArrayList<Colleague> InorderTraversal(BSTNode currentNode, ArrayList<Colleague> colleagues) {
        if (currentNode.getR() != null) {
            InorderTraversal(currentNode.getR(), colleagues);
        }

        colleagues.add(currentNode.getC());

        if (currentNode.getL() != null) {
            InorderTraversal(currentNode.getL(), colleagues);
        }
        return colleagues;
    }
}
