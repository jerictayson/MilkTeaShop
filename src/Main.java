import java.util.Scanner;//ginagamit for user input.
//private, protected, default, public
public class Main {

    // items is a type of array that stores elements of strings, static is used because the main method is a static type
    // to prevent creating this class object to access these attributes
    static String items[] = {"Winter Melon", "Taro", "Matcha"}; //items is a type of string array that stores list of elements of items in the store
    static int itemPrice[] = {50, 60, 70}; //itemPrice  is a type of integer array that stores the prices of each item in the store
    static String addOns[] = {"Nata", "Pearls", "Coffe Jelly"}; //items is a type of string array that stores list of elements of addons in the store
    static Scanner scanner = new Scanner(System.in); //Scanner is a type of class that is used for creating input and output streams in the project
    // this class is used to get the user input in the console.
    static int addOnPrices[] = {10, 15, 20};//itemPrice is a type of integer array that stores the prices of each addons in the store
    static String[] selectedItems = new String[100];

    static int index = 0, lastIndex = -1;
    static double totalPrice = 0, selectedItemPrice = 0, selectedAddOnPrice;
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
        //after the execution of the run program method, the println statement below indicated the end of the program
        // and the end of the execution of the main method.

        System.out.println("Your items and their total:");
        showCart();
        System.out.println("Total Price: " + totalPrice);
        System.out.println("Thank you for ordering");

