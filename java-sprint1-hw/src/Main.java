import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        System.out.println("Пришло время практики:)");
        printMenu();
        int command = scanner.nextInt();
        while (true) {
            if (command == 1) {
                stepTracker.saveSteps();
            } else if (command == 2) {
                stepTracker.statMonth();
            } else if (command == 3) {
                stepTracker.newAmbitionStep();
            } else if (command == 0) {
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
            printMenu();
            command = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }
    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");

    }
}
