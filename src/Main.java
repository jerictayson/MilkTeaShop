import java.util.Scanner;
public class Main {

    // items is a type of array that stores elements of strings, static is used because the main method is a static type
    // to prevent creating this class object to access these attributes
    static String items[] = {"Winter Melon", "Taro", "Matcha"}; //items is a type of string array that stores list of elements of items in the store
    static int itemPrice[] = {50, 60, 70}; //itemPrice  is a type of integer array that stores the prices of each item in the store

    static String addOns[] = {"Nata", "Pearls", "Coffe Jelly"}; //items is a type of string array that stores list of elements of addons in the store
    static Scanner scanner = new Scanner(System.in); //Scanner is a type of class that is used for creating input and output streams in the project
    // this class is used to get the user input in the console.
    static int addOnPrices[] = {10, 15, 20};//itemPrice is a type of integer array that stores the prices of each addons in the store

    public static void main(String[] args) { // Entry point of the program

        //Method that is used to start the app.
        // this is used to make the main method not cluttered with code and provide code reusability in the project.


        /*
        * The run program function is the lifetime of the program all the functions and statements are encapsulated
        * in this function to performed tasks of the project, such as printing the ouput to the screen, requesting input
        * for the user and calculate the total prices of selected items in the program.
        *
        * */

        runProgram();
        //after the execution of the program, the println statement below indicated the end of the program and the end of the execution of the main method.
        System.out.println("Thank you for ordering");

    }
    static void runProgram() {

        /*
        * Multi-line comments
        *  the declaration statements below are used to be a placeo rder of each user input requesting in the system
        *
        * */

        //Declaration Statement
        char item_choice, size_choice;
        char addOnChoice;
        int item_quantity;
        double price = 0, totalPrice = 0;

        /*Control loop statement
            while is a type of loop control that will execute the program again and again after the condition is false.
            the true in the argument of the parenthesis of while indicated that this loop control will infinitely
            loop on the program except when it encounters a break keyword which will break the while and exiting the loop.
         */
        while (true) {

            while(true){
                //Printing statements
                System.out.println("        Welcome to the Bubble Tea Shop!");
                System.out.println("+==============================================+");
                System.out.println("|  ITEMS  |    FLAVOR     | S    |   M  |  L   |");
                System.out.println("+=============================================+");
                /*this for loop are used to iterate the items the i value will be used to access all the index of the items
                arrays are always zero based index.
                length returns the size of the array
                items[0] -> Winter Melon,
                items[1] -> Taro,
                items[2] -> Matcha
                * */

                for (int i = 0; i < items.length; i++) {
                    System.out.printf("|    %c    | %-12s | ", items[i].toUpperCase().charAt(0), items[i]);
                    for (int j = 0; j <  itemPrice.length; j++) {
                        //Same as the items but the iteration is the prices of the items accessed from the itemPrice array
                        System.out.printf("  %d  |", itemPrice[j]);
                    }
                    System.out.println();
                }
                System.out.print("Enter your choice[W/T/M]: ");
                /*
                * the scanner.next() are used to get the word or the input of the user,
                * then after the scanner gets the input, the input will be converted to uppercase
                * then returning the character of index 0 means getting the first character in the word.
                * */
                item_choice = scanner.next().toUpperCase().charAt(0);
                // the three conditions in this statement is to check whether the item choice value is equal
                // to the first character of the items.
                // the || symbol is an OR operator that will check

                if(item_choice == 'W' || item_choice == 'T' || item_choice == 'M')
                    break;// this break keyword will break the while(true) in line 54
                else{

                    System.out.println("Invalid Choice try again.");
                }
            }

            // this while true will infinitely loop until it reaches the break keyword.
            while (true) {
                System.out.print("Enter size: ");
                size_choice = scanner.next().toUpperCase().charAt(0);
                // the three conditions in this statement is to check whether the size_choice value is equal
                // to the first character of the size_items.
                // the || symbol is an OR operator that will check
                if(size_choice == 'S' || size_choice == 'M' || size_choice == 'L'){

                    // Switch is used to check the absolute value of the size_choice
                    // same as if statement but only allowing the equality of value of the switch
                    // Ex size_choice == S
                    // Ex size_choice == M
                    switch (size_choice) {
                        case 'S':
                            price = itemPrice[0];
                            break;
                        case 'M':
                            price = itemPrice[1];
                            break;
                        case 'L':
                            price = itemPrice[2];
                            break;
                    }


                    while (true){

                        /*
                        * This is called try catch block, this is used to include the codes that can produce an error on
                        * the runtime of the program, such as user entering a letter to a number. This help the program
                        * to catch any errors or notify the user if the user entered the wrong input and prevent the program
                        * to crash whenever an error happens
                        * */
                        try {

                            //this scanner.nextLine() are used to catch the end of line of entering the keyboard
                            // this is a bug when the scanner finishes accepting a word input and tries to accepts a number after the word is entered into the scanner
                            //shortly, scanner.nextLine() in this context are used to consume the newline of enter action on the keyboard
                            scanner.nextLine();
                            System.out.print("Enter Quantity: ");
                            item_quantity = scanner.nextInt(); // this can produce an error if the user is dumb to enter a letter instead of a number.
                            totalPrice += price * item_quantity;
                            break;

                        }catch(Exception e){
                            // if any error is found on the running of statements inside of try block this block will execute and execute all the statements inside of the exception block
                            System.out.println("Invalid input.");
                        }


                    }
                    break; // this keyword will break the while loop on line 96
                }else {
                    System.out.println("Invalid Size try again.");
                }
            }
            System.out.println("Total Price " + totalPrice);
            char choice;// this variable is used to store the user input whether they want a addons or not
            do {
                System.out.print("Would you like some add ons> [Y/N]: ");
                choice = scanner.next().toUpperCase().charAt(0);

                if(choice != 'Y' && choice != 'N'){
                    System.out.println(choice);
                    System.out.println("Invalid Choice try again.");
                }
            }while(choice != 'Y' && choice != 'N');

            //if the choice is equal to yes or Y then print the addons page and request the user what type of choice she/he want to include.
            if(choice == 'Y'){

                while (true) {
                    System.out.println("                  Add Ons                      ");
                    System.out.println("+=============================================+");
                    System.out.println("|  ITEMS  |       FLAVOR       | S  | M   | L |");
                    System.out.println("+=============================================+");
                    for (int i = 0; i < addOns.length; i++) {
                        System.out.printf("|    %c    | %-18s | %d | %d | %d |\n", addOns[i].toUpperCase().charAt(0), addOns[i], addOnPrices[i], addOnPrices[i], addOnPrices[i]);
                    }
                    System.out.print("Enter your choice[N/P/C]: ");
                    addOnChoice = scanner.next().toUpperCase().charAt(0);

                    if(addOnChoice != 'N' && addOnChoice != 'P' && addOnChoice != 'C'){
                        System.out.println("Invalid choice!");
                    }else {

                        switch (addOnChoice) {
                            case 'N':
                                totalPrice += addOnPrices[0];
                                break;
                            case 'P':
                                totalPrice += addOnPrices[1];
                                break;
                            case 'C':
                                totalPrice += addOnPrices[2];
                                break;
                        }

                        break;
                    }

                }

            } // if not then just print the total price
            System.out.println("Total Price " + totalPrice);
            // the next statements are used to ask the user if she/he wants to add more items
            System.out.print("Do you want to try again? [Y/N]: ");
            if (scanner.next().toUpperCase().charAt(0) == 'N') {
                break;//this break will break the first while loop and exiting the program
            }

        }
        scanner.close();

    }


}