import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a: ");
            double a = getValidInput(scanner);

            System.out.print("Enter b: ");
            double b = getValidInput(scanner);

            System.out.print("Enter c: ");
            double c = getValidInput(scanner);

            checkTriangle(a, b, c);
        } catch (Exception e) {
            System.out.println("Ошибка ввода или треугольник не существует");
        }
    }

    static double getValidInput(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();

            if (input.matches("-?\\d+")) {
                double value = Double.parseDouble(input);

                if (value < 0 || value > Double.MAX_VALUE) {
                    System.out.println("Число слишком велико или отрицательное. Попробуйте снова.");
                    continue;
                }

                return value;
            } else {
                System.out.println("Введите целое число. Попробуйте снова.");
            }
        }
    }

    static void checkTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Треугольник не существует");
            return;
        }

        String triangleType = getTriangleType(a, b, c);
        System.out.println(triangleType);
    }

    static String getTriangleType(double a, double b, double c) {
        if (a == b && b == c) {
            return "Равносторонний треугольник";
        }
        if (a == b || b == c || a == c) {
            return "Равнобедренный треугольник";
        }
        return "Разносторонний треугольник";
    }
}

