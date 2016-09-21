import java.util.Random;

/**
 * Created by 01 on 21.09.2016.
 */
public class Investor {

    private static int invesorsCount = 0;

    public Assets portfolio;

    private int id;
    private Random r = new Random();

    public Investor() {
        this.id = invesorsCount++;

        // debug
        System.out.println("Generated Investor " + this.id + "with assets");
    }

    public int getId() {
        return id;
    }

    public void inheritFortune() {
        portfolio = new Assets(r.nextInt(100), r.nextInt(100));

        // debug
        System.out.println("Stock portfolio now is: " + portfolio.getCount() + " at " + portfolio.getPrice());
    }
}
