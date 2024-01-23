import java.util.ArrayList;

public class Colleague {
    private String tag;
    private int joinYear;
    private int joinMonth;
    private int joinDay;
    private ArrayList<String> interests;
    private final ArrayList<Colleague> friends;
    private static int counter = 100;
    private final int uNN;

    /**
     * Creates a colleague
     *
     * @param tag                  The screen name for the colleague
     * @param joinDay              The year the colleague joined
     * @param joinMonth            The month the colleague joined
     * @param joinYear             The day the colleague joined
     * @param interests            The array of the colleague's interests

     */
    public Colleague(String tag, int joinYear, int joinMonth, int joinDay, ArrayList<String> interests) {
        this.tag = tag;
        this.joinYear = joinYear;
        this.joinMonth = joinMonth;
        this.joinDay = joinDay;
        this.interests = interests;
        this.friends = new ArrayList<>();
        uNN = counter++;
    }

    /**
     *  @return tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag
     * Sets the tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     *  @return joinYear
     */
    public int getJoinYear() {
        return joinYear;
    }

    /**
     * @param joinYear Sets the joinYear
     */
    public void setJoinYear(int joinYear) {
        this.joinYear = joinYear;
    }

    /**
     *  @return joinMonth
     */
    public int getJoinMonth() {
        return joinMonth;
    }

    /**
     * @param joinMonth Sets the joinMonth
     */
    public void setJoinMonth(int joinMonth) {
        this.joinMonth = joinMonth;
    }

    /**
     *  @return joinDay
     */
    public int getJoinDay() {
        return joinDay;
    }

    /**
     * @param joinDay Sets the joinDay
     */
    public void setJoinDay(int joinDay) {
        this.joinDay = joinDay;
    }

    /**
     *  @return interests
     */
    public ArrayList<String> getInterests() {
        return interests;
    }

    /**
     * @param interest Sets interests
     */
    public void setInterests(ArrayList<String> interest) {
        this.interests = interest;
    }

    /**
     *  @return date in YYYY-MM-DD format
     */
    public String getDateJoined(){
        return (this.joinYear + "-" + this.joinMonth + "-" + this.joinDay);
    }

    /**
     *  @return username or null if tag is null
     */
    public String getUserName(){
        if (this.tag == null){
            return null;
        }

        else {
            return ("HAR@" + this.tag);
        }
    }

    /**
     *  @return unique username
     */
    public String getUniqueUserName(){
        return getUserName() + "#" + uNN;
    }

    /**
     * @param c adds a colleague to another friend list
     */
    public void befriend(Colleague c){
        friends.add(c);
    }

    /**
     * @param c Colleague
     * @return true if they are already friends
     * returns false if they are not friends yet
     */
    public boolean isFriendsWith(Colleague c){
        for (Colleague friend : friends) {
            if (friend == c) {
                return true;
            }
        }
        return false;
    }

    /**
     *  @return number of friends
     */
    public int numFriends(){
        return friends.size();
    }

    /**
     *  @return Colleague info
     */
    @Override
    public String toString() {
        return "Colleague{" +
                "tag=" + tag +
                ", joinYear=" + joinYear +
                ", joinMonth=" + joinMonth +
                ", joinDay=" + joinDay +
                ", interest=" + interests +
                '}';
    }
}
