package lib.utilities.misc;

import lib.systems.studentManagementSystem.processes.framework.Process;
import java.util.concurrent.TimeUnit;

public final class Delay extends Process {
    /**
     * Cannot instantiate this class.
     */
    private Delay() {}
    /**
     * Method that adds a tailing dot after the {@code String} that is printed.
     * @throws InterruptedException if the thread is interrupted.
     */
    public static void dotLoading(String delay) throws InterruptedException {
        switch (delay) {
            case "long" -> {
                for (int i = 1; i <= 3; i++) {
                    TimeUnit.MILLISECONDS.sleep(700);
                    System.out.print(Decorations.TEXT_YELLOW + '.' + Decorations.TEXT_RESET);
                }
            }
            case "short" -> {
                for (int i = 1; i <= 3; i++) {
                    TimeUnit.MILLISECONDS.sleep(400);
                    System.out.print(Decorations.TEXT_YELLOW + '.' + Decorations.TEXT_RESET);
                }
            }
        }
        System.out.println();
    }
    /**
     * Adds a dotLoading when outputting certain output.
     * <p> Called in: {@link Process#showList() showList()} method, called if {@code studentsList.size > 1}.
     * @throws InterruptedException if the thread is interrupted.
     */
    public static void pause() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(80);
    }
}
