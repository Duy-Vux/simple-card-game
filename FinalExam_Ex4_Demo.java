package com.cs1131.assignments;

/** This class executes the methods needed to run the card game. You can create an account,
 * make a bet, and then each game you will be dealt three cards. Same process applied to the dealer.
 * If the total value of your three cards is larger than that of the dealer's, you win and double your bet;
 * else, you lose the bet. You can continue to play as long as you want, until you are out of money.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinalExam_Ex4_Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> used_cards = new ArrayList();

        FinalExam_Ex4 dealer = new FinalExam_Ex4();
        dealer.name = "Mr. Steal Yo Money";
        FinalExam_Ex4 player = new FinalExam_Ex4();

        try {
            player.user_info();
            while (player.isWorking) {
                if (player.accountBalance > 0) {
                    player.place_bet();
                    player.dealCard(used_cards);
                    dealer.dealCard(used_cards);
                    player.compare_score(player.score, dealer.score, player.bet);
                    used_cards.clear();
                    player.player_option(player.initial_accountBalance);
                }
                else {
                    System.out.println("You don't have any money left. Please restart the game!");
                }
            }
        }
        catch(Exception e){
            System.out.println("Your inputs is not in the correct format. Please restart the game!");
        }
    }
}
