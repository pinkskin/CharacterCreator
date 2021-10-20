package com.pinkskinstudio.charactercreator.logic;

public class Randomizer {

    // INT return a randomized position for adapter. randomized equally among all items
    public static int normalRandomizedPositionInt(int itemCount){
        return (int)(Math.random() * itemCount);
    }
}
