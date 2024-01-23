import java.util.ArrayList;

public class BSTNodeMain {
    public static void main(String[] args) {
        Colleague Colleague1 = new Colleague("Aman", 2003, 03, 9, new ArrayList<String>());

        BSTNode node1 = new BSTNode(Colleague1);

        node1.setL(node1);
        System.out.println(node1.getL());

    }
}
