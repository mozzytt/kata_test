import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] allowedNumbersArabic = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] allowedNumbersRoman = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] allowedOperations = new String[]{"*", "/", "+", "-"};
        String[] resultRoman = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        byte[] bool = new byte[]{-1, -1, -1};
        Scanner scanner = new Scanner(System.in);
        String strMain = scanner.nextLine();
        System.in.close();
        String[] strMainSubStringsArray = strMain.split(" ");
        if(strMainSubStringsArray.length==3) {
            for (int i = 0; i < 11; i++) {
                if (strMainSubStringsArray[0].equals(allowedNumbersArabic[i])) {
                    bool[0] = 0;
                    break;
                }
            }
            for (int i = 0; i < 10; i++) {
                if (strMainSubStringsArray[0].equals(allowedNumbersRoman[i])) {
                    bool[0] = 1;
                    break;
                }
            }
            for (int i = 0; i < 4; i++) {
                if (strMainSubStringsArray[1].equals(allowedOperations[i])) {
                    bool[1] = 0;
                    break;
                }
            }
            for (int i = 0; i < 11; i++) {
                if (strMainSubStringsArray[2].equals(allowedNumbersArabic[i])) {
                    bool[2] = 0;
                    break;
                }
            }
            for (int i = 0; i < 10; i++) {
                if (strMainSubStringsArray[2].equals(allowedNumbersRoman[i])) {
                    bool[2] = 1;
                    break;
                }
            }
        }
        if (strMainSubStringsArray.length > 3) {
            throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (strMainSubStringsArray.length < 3) {
            throw new Exception("throws Exception //т.к. строка не является математической операцией");
        } else if (((bool[0] == 0) & (bool[2] == 1)) | ((bool[0] == 1) & (bool[2] == 0))) {
            throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления");
        }
        if ((bool[0]==0) & (bool[1]==0) & (bool[2]==0)) {
            switch (strMainSubStringsArray[1]){
                case "+":
                    System.out.println(Integer.parseInt(strMainSubStringsArray[0])+Integer.parseInt(strMainSubStringsArray[2]));break;
                case "-":
                    System.out.println(Integer.parseInt(strMainSubStringsArray[0])-Integer.parseInt(strMainSubStringsArray[2]));break;
                case "*":
                    System.out.println(Integer.parseInt(strMainSubStringsArray[0])*Integer.parseInt(strMainSubStringsArray[2]));break;
                case "/":
                    if (Integer.parseInt(strMainSubStringsArray[2])==0){throw new Exception("throws Exception //Деление на ноль");}
                    System.out.println(Integer.parseInt(strMainSubStringsArray[0])/Integer.parseInt(strMainSubStringsArray[2]));break;
            }
        };
        if ((bool[0]==1) & (bool[1]==0) & (bool[2]==1)) {
            int aInt = 0;
            int bInt = 0;
            int resultInt = 0;
            for (int i = 0; i<10; i++){
                if (strMainSubStringsArray[0].equals(allowedNumbersRoman[i])){
                    aInt = Integer.parseInt(allowedNumbersArabic[i+1]);
                    break;
                }
            }
            for (int i = 0; i<10; i++){
                if (strMainSubStringsArray[2].equals(allowedNumbersRoman[i])){
                    bInt = Integer.parseInt(allowedNumbersArabic[i+1]);
                    break;
                }
            }
            switch (strMainSubStringsArray[1]){
                case "+":
                    resultInt=aInt+bInt;
                    System.out.println(resultRoman[resultInt-1]);
                    break;
                case "-":
                    resultInt=aInt-bInt;
                    if (resultInt<=0){throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");}
                    System.out.println(resultRoman[resultInt-1]);
                    break;
                case "*":
                    resultInt=aInt*bInt;
                    System.out.println(resultRoman[resultInt-1]);
                    break;
                case "/":
                    resultInt=aInt/bInt;
                    if (bInt==0){throw new Exception("throws Exception //Деление на ноль");}
                    System.out.println(resultRoman[resultInt-1]);
                    break;
            }
        };
        if (((bool[0]==1) & (bool[1]==0) & (bool[2]==1)) | ((bool[0]==0) & (bool[1]==0) & (bool[2]==0))){

        } else {
            throw new Exception("throws Exception //строка выходит за рамки задания");
        }
    }
}