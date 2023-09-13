package Part3_ContactDatabase;
import java.util.Scanner;
public class Contact_Database {

    public static void main(String[] args) {
        boolean exitFlag = false;
        while (!exitFlag) {

            exitFlag = executeMenuChoice(chooseAnItem(), exitFlag);

        }
    }
    public static boolean executeMenuChoice(int menuItem, boolean exitFlag) {
        switch (menuItem) {
            case 1 -> AddStringToArray();
            case 2 -> showContacts();
            case 3 -> searchInContacts();
            case 4 -> editContact();
            case 5 -> deleteOneContact();
            case 6 -> deleteAllContact();
            case 7 -> addSampleContacts();
            case 8 -> exitFlag = true;
        }
        return exitFlag;
    }

    public static void AddStringToArray() {

        Scanner userScanner = new Scanner(System.in);
        print("You may enter any number of new contacts by simply writing down a Name, Surname and phone number in a row." +
                "\n To finish adding just write word 'FINISH' and process will stop.");
        boolean FinishFlag = false;
        String UserInput;
        while (!FinishFlag) {
            UserInput = userScanner.nextLine();
            if (UserInput.isEmpty()) {
                print("Please input something.");
            } else {
                if (UserInput.toLowerCase().startsWith("finish")) {
                    print("That's it for now, exiting.");
                    FinishFlag = true;
                } else {
                    contacts[contactCount] = UserInput;
                    contactCount++;
                }
            }
        }
    }

    public static void showContacts() {
        if (contactCount == 0) {
            print("There is no contacts yet, please add some");
        } else {
            for (int arrayIndex = 0; arrayIndex < contactCount; arrayIndex++) {
                int numberOfCurrentContact = arrayIndex + 1;
                print(numberOfCurrentContact + ". " + contacts[arrayIndex]);
            }
        }
    }

    public static void searchInContacts() {

        Scanner userScanner = new Scanner(System.in);
        print("You may enter any phrase to search within contacts, I'll do my best.");
        String UserInput = "";
        while (UserInput.isEmpty()) {
            UserInput = userScanner.nextLine();
        }

        for (int arrayIndex = 0; arrayIndex < contactCount; arrayIndex++) {
            if (contacts[arrayIndex].toLowerCase().contains(UserInput.toLowerCase())) {
                print(arrayIndex + 1 + ". " + contacts[arrayIndex]);
            }
        }
    }
    public static void editContact() {

        if (contactCount == 0) {
            print("There is no contacts yet, please add some");
        } else {
            int UserInput = askForExistingContact();

            print("Now You can edit contact " + UserInput + ". " + contacts[UserInput - 1]);
            Scanner userScanner = new Scanner(System.in);

            String editedContact = "";
            while (editedContact.isEmpty()) {
                editedContact = userScanner.nextLine();
                if (editedContact.isEmpty()) {
                    print("Please input something.");
                } else {

                    contacts[UserInput - 1] = editedContact;

                }
            }
        }
    }
    public static void deleteOneContact() {

        if (contactCount == 0) {
            print("There is no contacts yet, please add some");
        } else {
            int UserInput = askForExistingContact();
            int arrayIndex = UserInput - 1;
            String[] arrayWithoutOneContact = new String[100];
            int j = 0; //iterator for new array
            for (int i = 0; i < contactCount; i++) {
                if (i == arrayIndex) {
                    //not adding this element to new array;
                    System.out.println(" ");
                } else {
                    arrayWithoutOneContact[j] = contacts[i];
                    j++;
                }
            }
            contacts = arrayWithoutOneContact;
            contactCount--;
            print("DELETED!");
        }
    }
    public static void deleteAllContact() {

        if (contactCount == 0) {
            print("There is no contacts yet, please add some");
        } else {
            contacts = new String[100];
            contactCount = 0;
            print("ALL Contacts are DELETED!");
        }
    }

    public static int askForExistingContact() {
        int Result = 0;
        boolean ExistingElementFlag = false;
        while (!ExistingElementFlag) {
            Result = GetUserInt("You may choose particular contact by entering it's number.");
            int arrayIndex = Result - 1;
            if (arrayIndex >= 0 && arrayIndex < contactCount) {
                ExistingElementFlag = true;
            } else {
                System.out.printf("There is no such number, try some between 0 and %d\n", contactCount - 1);
            }
        }
        return Result;
    }
    public static void addSampleContacts() {

        contacts[contactCount] = "Mr. Anderson +3801234567890";
        contactCount++;
        contacts[contactCount] = "Mr. Simpson +3801239045678";
        contactCount++;
        contacts[contactCount] = "Mr. Otherson +3801567890234";
        contactCount++;

    }

    public static int chooseAnItem() {
        boolean MenuFlag = false;
        int ChoiceCount = 0;
        String userChoice;
        while (!MenuFlag) {
            userChoice = GetUserString("""
                    Welcome to main menu, please choose one of the following items:
                    1. Add contacts
                    2. Show contacts
                    3. Search in contacts
                    4. Edit contacts
                    5. Delete contact
                    6. Delete All contacts
                    7. Add sample contacts
                    8. Exit""");
            if (userChoice.toLowerCase().contains("add")) {
                ChoiceCount = 1;
                MenuFlag = true;
            }
            else if (userChoice.contains("1")) {
                MenuFlag = true;
                ChoiceCount = 1;
            }
            else if (userChoice.toLowerCase().contains("show")) {
                ChoiceCount = 2;
                MenuFlag = true;
            }
            else if (userChoice.toLowerCase().contains("2")) {
                ChoiceCount = 2;
                MenuFlag = true;
            }
            else if (userChoice.toLowerCase().contains("search")) {
                ChoiceCount = 3;
                MenuFlag = true;
            }
            else if (userChoice.toLowerCase().contains("3")) {
                ChoiceCount = 3;
                MenuFlag = true;
            }
            else if (userChoice.toLowerCase().contains("edit")) {
                ChoiceCount = 4;
                MenuFlag = true;
            }
            else if (userChoice.contains("4")) {
                ChoiceCount = 4;
                MenuFlag = true;
            }
            else if (userChoice.toLowerCase().contains("delete all")) {
                ChoiceCount = 6;
                MenuFlag = true;
            }

            else if (userChoice.contains("6")) {
                ChoiceCount = 6;
                MenuFlag = true;
            }
            else if (userChoice.toLowerCase().contains("delete")) {
                ChoiceCount = 5;
                MenuFlag = true;
            }
            else if (userChoice.contains("5")) {
                ChoiceCount = 5;
                MenuFlag = true;
            }
            else if (userChoice.toLowerCase().contains("sample")) {
                ChoiceCount = 7;
                MenuFlag = true;
            }
            else if (userChoice.contains("7")) {
                ChoiceCount = 7;
                MenuFlag = true;
            }
            else if (userChoice.toLowerCase().contains("exit")) {
                ChoiceCount = 8;
                MenuFlag = true;
            }
            else if (userChoice.contains("8")) {
                ChoiceCount = 8;
                MenuFlag = true;
            }
        }
        return ChoiceCount;
    }
    public static String GetUserString(String systemMessage) {
        Scanner userScanner = new Scanner(System.in);
        print(systemMessage);
        return userScanner.nextLine();
    }
    public static int GetUserInt(String systemMessage) {
        Scanner userScanner = new Scanner(System.in);
        print(systemMessage);
        return userScanner.nextInt();
    }
    public static int contactCount = 0;
    public static String[] contacts = new String[100];
    public static void print(String str) {
        System.out.println(str);
    }
}

