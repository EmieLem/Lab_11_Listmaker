import java.util.ArrayList;
import java.util.Scanner;

public class Listmaker
{
    private static final String MENU_CHOICES = "[AaDdIiPpQq]";

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>();
        boolean running = true;

        while(running)
        {
            displayListAndMenu(items);
            String choice = SafeInput.getRegExString(console, "Choose an option", MENU_CHOICES);

            switch(choice.toUpperCase())
            {
                case "A":
                    addItem(console, items);
                    break;
                case "D":
                    deleteItem(console, items);
                    break;
                case "I":
                    insertItem(console, items);
                    break;
                case "P":
                    printList(items);
                    break;
                case "Q":
                    if(SafeInput.getYNConfirm(console, "Are you sure you want to quit?"))
                    {
                        running = false;
                    }
                    break;
                default:
                    // The regular-expression input check prevents this case.
                    break;
            }
        }

        System.out.println("Goodbye!");
        console.close();
    }

    private static void displayListAndMenu(ArrayList<String> items)
    {
        System.out.println("\n========== ListMaker ==========");
        printList(items);
        System.out.println("\nA - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    private static void addItem(Scanner console, ArrayList<String> items)
    {
        String item = SafeInput.getNonZeroLenString(console, "Enter the item to add");
        items.add(item);
        System.out.println("Added: " + item);
    }

    private static void deleteItem(Scanner console, ArrayList<String> items)
    {
        if(items.isEmpty())
        {
            System.out.println("The list is empty; there is nothing to delete.");
            return;
        }

        printList(items);
        int itemNumber = SafeInput.getRangedInt(console, "Enter the item number to delete", 1, items.size());
        String removed = items.remove(itemNumber - 1);
        System.out.println("Deleted: " + removed);
    }

    private static void insertItem(Scanner console, ArrayList<String> items)
    {
        int position = SafeInput.getRangedInt(console, "Enter the position to insert at", 1, items.size() + 1);
        String item = SafeInput.getNonZeroLenString(console, "Enter the item to insert");
        items.add(position - 1, item);
        System.out.println("Inserted " + item + " at position " + position + ".");
    }

    private static void printList(ArrayList<String> items)
    {
        System.out.println("\nYour List:");
        if(items.isEmpty())
        {
            System.out.println("  (empty)");
            return;
        }

        for(int index = 0; index < items.size(); index++)
        {
            System.out.println("  " + (index + 1) + ". " + items.get(index));
        }
    }
}
