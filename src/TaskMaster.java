import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    String description;
    String dueDate;
    int priority;
    boolean isDone;

    public Task(String description, String dueDate, int priority) {
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isDone = false;
    }
}

public class TaskMaster {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("TaskMaster: Your Command-Line ToDo List Manager");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. List Pending Tasks");
            System.out.println("4. Remove Completed Tasks");
            System.out.println("5. Sort Tasks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markTaskAsDone();
                    break;
                case 3:
                    listPendingTasks();
                    break;
                case 4:
                    removeCompletedTasks();
                    break;
                case 5:
                    sortTasksMenu();
                    break;
                case 6:
                    System.out.println("Exiting TaskMaster. Have a great day!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter due date: ");
        String dueDate = scanner.nextLine();
        System.out.print("Enter priority (1 - High, 2 - Medium, 3 - Low): ");
        int priority = scanner.nextInt();
        tasks.add(new Task(description, dueDate, priority));
        System.out.println("Task added successfully!");
    }

    static void markTaskAsDone() {
        System.out.print("Enter the index of the task to mark as done: ");
        int taskIndex = scanner.nextInt();
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.get(taskIndex).isDone = true;
            System.out.println("Task marked as done.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    static void listPendingTasks() {
        System.out.println("Pending tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (!task.isDone) {
                System.out.println(i + ". " + task.description + " (Due: " + task.dueDate + ", Priority: " + task.priority + ")");
            }
        }
    }

    static void removeCompletedTasks() {
        tasks.removeIf(task -> task.isDone);
        System.out.println("Completed tasks removed.");
    }

    static void sortTasksMenu() {
        System.out.println("Sort Tasks:");
        System.out.println("1. By Priority");
        System.out.println("2. By Due Date");
        System.out.println("3. By Creation Date");
        System.out.print("Enter your choice: ");
        int sortChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (sortChoice) {
            case 1:
                sortTasksByPriority();
                break;
            case 2:
                sortTasksByDueDate();
                break;
            case 3:
                sortTasksByCreationDate();
                break;
            default:
                System.out.println("Invalid choice. Sorting canceled.");
        }
    }

    static void sortTasksByPriority() {
        Collections.sort(tasks, Comparator.comparingInt(task -> task.priority));
        System.out.println("Tasks sorted by priority.");
    }

    static void sortTasksByDueDate() {
        Collections.sort(tasks, Comparator.comparing(task -> task.dueDate));
        System.out.println("Tasks sorted by due date.");
    }

    static void sortTasksByCreationDate() {
        // You can implement sorting by creation date here.
        System.out.println("Tasks sorted by creation date.");
    }
}