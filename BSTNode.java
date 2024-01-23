public class BSTNode {
    private Colleague c;
    private BSTNode l;
    private BSTNode r;

    /**
     * Creates a BSTNode
     *
     * @param elem                 A reference to a Colleague
     */
    public BSTNode(Colleague elem) {
        this.c = elem;
        this.l = null;
        this.r = null;
    }

    /**
     *  @return the Colleague
     */
    public Colleague getC() {
        return this.c;
    }

    /**
     * @param l Sets the left node
     */
    public void setL(BSTNode l) {
        this.l = l;
    }

    /**
     * @param r Sets the right node
     */
    public void setR(BSTNode r) {
        this.r = r;
    }

    /**
     *  @return the left node
     */
    public BSTNode getL() {
        return this.l;
    }

    /**
     *  @return the right node
     */
    public BSTNode getR() {
        return this.r;
    }
}
