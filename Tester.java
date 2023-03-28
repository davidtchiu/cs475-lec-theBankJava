public class Tester {
  private static final int NUM_THREADS = 3;
  private static final String[] cust_names = {"Adam", "Brad", "America"};
  public static void main(String[] args) {
    TheBank syncedBank = new TheBank();

    // 3 customers
    Thread[] customers = new Thread[NUM_THREADS];

    // start the threads
    for (int i = 0; i < NUM_THREADS; i++) {
      customers[i] = new Thread(new Customer(cust_names[i], syncedBank));
      customers[i].start();
    }

    //join the customer threads
    for (int i = 0; i < NUM_THREADS; i++) {
      try {
       customers[i].join();
      }
      catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Done!");
  }
}