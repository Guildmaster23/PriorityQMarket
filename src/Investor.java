/**
 * Created by 01 on 21.09.2016.
 */
public class Investor {
    private int id;
    static int invesorsCount = 0;

    public Investor() {
        this.id = invesorsCount++;
    }

    public int getId() {
        return id;
    }
}
