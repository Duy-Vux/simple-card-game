package com.cs1131.assignments;

/** This class provide methods needed to run the game.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FinalExam_Ex4 {
    String name;
    double accountBalance;
    double initial_accountBalance;
    int score;
    double bet;
    int option;
    boolean isWorking = true;
    FinalExam_Ex4_Cards deck = new FinalExam_Ex4_Cards();

    public void user_info(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your username: ");
        name = input.nextLine();
        System.out.println("Enter your account balance: ");
        accountBalance = input.nextDouble();
        initial_accountBalance = accountBalance;

        System.out.println("Your username is: " + name);
        System.out.println("Your account balance is: $" + accountBalance);
        System.out.println();
    }

    public void place_bet(){
        while(true){
            try{
                if(accountBalance == 0){
                    System.out.println("You don't have any money left in your account balance. Restart the game ");
                }
                Scanner input = new Scanner(System.in);
                System.out.println("Place your bet: ");
                bet = input.nextDouble();
                if (bet > accountBalance){
                    System.out.println("You don't have enough money to place this bet. Place a different bet!");
                    System.out.println();
                    continue;
                }
                System.out.println();
                break;
            }
            catch (Exception e){
                System.out.println("Your bet input is not in the right format. Place a different bet!");
                System.out.println();
            }
        }
    }

    public void dealCard(List<Integer> used_cards){
        int number_of_cards = 1;
        score = 0;
        while(number_of_cards <= 3){
            int random = (int)(Math.random()*51)+1;
            if(used_cards.contains(random)){
                continue;
            }
            else{
                switch (number_of_cards){
                    case 1:
                        System.out.println(name + "'s first card is: " + deck.deck_of_cards[random]);
                        break;
                    case 2:
                        System.out.println(name + "'s second card is: " + deck.deck_of_cards[random]);
                        break;
                    case 3:
                        System.out.println(name + "'s third card is: " + deck.deck_of_cards[random]);
                        break;
                }
                used_cards.add(random);
                score += deck.deck_of_cards_values[random];
                number_of_cards += 1;
            }
        }
        System.out.println(name + "'s total score is: " + score);
        System.out.println();
    }

    public void compare_score(int player_score, int dealer_score, double player_bet){
        if (player_score > dealer_score){
            accountBalance += player_bet;
            System.out.println("You win $" + player_bet + "!");
        }
        else if (player_score < dealer_score){
            accountBalance -= player_bet;
            System.out.println("You lose $" + player_bet + "!");
        }
        else{
            System.out.println("It's a draw!");
        }
        System.out.println("Your current account balance is: $" + accountBalance);
        System.out.println();
    }

    public void player_option(double initial_accountBalance){
        Scanner input = new Scanner(System.in);
        initial_accountBalance = this.initial_accountBalance;

        while (true) {
            try {
                System.out.println("Do you want to play more? (1 for Yes. 0 for No): ");
                option = input.nextInt();
                if(option != 0 && option != 1){
                    System.out.println("Invalid input. Please enter only 1 or 0!");
                    System.out.println();
                    continue;
                }
                System.out.println();
                break;
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter only 1 or 0!");
                System.out.println();
            }
        }
        if (option == 0) {
            if (initial_accountBalance > accountBalance) {
                System.out.println("You lose a total of $" + (initial_accountBalance - accountBalance));
                System.out.println("That's too bad:( You'll win it back next time tho!");
            }
            else if (initial_accountBalance < accountBalance) {
                System.out.println("You win a total of $" + (accountBalance - initial_accountBalance));
                System.out.println("Winner Winner, Chicken Dinner!");
            }
            else {
                System.out.println("You managed to not lose a single dime. That's impressive!");
            }
            isWorking = false;
        }
    }
}
