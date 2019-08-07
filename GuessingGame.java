package com.twister;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner read = new Scanner(System.in);
        int totchan=7;
        int number;
        int guess;
        int chances,score,chanscor;
        char ans;
        do {
            chances = 0;
            number = rand.nextInt(100);
            chanscor=100/totchan;
            do {
                System.out.print("What is your guess? (0 to 100): ");
                guess = read.nextInt();
                if((guess<0)||(guess>100)) {
                    System.out.print("Sorry, but your guess "+guess+"must be from 0 to 100.");
                    break;
                } else if(guess < number) {
                    System.out.println(guess+" is low.Try a higher number.");
                } else if(guess > number) {
                    System.out.println(guess + " is high.Try a lower number.");
                } else if(guess==number) {
                    System.out.println(guess + " is correct. Congratulations!");
                    score=chanscor*(totchan-chances);
                    System.out.println("Your score is " + score);
                    break;
                } else {
                    System.out.println("Enter you number");
                    break;
                }
                chances++;

                if(guess != number)
                    System.out.println("Now you have " + (totchan-chances) + "chances left.");

                if(chances==totchan) {
                    System.out.println("Only " + totchan + "chances are allowed.Better luck next time");
                    System.out.println("The actual number was: " + number);
                    break;
                }
            }while (guess != number);

            System.out.println("Thank you for playing Number Guessing!");
            System.out.print("Want to play it again? (y/n)...");
            ans = read.next().charAt(0);
        }while(ans=='y' || ans=='Y');
    }
}
