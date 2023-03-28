public class TheBank {
    private int balance = 0;
    private Object notEnough = new Object();  //condition variable

    public void withdraw(int amt) {
        // lock on notEnough C.V.
        synchronized(notEnough) {
          while (balance < amt) {
            try {
               notEnough.wait();  //unlock notEnough and wait (atomically!)
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          balance -= amt;
          System.out.println("Withdrew $" + amt + ". Now $" + balance);
        }
    }

    public void deposit(int amt) {
        // lock on notEnough C.V.
        synchronized(notEnough) {
          balance += amt;
          if (balance > 0)
            notEnough.notifyAll();
          System.out.println("Deposited $" + amt + ". Now $" + balance);
        }
    }
}


// public class TheBank {
   
//     // shared vars
//     private int balance = 0;

//     public synchronized void withdraw(int amt) {
//        while (balance < amt) {
//             try {
//                wait();  //unlock notEnough and wait (atomically!)
//             } catch (InterruptedException e) {
//               e.printStackTrace();
//             }
//        }
//        // I'm out! I can take out money now!
//        balance -= amt;
//        System.out.println("Withdrew $" + amt + ". Now $" + balance);
//     }

//     public synchronized void deposit(int amt) {
//        balance += amt;
//        if (balance > 0) {
//            notifyAll();
//        }
//        System.out.println("Deposited $" + amt + ". Now $" + balance);
//     }
// }