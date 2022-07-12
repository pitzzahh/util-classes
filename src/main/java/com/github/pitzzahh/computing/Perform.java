package com.github.pitzzahh.computing;

import com.github.pitzzahh.utilities.classes.enums.Operation;

@FunctionalInterface
public interface Perform {

    Number calculate(Operation op) throws IllegalArgumentException;

}
