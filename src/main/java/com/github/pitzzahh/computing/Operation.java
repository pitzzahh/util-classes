package com.github.pitzzahh.computing;

@FunctionalInterface
public interface Operation {

    Number calculate(int operation) throws IllegalArgumentException;

     int MULTIPLY = 1;
     int DIVIDE = 2;
     int ADD = 3;
     int SUBTRACT = 4;
     int MODULO = 5;
}
