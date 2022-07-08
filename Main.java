import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String... args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws IOException {
        String[] strings = input.split(" ");
        if (strings.length > 3){
            throw new IOException();
        }
        String firstNumber = strings[0];
        String action = strings[1];
        String secondNumber = strings[2];
        String[] romanianNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabianNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] arabianMeanings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "20", "21", "24", "25", "28", "30", "32", "35", "36", "40", "42", "45", "48",
                "50", "54", "56", "60", "63", "64", "70", "72", "80", "81", "90", "100", "49"};
        String[] romanianMeanings = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
                "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXIV", "XXV", "XXVIII", "XXX",
                "XXXII", "XXXV", "XXXVI", "XL", "XLII", "XLV", "XLVIII", "L", "LIV", "LVI", "LX", "LXIII", "LXIV",
                "LXX", "LXXII", "LXXX", "LXXXI", "XC", "C", "XLIX"};
        boolean bool = true;
        for (int i = 0; i <= 9; i++) {
            if (firstNumber.equals(romanianNumbers[i]) && bool) {
                for (int u = 0; u <= 9; u++) {
                    if (secondNumber.equals(romanianNumbers[u])) {
                        firstNumber = arabianNumbers[i];
                        secondNumber = arabianNumbers[u];
                        int fn = Integer.valueOf(firstNumber);
                        int sn = Integer.valueOf(secondNumber);
                        int niceNumber = 0;
                        if (action.equals("+") && bool) {
                            niceNumber = fn + sn;
                            String finalNumber = String.valueOf(niceNumber);
                            for (int y = 0; y <= 44; y++) {
                                if (finalNumber.equals(arabianMeanings[y])) {
                                    return romanianMeanings[y];
                                }
                            }
                        } else if (action.equals("-") && bool) {
                            niceNumber = fn - sn;
                            String finalNumber = String.valueOf(niceNumber);
                            for (int y = 0; y <= 44; y++) {
                                if (finalNumber.equals(arabianMeanings[y])) {
                                    return romanianMeanings[y];
                                }
                            }
                        } else if (action.equals("*") && bool) {
                            niceNumber = fn * sn;
                            String finalNumber = String.valueOf(niceNumber);
                            for (int y = 0; y <= 44; y++) {
                                if (finalNumber.equals(arabianMeanings[y])) {
                                    return romanianMeanings[y];
                                }
                            }
                        } else if (action.equals("/") && bool) {
                            double meaning = (fn / sn);
                            int finalMeaning = (int) meaning;
                            String finalNumber = String.valueOf(finalMeaning);
                            for (int y = 0; y <= 44; y++) {
                                if (finalNumber.equals(arabianMeanings[y])) {
                                    return romanianMeanings[y];
                                }
                            }
                        }
                    }
                }
            } else if (firstNumber.equals(arabianNumbers[i]) && bool) {
                for (int u = 0; u <= 9; u++) {
                    if (secondNumber.equals(arabianNumbers[u]) && bool) {
                        int fn = Integer.valueOf(firstNumber);
                        int sn = Integer.valueOf(secondNumber);
                        if (action.equals("+")) {
                            return String.valueOf(fn + sn);
                        } else if (action.equals("-")) {
                            return String.valueOf(fn - sn);
                        } else if (action.equals("*")) {
                            return String.valueOf(fn * sn);
                        } else if (action.equals("/") && bool){
                            double meaning = (fn / sn);
                            int finalMeaning = (int) meaning;
                            return String.valueOf(finalMeaning);
                        }
                    }
                }
            }
        }
    throw new IOException();
    }
}












