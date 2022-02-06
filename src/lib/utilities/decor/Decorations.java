package lib.utilities.decor;

import lib.systems.studentManagementSystem.latest.processes.framework.Process;
import lib.systems.studentManagementSystem.latest.main.MainActivity;

public final class Decorations extends Process {
    private Decorations() {
        super();
    }

    /**
     * Inserts a line above and below descriptions.
     * <p> Called in: {@link MainActivity#run() run()}, {@link Process#createStudent() createStudent()},
     * {@link Process#tryAgain() tryAgain()}, {@link Process#showList() showList()}, {@link Process#sortStudentList() sortStudentList()} methods
     */
    public static void line() {
        System.out.println(":---------------------------------------------:");
    }
}
