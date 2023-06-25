package InterviewCodingQuestions;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Palindromes {

    public static void main(String[] args) {
//        // Find out if a number or a string is a palindrome
//        singlePalindromeApp();
//
//        // Generate a certain number of digits palindrome with highest and lowest
//        generatePalindromeNumberOfNDigits();
//
//        // For a range of numbers see if the number is a palindrome
//        generatePalindromeForRange();

        // For a range of characters find out how many palindromes can  be made
//        generatePalindromesForACharacterSet();
//
//        //Searching for palindromes in a given string
//        searchPalindromesInString();
    }

    public static void generatePalindromeForRange() {
        ArrayList<Integer> palindromesList = new ArrayList<>();
        Scanner scUpper = new Scanner(System.in);
        System.out.println("Upper limit: ");
        int upperLimit = scUpper.nextInt();

        Scanner scLower = new Scanner(System.in);
        System.out.println("Lower limit: ");
        int lowerLimit = scUpper.nextInt();

        for (int i = lowerLimit; i <= upperLimit; i++) {
            if (checkIfTheWordIsPalindrome(String.valueOf(i))) {
                palindromesList.add(i);
            }
        }

        System.out.println("Palindrome for a range of numbers [" + lowerLimit + "-" + upperLimit + "] is "
                + palindromesList.toString());
    }

    private static void generatePalindromeNumberOfNDigits() {
        Scanner scInt = new Scanner(System.in);

//        System.out.println("What digit palindrome you're looking for? ");
//        int noOfDigits = scInt.nextInt();
        int noOfDigits = 3;

        int randomPalindrome = generateARandomNDigitPalindrome(noOfDigits);
        System.out.println("The random palindrome of " + noOfDigits + " digits is " + randomPalindrome);

        int[] largestSmallest = largestAndSmallestPalindromeOfNDigits(noOfDigits);
        System.out.println("Largest Smallest Palindrome of " + noOfDigits +
                "digits is " + largestSmallest[0] + " and " + largestSmallest[1]);
    }

    private static int[] largestAndSmallestPalindromeOfNDigits(int digits) {
        int randomNumber = 0;
        int min = (int) Math.pow(10, digits);
        int max = ((int) Math.pow(10, digits + 1)) - 1;
        int[] largestSmallest = new int[2];

        boolean foundSmallestdPalindrome = false;
        while (!foundSmallestdPalindrome) {
            if (checkIfTheWordIsPalindrome(String.valueOf(min))) {
                foundSmallestdPalindrome = true;
                largestSmallest[0] = min;
                break;
            }
            min++;
        }

        boolean foundLargestPalindrome = false;
        while (!foundLargestPalindrome) {
            if (checkIfTheWordIsPalindrome(String.valueOf(max))) {
                foundLargestPalindrome = true;
                largestSmallest[1] = max;
                break;
            }
            max--;
        }

        return largestSmallest;
    }

    private static int generateARandomNDigitPalindrome(int digits) {
        boolean foundPalindrome = false;
        int randomNumber = 0;
        while (!foundPalindrome) {

            int min = (int) Math.pow(10, digits);
            int max = ((int) Math.pow(10, digits + 1)) - 1;

            Random r = new Random();
            int randomInt = r.nextInt(max - min) + min;
//            System.out.println("Random number generated: " + randomInt);
            if (checkIfTheWordIsPalindrome(String.valueOf(randomInt))) {
                foundPalindrome = true;
                randomNumber = randomInt;
                break;
            }

        }
        return randomNumber;
    }


    public static void singlePalindromeApp() {

        Scanner scInt = new Scanner(System.in);

        System.out.println("Enter a number to check if it is a palindrome:\t");
        int palindromeNumber = scInt.nextInt();

        Scanner scStr = new Scanner(System.in);
        System.out.println("Enter a String to check if it is a palindrome:\t");
        String palindromeString = scStr.nextLine();

        if (checkIfTheNumberIsPalindrome(palindromeNumber)) {
            System.out.println("The number is a palindrome - " + palindromeNumber);
        } else {
            System.out.println("The number is not a palindrome - " + palindromeNumber);
        }
        if (checkIfTheWordIsPalindrome(palindromeString)) {
            System.out.println("The string is a palindrome - " + palindromeString);
        } else {
            System.out.println("The string is not a palindrome - " + palindromeString);
        }
    }

    public static boolean checkIfTheNumberIsPalindrome(int palindromeNumber) {
        boolean palindromeFlag = false;
        int origNumber = palindromeNumber;
        int reverseNumber = 0;
        if (String.valueOf(origNumber).length() > 1) {
            while (origNumber != 0) {
                reverseNumber = reverseNumber * 10 + origNumber % 10;
                origNumber = origNumber / 10;
            }
        } else {
            System.out.println("Are you dense?! It is a single digit number");
        }
        if (palindromeNumber == reverseNumber) {
            palindromeFlag = true;
        }
        return palindromeFlag;
    }


    public static boolean checkIfTheWordIsPalindrome(String palindromeString) {
        boolean palindromeFlag = false;
        String reversedString = "";
        if (palindromeString.length() > 1) {
            for (int i = palindromeString.length() - 1; i >= 0; i--) {
                reversedString = reversedString.concat(palindromeString.charAt(i) + "");
            }
        } else {
            System.out.println("You must be dense to write a single character string!");
        }
        if (reversedString.equalsIgnoreCase(palindromeString)) {
            palindromeFlag = true;
        }
        return palindromeFlag;
    }
}
