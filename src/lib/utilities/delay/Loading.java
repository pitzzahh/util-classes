package lib.utilities.delay;

import lib.systems.studentManagementSystem.latest.processes.framework.Process;

import java.util.concurrent.TimeUnit;

public final class Loading extends Process {
    // Cannot instantiate this class
    private Loading() {}
    /**
     * Method that adds a tailing dot after the {@code String} that is printed
     * @throws InterruptedException if the thread is interrupted
     */
    public static void dotLoading() throws InterruptedException {
        for (int i = 1; i <= 3; i++) {
            System.out.print('.');
            TimeUnit.MILLISECONDS.sleep(500);
        }
        System.out.println();
    }
    /**
     * Adds a dotLoading when outputting certain output.
     * <p> Called in: {@link Process#showList() showList()} method, called if {@code studentsList.size > 1}
     * @throws InterruptedException if the thread is interrupted
     */
    public static void infoPause() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(80);
    }
}
