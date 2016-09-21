/**
 * Created by alex on 21/09/16.
 */
public class Assets {
    private int count;
    private int price;

    public Assets(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
