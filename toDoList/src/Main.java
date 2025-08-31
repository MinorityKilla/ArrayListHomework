import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nВыберите операцию:");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить дело");
            System.out.println("2. Показать дела");
            System.out.println("3. Удалить дело по номеру");
            System.out.println("4. Удалить дело по названию");
            System.out.print("Ваш выбор: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // чтобы убрать остаток строки после nextInt()

            switch (choice) {
                case 0:
                    System.out.println("Выход из программы...");
                    break;

                case 1:
                    System.out.print("\nВведите название задачи: ");
                    String taskToAdd = scanner.nextLine();
                    if (!tasks.contains(taskToAdd)) {
                        tasks.add(taskToAdd);
                        System.out.println("Добавлено!");
                    } else {
                        System.out.println("Задача уже есть в списке!");
                    }
                    printTasks(tasks);
                    break;

                case 2:
                    printTasks(tasks);
                    break;

                case 3:
                    System.out.print("\nВведите номер для удаления: ");
                    int indexToRemove = scanner.nextInt();
                    scanner.nextLine();
                    if (indexToRemove >= 1 && indexToRemove <= tasks.size()) {
                        tasks.remove(indexToRemove - 1);
                        System.out.println("Удалено!");
                    } else {
                        System.out.println("Задачи с таким номером нет!");
                    }
                    printTasks(tasks);
                    break;

                case 4:
                    System.out.print("\nВведите задачу для удаления: ");
                    String taskToRemove = scanner.nextLine();
                    if (tasks.remove(taskToRemove)) {
                        System.out.println("Удалено!");
                    } else {
                        System.out.println("Задачи с таким названием нет!");
                    }
                    printTasks(tasks);
                    break;

                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void printTasks(ArrayList<String> tasks) {
        System.out.println("Ваш список дел:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}
