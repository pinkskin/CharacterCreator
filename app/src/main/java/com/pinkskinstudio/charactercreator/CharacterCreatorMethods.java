package com.pinkskinstudio.charactercreator;

public class CharacterCreatorMethods {

    // Provide a random int roll
    private static int randomRoll(int diceCount, int diceType) {
        int randomResult = 0;
        for (int x=0; x<diceCount; x++) {
            randomResult += (int)(Math.random() * diceType) + 1;
        }
        return randomResult;
    }
}
