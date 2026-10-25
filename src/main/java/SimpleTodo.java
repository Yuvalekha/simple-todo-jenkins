import java.util.ArrayList;
import java.util.Scanner;

public class SimpleTodo {
    public static void main(String[] args) {
        ArrayList<String> todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Minimalist To-Do List ===");
        System.out.println("Type your task and press Enter. Type 'show' to view tasks, or 'exit' to quit.");

        while (true) {
            System.out.print("\nAction/Task: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            } 

            if (input.equalsIgnoreCase("show")) {
                System.out.println("\n--- Your Current List ---");
                if (todoList.isEmpty()) {
                    System.out.println("(No tasks added yet)");
                } else {
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println((i + 1) + ". " + todoList.get(i));
                    }
                }
            } else if (!input.isEmpty()) {
                todoList.add(input);
                System.out.println("Added: " + input);
            }
        }
        scanner.close();
    }
}
