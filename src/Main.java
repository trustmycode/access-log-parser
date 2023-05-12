import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите первое число: ");
        int numFirst = new Scanner(System.in).nextInt();
        System.out.print("Введите второе число: ");
        int numSecond = new Scanner(System.in).nextInt();
        System.out.println("Сумма чисел равна: " + (numFirst + numSecond));
        System.out.println("Разность чисел равна: " + (numFirst - numSecond));
        System.out.println("Произведение чисел равно: " + (numFirst * numSecond));
        System.out.println("Частное чисел равно: " + ((double)numFirst / (double)numSecond));
    }
}