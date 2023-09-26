import java.util.Scanner;

public class Main {
    static char[] inp=new char[10];
    static char sign;

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение:");
        Scanner sc=new Scanner(System.in);
        String scan=sc.nextLine();
        for (int i=0;i<scan.length();i++){
            inp[i]=scan.charAt(i);
            if (inp[i]=='+') sign='+';
            if (inp[i]=='-') sign='-';
            if (inp[i]=='*') sign='*';
            if (inp[i]=='/') sign='/';
        }
        System.out.println(calc(scan));
    }
    public static String calc(String Input) throws Exception {
        int result=0; int var1=0; int var2=0;
        String number1; String number2;
        String[] roman={"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        boolean flag=false;
        String str=String.valueOf(inp);
    String[] splitString=str.split("[+-/*]");
        if (splitString.length==2){
            String num1=splitString[0];
            String num2=splitString[1];
             number1=num1.trim();
             number2=num2.trim();}
        else throw new Exception("Не удовлетворяет условиям");
        for (int i=0;i<roman.length;i++) {
            if (roman[i].equals(number1) || roman[i].equals(number2)) {
                flag=true;
            }
            
        }

        if (flag){
            var1=romanToNumber(number1);
            var2=romanToNumber(number2);
        }else {
        var1=Integer.parseInt(number1);
        var2=Integer.parseInt(number2);}

        if (var1>10||var2>10) {
        throw new Exception("Не удовлетворяет условиям");
    }else {
        switch (sign) {
            case '+': result = var1 + var2;break;
            case '-': result = var1 - var2;break;
            case '*': result = var1 * var2;break;
            case '/':
                if (var2!=0){
                result = var1 / var2;}
                else throw new Exception("На ноль делить нельзя");
                break;
        }
    }
        String res;
        if(flag){
            if (result>0){
             res=convertNumToRoman(result);} else throw new Exception("Не удовлетворяет условиям");
        }else {
            res=Integer.toString(result);
        }
        return res;
    }
    public static String convertNumToRoman ( int numArabian){
        String[] roman1 = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman1[numArabian];
        return s;
    }
    public static int romanToNumber (String roman)
    {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
            return 0;
        }

}