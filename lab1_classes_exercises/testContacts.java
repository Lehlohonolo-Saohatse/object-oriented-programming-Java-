import java.util.ArrayList;
import java.util.Scanner;

public class testContacts {
    public static void main(String[] args) {
        ArrayList<Contact> firstContacts = new ArrayList<Contact>(15);
        addContacts(firstContacts);
        displayContacts(firstContacts);
        findAContact(firstContacts);
        removeContacts(firstContacts);
    }

    public static void addContacts(ArrayList<Contact> firstContacts) {
        Scanner input = new Scanner(System.in);

        String newName = "";
        String newCellPhoneNumber = "";
        char ch;

        do {
            System.out.print("Enter the name of the contact (N to quit): ");
            newName = input.nextLine();
            if (newName.equalsIgnoreCase("N")) {
                break;
            } else {

                System.out.print("Enter the cell phone number: ");
                newCellPhoneNumber = input.nextLine();

                firstContacts.add(new Contact(newName, newCellPhoneNumber));

                System.out.print("Do you want to add another contact [Y/N]: ");
                ch = input.nextLine().charAt(0);
            }

        } while (ch == 'Y');
    }

    public static void displayContacts(ArrayList<Contact> firstContacts) {
        System.out.println("List of Contacts:");
        for (int i = 0; i < firstContacts.size(); i++) {
            System.out.println((i + 1) + ". " + firstContacts.get(i));
        }
    }

    public static void findAContact(ArrayList<Contact> firstContacts) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter name of the contact to find: ");
        String nameToSearch = input.nextLine();

        boolean found = false;
        for (Contact contact : firstContacts) {
            if (contact.getName().equalsIgnoreCase(nameToSearch)) {
                System.out.println(nameToSearch + " is in the contact list, and their cell phone number is " + contact.getCell_Phone_Number());
                System.out.print("Do you want to change the cell-phone number? (Y/N): ");
                String askForChangeOfNumber = input.nextLine();
                if (askForChangeOfNumber.equalsIgnoreCase("Y")) {
                    System.out.print("Enter new cell-phone number: ");
                    String newCellPhoneNumber = input.nextLine();
                    contact.setCellNum(newCellPhoneNumber);
                    System.out.println("Cell phone number updated successfully.");
                } else {
                    System.out.println("You chose not to change the cell-phone number. Thank you!");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(nameToSearch + " is not in the contact list!");
            System.out.print("Do you want to add the name to the list? (Y/N): ");
            String ifWantToAdd = input.nextLine();
            if (ifWantToAdd.equalsIgnoreCase("Y")) {
                System.out.print("Enter the contact number for the name: ");
                String addNewNumber = input.nextLine();
                firstContacts.add(new Contact(nameToSearch, addNewNumber));
                System.out.println("Contact added successfully!");
            }
        }
    }

    public static void removeContacts(ArrayList<Contact> firstContacts) {
        Scanner scanner = new Scanner(System.in);
        int toRemove;

        while (true) {
            displayContacts(firstContacts);
            System.out.print("Enter the number of the contact to remove (-1 to quit): ");
            toRemove = scanner.nextInt();
            scanner.nextLine();

            if (toRemove == -1) {
                break;
            }

            if (toRemove < 1 || toRemove > firstContacts.size()) {
                System.out.println("Invalid choice! Please try again...");
                continue;
            }

            System.out.print("Are you sure you want to remove " + firstContacts.get(toRemove - 1).getName() + "? (Y/N): ");
            char answer = scanner.nextLine().charAt(0);
            if (answer == 'y' || answer == 'Y') {
                firstContacts.remove(toRemove - 1);
                System.out.println("Contact removed Successfully!");
            } else {
                System.out.println("Contact removal FAILED!");
            }
        }

        if (firstContacts.isEmpty()) {
            System.out.println("The contact list is empty.");
        } else {
            System.out.println("Updated List:");
            for (int i = 0; i < firstContacts.size(); i++) {
                System.out.println((i + 1) + ". " + firstContacts.get(i));
            }
        }
    }
}