/** 
@author Hayden Knox
@author Connor Dobson
@author Ariana van Lith
*/

import java.util.Scanner;

/*
 * The Cards class calculates the binomial coefficient value of 2 numbers from the input file piped through the terminal
 * The program converts the numbers found the in the piped file and parses them to long data types then calculates the binomial coefficient and returns the value.
 */

public class Cards {
    /**
     * The main method manages user input and output
     */
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) { // creates new instance of Scanner class
            while (input.hasNextLine()) { // read every line of input
                String userInput = input.nextLine(); // read current line of input
                String[] numbers = userInput.split(" "); // split the line by space
                if (numbers.length != 2) { // check if numbers array contains 2 values
                    System.out.println("Please input 2 numbers per line, skipping to next line of input"); // if not than output message to user
                    continue; // skip to next line
                }
                try { // try the following
                    long number1 = Long.parseLong(numbers[0]); // store first value
                    long number2 = Long.parseLong(numbers[1]); // store second value
                    System.out.println(binomialCoefficient(number1, number2)); // print out the result from the binomialCoefficient() function
                } catch (NumberFormatException e) { // if Exception is caught
                    System.out.println("Could not parse " + userInput + ", skipping to next line of input"); // print out message
                    continue; // skip to next line
                }
            }
        }
    }

    /**
     * The binomialCoefficient method calculates the binomialCoefficient values from n and k passed through to the function
     * @param n is a long value to be included in the binomial coefficient calculation
     * @param k is a long value to be included in the binomial coefficient calucation
     * @return the temp variable casted to long data type
     */
    public static long binomialCoefficient(long n, long k) {
        long result = 1;

        if (k > n - k) {
            k = n - k;
        }

        for (long i = 1; i <= k; i++) {
            long gcdValue = gcd(result, i);
            result = (result / gcdValue) * ((n - i + 1) / (i / gcdValue));
        }

        return result;
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