        scanner.close();

    }

    static void showItems() {
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
                    for (int j = 0; j < itemPrice.length; j++) {
                        //Same as the items but the iteration is the prices of the items accessed from the itemPrice array
                        System.out.printf("  %d  |", itemPrice[j]);
                    }
                    System.out.println();
                }
    }

    static void showAddOns(){
            System.out.println("                  Add Ons                      ");
            System.out.println("+=============================================+");
            System.out.println("|  ITEMS  |       FLAVOR       | S  | M   | L |");
            System.out.println("+=============================================+");
            for (int i = 0; i < addOns.length; i++) {
                System.out.printf("|    %c    | %-18s | %d | %d | %d |\n", addOns[i].toUpperCase().charAt(0), addOns[i], addOnPrices[i], addOnPrices[i], addOnPrices[i]);
            }
    }

    static void showCart(){
        boolean hasItem = false;
        for (int i = 0; i < selectedItems.length; i++) {
            if (selectedItems[i] != null) {
                hasItem = true;
                break;
            }
        }
        if(!hasItem){
            System.out.println("No items in the cart");
            return;
        }

       for (int i = 0; i < selectedItems.length; i++) {
            if (selectedItems[i] != null) {
                System.out.println(selectedItems[i]);
            }
        }
        System.out.println("Total Price of all items: " + totalPrice);
    }

    static void makeOrder(){

        /*
         * Multi-line comments
         *  the declaration statements below are used to be a placeorder of each user input requesting in the system
         *
         * */

        //Declaration Statement
        char item_choice, size_choice;
        char addOnChoice;
        int item_quantity;
        double price = 0;

        /*
            Control loop statement
                 while is a type of loop control that will execute the program again and again after the condition is false.
                 the true in the argument of the parenthesis of while indicated that this loop control will infinitely
                 loop on the program except when it encounters a break keyword which will break the while and exiting the loop.
         */
        while (true) {

            while(true){
                //Printing statements
                showItems();
                System.out.print("Enter your choice[W/T/M] (Enter Q to quit): ");
                /*
                 * the scanner.next() are used to get the word or the input of the user,
                 * then after the scanner gets the input, the input will be converted to uppercase
                 * then returning the character of index 0 means getting the first character in the word.
                 * */
                item_choice = scanner.next().toUpperCase().charAt(0);
                // the three conditions in this statement is to check whether the item choice value is equal
                // to the first character of the items.
                // the || symbol is an OR operator that will check

                if(item_choice == 'W' || item_choice == 'T' || item_choice == 'M'){

                    switch (item_choice){
                        case 'W':
                            selectedItems[index] = "Item Name: "+ items[0];
                            break;
                        case 'T':
                            selectedItems[index] = "Item Name: "+items[1];
                            break;
                        case 'M':
                            selectedItems[index] = "Item Name: "+ items[2];
                            break;
                    }
                    break;// this break keyword will break the while(true) in line 54
                }
                    if(item_choice == 'Q')
                        return;//halting the execution of this function.
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
                            selectedItems[index] += "\nItem Price: "+ itemPrice[0];
                            break;
                        case 'M':
                            price = itemPrice[1];
                            selectedItems[index] += "\nItem Price: "+ itemPrice[1];
                            break;
                        case 'L':
                            price = itemPrice[2];
                            selectedItems[index] += "\nItem Price: "+ itemPrice[2];
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
                            if(item_quantity<=0){
                                System.out.println("Invalid Quantity try again.");
                            }else {
                                totalPrice += price * item_quantity;
                                selectedItems[index] += "\nItem Quantity: "+ item_quantity;
                                selectedItemPrice = price * item_quantity;
                                selectedItems[index] += "\nTotal Price of this item: "+ selectedItemPrice;
                                break;
                            }

                        }catch(Exception ignore){
                            // if any error is found on the running of statements inside of try block this block will execute and execute all the statements inside of the exception block
                            System.out.println("Invalid input.");
                        }

                    }
                    break; // this keyword will break the while loop on line 96
                }else {
                    System.out.println("Invalid Size try again.");
                }
            }
            System.out.println("Total Price " + selectedItemPrice);
            char choice;// this variable is used to store the user input whether they want a addons or not
            do {
                System.out.print("Would you like some add ons> [Y/N]: ");
                choice = scanner.next().toUpperCase().charAt(0);

                if(choice != 'Y' && choice != 'N'){
                    System.out.println("Invalid Choice try again.");
                }
            }while(choice != 'Y' && choice != 'N');

            //if the choice is equal to yes or Y then print the addons page and request the user what type of choice she/he want to include.
            if(choice == 'Y'){

                while (true) {
                    showAddOns();
                    System.out.print("Enter your choice[N/P/C]: ");
                    addOnChoice = scanner.next().toUpperCase().charAt(0);

                    if(addOnChoice != 'N' && addOnChoice != 'P' && addOnChoice != 'C'){
                        System.out.println("Invalid choice!");
                    }else {

                        switch (addOnChoice) {
                            case 'N':
                                totalPrice += addOnPrices[0];
                                selectedItems[index] += "\nAdd On: "+ addOns[0];
                                selectedItemPrice += addOnPrices[0];
                                break;
                            case 'P':
                                totalPrice += addOnPrices[1];
                                selectedItems[index] += "\nAdd On: "+ addOns[1];
                                selectedItemPrice += addOnPrices[1];
                                break;
                            case 'C':
                                totalPrice += addOnPrices[2];
                                selectedItems[index] += "\nAdd On: "+ addOns[2];
                                selectedItemPrice += addOnPrices[2];
                                break;
                        }

                        selectedItems[index] += "\nTotal Price: " + selectedItemPrice+"\n\n\n";
                        break;
                    }

                }

            }

            // the next statements are used to ask the user if she/he wants to add more items
            if(lastIndex > -1){
                System.out.println("Item Updated.");
                break;
            }else {

                System.out.print("Do you want to try again? [Y/N]: ");
                if (scanner.next().toUpperCase().charAt(0) == 'N') {
                    index++;
                    break;//this break will break the first while loop and exiting the program
                }
            index++;

            }

        }
    }

    static void updateItems(){

        boolean hasItem = false;
        for (int i = 0; i < selectedItems.length; i++) {
            if(selectedItems[i] != null){
                hasItem = true;
                break;
            }
        }
        if(!hasItem){

            System.out.println("No items to update.");
            return;
        }
        int number = 1;
        try {

            while(true){

                for (int i=0; i< selectedItems.length; i++){
                    if(selectedItems[i] != null){
                     System.out.printf("Item no: [%d]:\n %s \n\n", number, selectedItems[i]);
                     number++;
                    }
                }
                System.out.println("Please Enter the order number: ");
                int orderNumber = scanner.nextInt();
                orderNumber--;
                if(orderNumber < 0 || orderNumber > selectedItems.length) {
                    System.out.println("Invalid Order Number");
                }else {
                    if(selectedItems[orderNumber] == null) {
                        System.out.println("Order Number is empty");
                        number = 0;
                    }else {
                        lastIndex = index;
                        index = orderNumber;
                        String totalPriceString = selectedItems[orderNumber].substring(selectedItems[orderNumber].lastIndexOf("item: ")+6).trim();//getting the price of the item
                        totalPrice -= Double.parseDouble(totalPriceString);
                        makeOrder();
                        index = lastIndex;
                        lastIndex = -1;
                        break;
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Invalid input try again.");
        }

    }

    static void deleteItem(){

        boolean hasItem = false;
        for (int i = 0; i < selectedItems.length; i++) {
            if(selectedItems[i] != null){
                hasItem = true;
                break;
            }
        }
        if(!hasItem){

            System.out.println("No items to delete.");
            return;
        }
        while (true){

            try {

                int number = 1;
                for (int i=0; i< selectedItems.length; i++){
                    if(selectedItems[i] != null){
                        System.out.printf("Item no: [%d]:\n %s \n\n", number, selectedItems[i]);
                        number++;
                    }
                }
                System.out.println("Please Enter the order number: ");
                int orderNumber = scanner.nextInt();
                orderNumber--;
                if(orderNumber < 0 || orderNumber > selectedItems.length) {
                    System.out.println("Invalid Order Number");
                }else {
                    if(selectedItems[orderNumber] == null) {
                        System.out.println("Order Number is empty");
                    }else {
                        String totalPriceString = selectedItems[orderNumber].substring(selectedItems[orderNumber].lastIndexOf("item: ")+6).trim();
                        double price = Double.parseDouble(totalPriceString);
                        selectedItems[orderNumber] = null;
                        totalPrice -= price;
                        System.out.println("Item Deleted.");
                        break;
                    }
                }
            }catch (Exception e){
                System.out.println("Invalid input try again.");
            }
        }

    }
    static void runProgram() {

        while(true){

            try {
                System.out.println("Welcome to Bubble Tea Shop");
                System.out.println("1. Make an Order");
                System.out.println("2. Show Cart");
                System.out.println("3. Update cart");
                System.out.println("4. Delete Item to your cart");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        makeOrder();
                        break;
                    case 2:
                        showCart();
                        break;
                    case 3:
                        updateItems();
                        break;
                    case 4:
                        deleteItem();
                        break;
                    case 5:
                        System.out.println("Thank you for using our program.");
                        return;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }

            }catch (Exception e){
                System.out.println("Invalid input try again.");
                scanner.nextLine();//There's a bug in scanner that needs to consume the nextline of a keyboard enter action
            }

        }

    }


}
