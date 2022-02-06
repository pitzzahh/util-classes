package lib.games.rockPaperScissors.objectOriented;

import java.util.Random;
import java.util.Scanner;

public final class RockPaperScissors {
    public void run() {
        Game.human = new Human();
        Game.computer = new Computer();
        Game.scanner = new Scanner(System.in);
        Game.startTheGameFellas();
    }
}
final class Computer extends Player {

    private final Random computerChoice;

    public Computer() {
        setPlayerName("COMPUTER");
        computerChoice = new Random();
    }
    @Override
    public void selectChoice() {
        int randomNumber = computerChoice.nextInt(3)+1;
        switch (randomNumber) {
            case 1 -> setPlayerChoice("ROCK");
            case 2 -> setPlayerChoice("PAPER");
            case 3 -> setPlayerChoice("SCISSORS");
        }
    }
}
class Human extends Player{
    private final Scanner humanInput;
    public Human() {
        humanInput = new Scanner(System.in);
    }
    @Override
    public void selectChoice() {

        char selection = ' ';
        String humanChoice = "";
        boolean okay = true;

        while(okay) {
            System.out.println("\"R\" for ROCK, \"P\" for PAPER, \"S\" for SCISSORS");
            System.out.print("Enter yours: ");
            // solving
            selection = humanInput.next().toUpperCase().charAt(0);
		    if(selection == 'R' || selection == 'P' || selection == 'S') {
			    okay = false;
		    }
		    else {
			    System.out.println(":--------------------------------:");
			    System.out.println(":      CHOOSE ONLY: R, P, S      :");
			    System.out.println(":--------------------------------:");
		    }
		}
        // solving
        switch(selection) {
            case 'R' -> humanChoice = "ROCK";
            case 'P' -> humanChoice = "PAPER";
            case 'S' -> humanChoice = "SCISSORS";
        }
        setPlayerChoice(humanChoice);
    }
}
abstract class Player {
    private String name;
    private String choice;

    // getters
    public String getPlayerName() {
        return name;
    }
    public String getPlayerChoice() {
        return choice;
    }
    // setters
    public void setPlayerName(String name) {
        this.name = name;
    }
    public void setPlayerChoice(String choice) {
        this.choice = choice;
    }
    public abstract void selectChoice();
}