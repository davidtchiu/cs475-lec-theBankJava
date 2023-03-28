import java.util.Random;

public class Customer implements Runnable {
   private static Random rand = new Random();
   private String name;
   private TheBank myBank;

   public Customer(String name, TheBank bank) {
      this.name = name;
      myBank = bank;
   }

   /** Runs automatically on thread start */
   @Override
   public void run() {
      while (true) {
         if (name.equals("Adam")) {
           // Adam always deposits $1
           myBank.deposit(1);
         }
         else {
            // Brad and America always withdraws $3
           myBank.withdraw(3);
         }
      }
   }
}
