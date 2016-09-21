import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQMarket {
    //Анонимный класс компаратора
    public static Comparator<Investor> idComparator = new Comparator<Investor>() {
        public int compare(Investor c1, Investor c2) {
            return (int) (c1.getId() - c2.getId());
        }
    };

    // служебный метод добавления элементов в очередь
    private static void addDataToQueue(Queue<Investor> investorPriorityQueue) {
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            int id = rand.nextInt(100);
            investorPriorityQueue.add(new Investor());
        }
    }

    //служебный метод для обработки данных очереди
    private static void pollDataFromQueue(Queue<Investor> investorPriorityQueue) {
        while (true) {
            Investor cust = investorPriorityQueue.poll();
            if (cust == null) break;
            System.out.println("Обработка клиента с id=" + cust.getId());
        }
    }

    public static void main(String[] args) {
        //пример естественного добавления элементов в приоритетную очередь
        Queue<Integer> integerPriorityQueue = new PriorityQueue<>(7);
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            integerPriorityQueue.add(new Integer(rand.nextInt(100)));
        }
        for (int i = 0; i < 7; i++) {
            Integer in = integerPriorityQueue.poll();
            System.out.println("Обрабатываем Integer:" + in);
        }

        //Пример PriorityQueue с компаратором
        Queue<Investor> investorPriorityQueue = new PriorityQueue<>(7, idComparator);
        addDataToQueue(investorPriorityQueue);
        pollDataFromQueue(investorPriorityQueue);
    }

}






