import java.util.Scanner;
public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    Converter converter = new Converter();
    int[][] monthToData = new int[12][31];
    int ambitionStep = 10000;


     int newAmbitionStep() {
        System.out.println("Ваша действующая цель шагов в день " + ambitionStep);
        System.out.println("Введите новую цель по количеству шагов в день");
        int newSteps = scanner.nextInt();
        if (newSteps < 0) {
            System.out.println("Значение не может быть отрицательным:(");
        } else {
            ambitionStep = newSteps;
            System.out.println("Ваша новая цель: " + ambitionStep + " шагов в день");
        }
        return ambitionStep;
    }

    public void saveSteps() {
        System.out.println("За какой месяц Вы хотите ввести значение? Введите: 0-Январь...11-Декабрь");
        int month = scanner.nextInt();
        if (month < 0 || month > 11) {
            System.out.println("Вы ввели неверное значение! Ведите: 0-Январь...11-Декабрь");
        } else {
            System.out.println("За какой день Вы хотите ввести значение? Введите: 1 - 30");
            int day = scanner.nextInt();
            if (day < 0 || day > 30) {
                System.out.println("Вы ввели неправильно количество дней:(");
            } else {
                System.out.println("Введите количество шагов");
                int steps = scanner.nextInt();
                if (steps < 0) {
                    System.out.println("Количество шагов всегда больше нуля:)");
                } else {
                    monthToData[month][day] = steps;
                }
            }
        }

    }
    public void statMonth() {
        System.out.println("За какой месяц хотите узнать статистику? Ведите: 0-Январь...11-Декабрь");
        int sumStep = 0;
        int maxStep = 0;
        int middleStep = 0;
        int maxSeries = 0;
        int series = 0;
        int month = scanner.nextInt();
        if (month < 0 || month > 11) {
            System.out.println("Вы ввели неверное значение! Ведите: 0-Январь...11-Декабрь");
        } else {
            for (int i = 1; i < monthToData[month].length; i++) {
                System.out.print(i + " День: " + monthToData[month][i] + ", "+ "\n");
                sumStep = sumStep + monthToData[month][i];
                if (monthToData[month][i] > maxStep) {
                    maxStep = monthToData[month][i];
                }
                middleStep = sumStep / monthToData[month].length;
                if (monthToData[month][i] >= ambitionStep) {
                    series++;
                    if (series > maxSeries) {
                        maxSeries = series;
                    }
                } else {
                    series = 0;
                }
            }
            System.out.println("Общее количество шагов за месяц: " + sumStep);
            System.out.println("Максимальное пройденное количество шагов в месяце: " + maxStep);
            System.out.println("Среднее количество шагов: " + middleStep);
            System.out.println("Пройденная дистанция (в км) " + converter.converterDistance(sumStep));
            System.out.println("Количество сожжённых килокалорий " + converter.converterKcal(sumStep));
            System.out.println("Лучшая серия: " + maxSeries);
        }
    }
}