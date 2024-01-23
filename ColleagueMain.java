import java.util.ArrayList;

public class ColleagueMain {
    public static void main(String[] args) {
        Colleague Colleague1 = new Colleague("Aman", 2003, 03, 9, new ArrayList<String>());
        Colleague Colleague2 = new Colleague("Aman", 2003, 03, 9, new ArrayList<String>());

        System.out.println(Colleague1.toString());
        System.out.println(Colleague1.getUniqueUserName());
        System.out.println(Colleague2.getUniqueUserName());



    }
}
