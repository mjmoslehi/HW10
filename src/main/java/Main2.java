import java.util.Random;
import java.util.TreeSet;

public class Main2 {

    public static void main(String[] args) {

        TreeSet<Character> strings = new TreeSet<>();
        TreeSet<Character> strings1 = new TreeSet<>();

        generateRandomString(strings, strings1);

        sum(strings, strings1);

        subscription(strings, strings1);

    }

    public static void generateRandomString(TreeSet<Character> strings, TreeSet<Character> strings1) {

        String chars = "qwertyuioplkjhgfdsazxcvbnm";
        Random rnd = new Random();

        for (int i = 0; ; i++) {
            strings.add(chars.charAt(rnd.nextInt(26)));
            if (strings.size() == 10) break;
        }
        System.out.println(strings);

        for (int i = 0; ; i++) {
            strings1.add(chars.charAt(rnd.nextInt(26)));
            if (strings1.size() == 10) break;
        }
        System.out.println(strings1);
    }

    public static void sum(TreeSet<Character> strings, TreeSet<Character> strings1) {
        String ss = strings.toString();
        String s1 = strings1.toString();
        System.out.println("the sum : ");
        System.out.println(ss+s1);
    }

    public static void subscription(TreeSet<Character> strings, TreeSet<Character> strings1) {

       TreeSet<Character> sub = new TreeSet<>();
       sub.addAll(strings);
       sub.addAll(strings1);
        System.out.println("the subscription : ");
        System.out.println(sub);

    }
}
