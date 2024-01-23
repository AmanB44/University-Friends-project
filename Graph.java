import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    private BST tree;

    /**
     * Reads a file and creates friendships
     *
     * @param edgeListFileName                The name of a file containing an edge list
     * @param tree                            A reference to a BST
     */
    public Graph(String edgeListFileName, BST tree) {
        this.tree = tree;

        Scanner in = null;
        File inputFile = new File(edgeListFileName);

        try {
            in = new Scanner(inputFile);

            while (in.hasNextLine()) {

                String line = in.nextLine();
                Scanner lineScanner = new Scanner(line);

                lineScanner.useDelimiter(",");

                String c1 = lineScanner.next();
                String c2 = lineScanner.next();

                if (!(tree.searchBST(c1) == null || tree.searchBST(c2) == null)) {
                    Colleague colleague1 = tree.searchBST(c1);
                    Colleague colleague2 = tree.searchBST(c2);

                    if (!(colleague1.isFriendsWith(colleague2))) {
                        colleague1.befriend(colleague2);
                        colleague2.befriend(colleague1);

                    }
                }
            }
            in.close();

        }

        catch (FileNotFoundException e) {
            System.out.println("Could not find " + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * @param userName username of the Colleague to be found
     * @return Colleague
     * finds a friend for userName
     */
    public Colleague findFriend(String userName) {
        int leastNumberOfFriends = 1000;
        Colleague mostRecentColleague = new Colleague(null, 0, 00, 00, null);
        Colleague suggestedFriend = null;
        Colleague lonelyColleague = tree.searchBST(userName);
        ArrayList<Colleague> colleagues = tree.printBST();
        colleagues.remove(lonelyColleague);
        ArrayList<String> lonelyColleagueInterests = lonelyColleague.getInterests();
        ArrayList<Colleague> leastFriends = new ArrayList<>();
        int min = colleagues.get(0).numFriends();

        for (int i = 0; i < colleagues.size() - 1; i++) {

            if (colleagues.get(i).getJoinYear() > mostRecentColleague.getJoinYear()) {
                mostRecentColleague = colleagues.get(i);
            }

            else if (colleagues.get(i).getJoinYear() == mostRecentColleague.getJoinYear()) {
                if (colleagues.get(i).getJoinMonth() > mostRecentColleague.getJoinMonth()) {
                    mostRecentColleague = colleagues.get(i);
                }

                else if (colleagues.get(i).getJoinMonth() == mostRecentColleague.getJoinMonth()) {
                    if (colleagues.get(i).getJoinDay() > mostRecentColleague.getJoinDay()) {
                        mostRecentColleague = colleagues.get(i);
                    }
                }
            }
        }

        for (Colleague colleague : colleagues) {
            if (colleague.numFriends() < min) {
                leastFriends.clear();
                leastFriends.add(colleague);
                min = colleague.numFriends();
            }

            else if (colleague.numFriends() == min) {
                leastFriends.add(colleague);
            }
        }

        for (int i = 0; i < colleagues.size(); i++) {
            if (colleagues.get(i).isFriendsWith(lonelyColleague)) {
                return suggestedFriend;
            }

            else {
                ArrayList<String> interests = colleagues.get(i).getInterests();
                for (String interest : interests) {
                    for (String lonelyColleagueInterest : lonelyColleagueInterests) {
                        if (interest.equals(lonelyColleagueInterest)) {
                            if (mostRecentColleague == colleagues.get(i)) {
                                for (int l = 0; l < leastFriends.size(); l++) {
                                    if (leastFriends.get(i) == colleagues.get(i)) {
                                        suggestedFriend = colleagues.get(i);
                                        return suggestedFriend;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
            return suggestedFriend;
    }

}






