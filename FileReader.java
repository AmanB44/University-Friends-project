import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    /**
     * Creates a file reader
     */
    public FileReader() {
    }

    /**
     * @param filename
     * Opens a file, reads it and creates a new Colleague
     * Then it inserts it into a BST
     */
    public static BST readColleagues(String filename) {
        BST binarySearchTree = new BST();

        Scanner in;
        File inputFile = new File(filename);

        try {
            in = new Scanner(inputFile);


            while (in.hasNextLine()) {
                ArrayList<String> interests = new ArrayList<>();

                String line = in.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(";");

                String tag = lineScanner.next();
                String date = lineScanner.next();
                int joinYear = Integer.parseInt(date.substring(0,4));
                int joinMonth = Integer.parseInt(date.substring(5,7));
                int joinDay = Integer.parseInt(date.substring(8,10));

                lineScanner.useDelimiter(",");
                
                while (lineScanner.hasNext()) {
                    String interest = lineScanner.next().trim();
                    interests.add(interest);
                }

                Colleague newColleague = new Colleague(tag, joinYear, joinMonth, joinDay, interests);

                binarySearchTree.insertColleague(newColleague);

            }

            in.close();

        }

        catch (FileNotFoundException e) {
            System.out.println("Could not find " + e.getMessage());
            System.exit(0);
        }

        return binarySearchTree;
    }
}
