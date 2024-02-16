import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main1 {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {

        System.out.println("enter your first word : ");
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        toHashMap(word);
    }

    //----------------------------------------------------------------------------------------------------------------------
    public static void toHashMap(String word) {

        HashMap<Character, Integer> character = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            character.put(letter, character.getOrDefault(letter, 0) + 1);
        }
        StringBuilder word1 = new StringBuilder(word);
        ArrayList<String> perm = new ArrayList<>();

        int fact = 1;
        for (int i = word1.length(); i >= 1; i--) {
            fact *= i;
        }

        for (int i = 0; i < word1.length(); i++) {

            int repetition = 1;
            int count = 0;
            for (int j = 0; j < word1.length(); j++) {
                if (i != j) {
                    if (word1.charAt(i) == word1.charAt(j)) {
                        count++;
                        word1.deleteCharAt(j);
                    }
                }
            }

            if (count > 0) {

                for (int k = count+1; k >= 1; k--) {
                    repetition *= k;
                }
                fact = fact / repetition;
            }
        }

        toPermutation(character, "", word.length(), perm, fact);
    }

    //----------------------------------------------------------------------------------------------------------------------
    public static void toPermutation(HashMap<Character, Integer> character, String empty
            , int counter, ArrayList<String> perm, int fact) {

        if (counter == 0) {
            System.out.println(empty);
            perm.add(empty);
            if (perm.size() == fact) checkWord(perm);
            return;
        }

        for (char letter : character.keySet()) {

            int count = character.get(letter);
            if (count > 0) {
                character.put(letter, count - 1);
//                System.out.println(ANSI_YELLOW + character + ANSI_RESET);
//                System.out.println(ANSI_RED + empty + ANSI_RESET);
                toPermutation(character, empty + letter, counter - 1, perm, fact);
                character.put(letter, count);
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------
    public static void checkWord(ArrayList<String> perm) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_BLUE + "1-add check word");
        System.out.println("2-exit" + ANSI_RESET);

        int num = scanner.nextInt();
        switch (num) {
            case 1 -> {
                System.out.println("enter check word : ");
                String word = scanner.next();
                if (perm.contains(word)) System.out.println("pass");
                else System.out.println("fail");
            }
            case 2 -> System.out.println(ANSI_BLUE + "by by" + ANSI_RESET);
        }
    }

}