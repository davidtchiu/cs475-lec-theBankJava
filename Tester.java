public class Tester {

  private static final String[] cust_names = { "Adam", "Brad", "America" };

  public static void main(String[] args) {
    TheBank syncedBank = new TheBank();

    // start the threads
    Thread[] customers = new Thread[cust_name.length];
    for (int i = 0; i < cust_name.length; i++) {
      customers[i] = new Thread(new Customer(cust_names[i], syncedBank));
      customers[i].start();
    }

    // join the customer threads
    for (int i = 0; i < cust_name.length; i++) {
      try {
        customers[i].join();
      } catch (InterruptedException e) {
      }
    }
    System.out.println("Done!");
  }
}