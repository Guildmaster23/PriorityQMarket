import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQMarket {

    private Queue<Investor> buyQueue;
    private Queue<Investor> sellQueue;

    // Anonimous comparator classes
    public static Comparator<Investor> priceComparatorAsc = new Comparator<Investor>() {
        public int compare(Investor c1, Investor c2) {
            return (int) (c1.portfolio.getPrice() - c2.portfolio.getPrice());
        }
    };

    public static Comparator<Investor> priceComparatorDesc = new Comparator<Investor>() {
        public int compare(Investor c1, Investor c2) {
            return (int) (c2.portfolio.getPrice() - c1.portfolio.getPrice());
        }
    };

    public static void main(String[] args) {
        PriorityQMarket simulation = new PriorityQMarket();
        simulation.simulate();
    }

    public void simulate() {

        // set Queues' sizes
        int buyQueueSize = 7;
        int sellQueueSize = 7;

        generateBuyQueue(buyQueueSize);
        generateSellQueue(sellQueueSize);
        conductTransactions();

        // PriorityQueue with comparator
        Queue<Investor> investorPriorityQueue = new PriorityQueue<>(7, priceComparatorAsc);
    }

    public void generateBuyQueue(int buyQueueSize) {

        // debug
        System.out.println("Generate buyers: ");

        buyQueue = new PriorityQueue<>(buyQueueSize, priceComparatorDesc);

        for (int i = 0; i < buyQueueSize; i++) {
            buyQueue.add(new Investor());
        }
    }

    public void generateSellQueue(int sellQueueSize) {

        // debug
        System.out.println("Generate sellers: ");

        sellQueue = new PriorityQueue<>(sellQueueSize, priceComparatorAsc);

        for (int i = 0; i < sellQueueSize; i++) {
            sellQueue.add(new Investor());
        }
    }

    public void conductTransactions() {
        while (!buyQueue.isEmpty() || !sellQueue.isEmpty()) {
            Investor buyer = buyQueue.peek();
            Investor seller = sellQueue.peek();
            if (seller.portfolio.getPrice() > buyer.portfolio.getPrice()) {
                System.out.println("Nothing else to trade. Exit.");
                return;
            } else {
                int diffInQuantity = seller.portfolio.getCount() - buyer.portfolio.getCount();

                System.out.println("Sold from investor " + seller.getId() + " to investor "
                        + buyer.getId() + " : "
                        + ((diffInQuantity < 0) ? seller.portfolio.getCount() : buyer.portfolio.getCount())
                        + " shares at price " + seller.portfolio.getPrice() + "$ each");

                buyQueue.poll();
                sellQueue.poll();

                if (diffInQuantity < 0) {
                    buyer.portfolio.setCount(Math.abs(diffInQuantity));
                    buyQueue.add(buyer);
                } else if (diffInQuantity > 0) {
                    seller.portfolio.setCount(Math.abs(diffInQuantity));
                    sellQueue.add(seller);
                }
            }
        }
    }
}






