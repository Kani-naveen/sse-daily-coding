
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo {

    private static final Object accountA = new Object();
    private static final Object accountB = new Object();

    private static final ReentrantLock lockA = new ReentrantLock();
    private static final ReentrantLock lockB = new ReentrantLock();

    private static final long ACCOUNT_A_ID = 1;
    private static final long ACCOUNT_B_ID = 2;

    public static void main(String[] args) throws InterruptedException {

        boolean demonstrateDeadlock = false;

        if (demonstrateDeadlock) {
            demonstrateDeadlock();
        } else {
            demonstrateFixedVersion();
        }
    }

    // ---------------- DEADLOCK REPRODUCTION ----------------

    private static void demonstrateDeadlock() throws InterruptedException {

        System.out.println("Starting deadlock reproduction...");

        Thread t1 = new Thread(() -> {
            synchronized (accountA) {
                System.out.println("Thread 1 acquired Account A");

                sleep(100);

                synchronized (accountB) {
                    System.out.println("A to B transfer");
                }
            }
        }, "Transfer-A-to-B");

        Thread t2 = new Thread(() -> {
            synchronized (accountB) {
                System.out.println("Thread 2 acquired Account B");

                sleep(100);

                synchronized (accountA) {
                    System.out.println("B to A transfer");
                }
            }
        }, "Transfer-B-to-A");

        t1.start();
        t2.start();

        // Give both threads time to enter the deadlock.
        Thread.sleep(1000);

        System.out.println("\nThread states:");
        System.out.println(t1.getName() + ": " + t1.getState());
        System.out.println(t2.getName() + ": " + t2.getState());

        System.out.println("\nDeadlock detected if both threads are BLOCKED.");
        System.out.println("The program will remain stuck until terminated.");
    }

    // ---------------- DEADLOCK FIX ----------------

    private static void demonstrateFixedVersion() throws InterruptedException {

        System.out.println("Starting fixed version...");

        Thread t1 = new Thread(() ->
                transferWithOrderedLocks(
                        ACCOUNT_A_ID,
                        ACCOUNT_B_ID,
                        "A to B"
                ),
                "Transfer-A-to-B"
        );

        Thread t2 = new Thread(() ->
                transferWithOrderedLocks(
                        ACCOUNT_B_ID,
                        ACCOUNT_A_ID,
                        "B to A"
                ),
                "Transfer-B-to-A"
        );

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\nBoth transfers completed.");
    }

    private static void transferWithOrderedLocks(
            long fromId,
            long toId,
            String description) {

        Lock firstLock;
        Lock secondLock;

        // Always acquire locks in ascending account ID order.
        if (fromId < toId) {
            firstLock = lockA;
            secondLock = lockB;
        } else {
            firstLock = lockB;
            secondLock = lockA;
        }

        firstLock.lock();

        try {
            secondLock.lock();

            try {
                System.out.println(
                        description + " transfer completed by "
                                + Thread.currentThread().getName()
                );
            } finally {
                secondLock.unlock();
            }

        } finally {
            firstLock.unlock();
        }
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
