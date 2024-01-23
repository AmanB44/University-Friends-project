import java.util.ArrayList;
public class GraphMain {
    public static void main(String[] args) {
        Colleague Colleague1 = new Colleague("tika", 2021, 10, 1, new ArrayList<String>());
        Colleague Colleague2 = new Colleague("litfried", 2003, 03, 9, new ArrayList<String>());
        Colleague Colleague3 = new Colleague("misty", 2003, 04, 9, new ArrayList<String>());
        Colleague Colleague4 = new Colleague("beetle", 2006, 12, 23, new ArrayList<String>());
        Colleague Colleague5 = new Colleague("Aman", 2024, 03, 6, new ArrayList<String>());
        Colleague Colleague6 = new Colleague("blob", 2023, 03, 9, new ArrayList<String>());


//        Colleague1.setInterest("tabletop games");
//        Colleague1.setInterest("photography");
//        Colleague1.setInterest("drum and bass");
//        Colleague1.setInterest("nature");
//
//        Colleague2.setInterest("drum and bass");
//        Colleague2.setInterest("video games");
//        Colleague2.setInterest("cooking");
//
//        Colleague3.setInterest("food");
//        Colleague3.setInterest("cardboard boxes");
//
//        Colleague4.setInterest("walking");
//        Colleague4.setInterest("nature");
//        Colleague4.setInterest("amateur dramatics");
//
//        Colleague5.setInterest("dfs");
//        Colleague5.setInterest("food");
//        Colleague5.setInterest("cooking");
//
//        Colleague6.setInterest("fwdw");
//        Colleague6.setInterest("wfd");
//        Colleague6.setInterest("cooking");

        BST BST1 = new BST();

        BST1.insertColleague(Colleague1);
        BST1.insertColleague(Colleague2);
        BST1.insertColleague(Colleague3);
        BST1.insertColleague(Colleague4);
        BST1.insertColleague(Colleague5);
        BST1.insertColleague(Colleague6);



        Graph graph1 = new Graph("edges.txt", BST1);

        Colleague linkFriend = graph1.findFriend("HAR@misty");
        System.out.println("candidate for link: " + linkFriend);

    }
}
