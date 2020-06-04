/**Author: Eric Truong
 * Date: September 11, 2019
 * Description: Have a user input 10 values to an array and the user is given options to display their values, display
 * values reversed, display the sum, display the maximum, find a value, or replace a value
 *
 */

import java.util.Scanner;

public class ArraySystem {
    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);

        //declare array
        int [] userValues = populateArray();

        int menuChoice = 0;

        //loop the menu with choices until the user wants to quit
        while (menuChoice != 8) {

            displayMenu();
            System.out.print("Make a selection: ");
            menuChoice = CheckInput.getIntRange(1, 8);

            if (menuChoice == 1) {
                displayValues(userValues);
            }

            else if (menuChoice == 2) {
                displayReversed(userValues);
            }

            else if (menuChoice == 3) {
                int sum = computeSum(userValues);
                System.out.println("Sum is " + sum);
            }

            else if (menuChoice == 4) {
                int maximum = displayMaximum(userValues);
                System.out.println("Maximum is " + maximum);
            }

            else if (menuChoice == 5) {
                //prompt user for a number to search for
                System.out.print("Search for number: ");
                int numberSearch = CheckInput.getInt();
                numberSearch = findValue(numberSearch, userValues);
                if (numberSearch == -1) {
                    System.out.println("Your value does not exist");
                }
                else {
                    System.out.println("Your value is in position " + numberSearch);
                }
            }

            else if (menuChoice == 6) {
                //prompt user location they want to replace and the new value
                System.out.print("What index do you want to replace?: ");
                int location = CheckInput.getIntRange(1, 10);
                System.out.print("What's your new value?: ");
                int newValue = CheckInput.getInt();
                userValues = insertValue(userValues, location, newValue);
            }

            else if (menuChoice == 7) {
                userValues = populateArray();
            }
        }

        System.out.println("Goodbye!");

    }

    /**
     * Send in an empty array and populate it with values
     * @return              array filled with user's values
     */
    public static int [] populateArray () {
        int [] userValues = new int [10];
        System.out.println("Please enter 10 values: ");
        for (int i = 0; i < 10; i++) {
            int value = CheckInput.getInt();
            userValues[i] = value;
        }

        return userValues;

    }

    /**
     * Given the user's array, print all values
     * @param userValues    user's array
     */
    public static void displayValues (int [] userValues) {
        int comma = 0;
        for (int i : userValues) {
            System.out.print(i);
            if (comma < 9) {
                System.out.print(", ");
                comma += 1;
            }
        }
        System.out.println("");
    }

    /**
     * Given the user's array, print all values but in reverse
     * @param userValues    user's array
     */
    public static void displayReversed (int [] userValues) {
        int comma = 0;
        for (int i = userValues.length - 1; i >= 0; i--) {
            System.out.print(userValues[i]);
            if (comma < 9) {
                System.out.print(", ");
                comma++;
            }
        }
        System.out.println("");
    }

    /**
     * Take the array and compute the sum of all the values
     * @param userValues    user's array
     * @return              return sum
     */
    public static int computeSum (int [] userValues) {
        int sum = 0;
        for (int i : userValues) {
            sum += i;
        }
        return sum;
    }

    /**
     * Take the array and find the maximum value
     * @param userValues    user's array
     * @return              return maximum value in array
     */
    public static int displayMaximum (int [] userValues) {

        int maximum = userValues[0];
        for (int i = 1; i < userValues.length; i++) {
            if (userValues[i] > maximum) {
                maximum = userValues[i];
            }

        }

        return maximum;

    }

    /**
     * Given a user's desired value, find it in their array
     * @param value         user's desired array
     * @param userValues    user's array
     * @return              return index of value
     */
    public static int findValue (int value, int [] userValues) {
        for (int i = 0; i < userValues.length; i++) {
            if (value == userValues[i]) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Given a user's desired location and new value, replace the old value in arraylist with it
     * @param userValues    user's array
     * @param location      user's location wanting to be replaced
     * @param newValue      user's new value to insert
     * @return              return array with new value
     */
    public static int [] insertValue (int [] userValues, int location, int newValue ) {
        location -= 1;
        userValues[location] = newValue;
        return userValues;
    }

    /**
     * Create a menu
     */
    public static void displayMenu() {
        System.out.println("1. Display Values");
        System.out.println("2. Display Reversed");
        System.out.println("3. Display Sum");
        System.out.println("4. Display Maximum");
        System.out.println("5. Search for a Value");
        System.out.println("6. Insert new Value");
        System.out.println("7. Reset Values");
        System.out.println("8. Quit");

    }
}
