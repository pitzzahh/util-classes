package com.github.pitzzahh.utilities.misc;

import java.util.stream.IntStream;
import java.util.concurrent.TimeUnit;

public final class Delay {
    /**
     * Cannot instantiate this class.
     */
    private Delay() {}
    /**
     * Method that adds a tailing dot after the {@code String} that is printed.
     * @throws InterruptedException if the thread is interrupted.
     */
    public static void dotLoading() throws InterruptedException {
        IntStream.range(1, 4).forEach(i -> {
            try {
                TimeUnit.MILLISECONDS.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(Decorations.Color.YELLOW.getColor() + '.' + Decorations.Color.RESET.getColor());
        });
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
