package de.tum.in.ase.eist;

public class Main {

    public static void main(String[] args) {
        detectDeadlock(new SwimmingPool());
    }

    public static void detectDeadlock(SwimmingPool swimmingPool) {
        // TODO 2
        Runnable swimmerOne = () -> swimmingPool.handleEntryRequest(new Swimmer(),SwimmingPoolActionOrder.LOCKER_BEFORE_CHANGING_ROOM);
        Runnable swimmerTwo = () -> swimmingPool.handleEntryRequest(new Swimmer(),SwimmingPoolActionOrder.CHANGING_ROOM_BEFORE_LOCKER);

        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(swimmerOne);
            Thread t2 = new Thread(swimmerTwo);

            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
