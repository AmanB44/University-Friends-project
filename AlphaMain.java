import java.util.ArrayList;

public class AlphaMain {
    public static void main(String[] args) {
        Colleague Colleague1 = new Colleague("litfried ", 2003, 03, 9, new ArrayList<String>());
        Colleague Colleague2 = new Colleague("tika", 2003, 03, 9, new ArrayList<String>());
        Colleague Colleague3 = new Colleague("LynConway", 2003, 03, 9, new ArrayList<String>());

        BST BST1 = new BST();

        BST1.insertColleague(Colleague1);
        BST1.insertColleague(Colleague2);
        BST1.insertColleague(Colleague3);

        BST1.printReverseAlphabetic();


    }
}
