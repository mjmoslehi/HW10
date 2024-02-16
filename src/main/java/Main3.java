import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("how many numbers do you want to add :");
        int num = scanner.nextInt();

        for (int i = 0; i < num; i++) {

            System.out.println("number : " + i);
            int number = scanner.nextInt();
            numbers.add(number);
        }

        check(numbers);

        System.out.println(numbers);

    }

    public static void check(ArrayList<Integer> numbers) {

        if (numbers.size() % 2 != 0) {
            numbers.remove(numbers.size() - 1);
        }

        for (int i = 0; i < numbers.size() ; i += 2) {

            if (numbers.get(i) < numbers.get(i + 1) && i > 0) {
                numbers.remove(i);
                numbers.remove(i);
                i -= 2;
            } else if (numbers.get(i) < numbers.get(i + 1) && i == 0) {
                numbers.remove(i);
                numbers.remove(i);
                i = -2;
            }

        }

    }

}
