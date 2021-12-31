package com.cs1131.assignments;

/** This class provides a constructor that makes up a deck of cards (suits, ranks, value).**/

import java.util.Arrays;

public class FinalExam_Ex4_Cards {
    private final String [] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
                        "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private final String [] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String [] deck_of_cards = new String[52];
    int [] deck_of_cards_values = new int[52];
    int [] ranks_values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

    public FinalExam_Ex4_Cards(){
        int i = 0;
        int j = 0;
        while (i < 52){
            for (String rank: ranks){
                for (String suit: suits){
                    deck_of_cards[i] = rank + " of " + suit;
                    i++;
                }
            }
        }
        while (j < 52){
            for (int rank_value: ranks_values){
                for (String suit: suits){
                    deck_of_cards_values[j] = rank_value;
                    j++;
                }
            }
        }
    }
}
