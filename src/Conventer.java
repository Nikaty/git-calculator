import java.util.List;
import java.util.Scanner;

public class Conventer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;
        String operation;

        String value = scanner.next();
        operation = scanner.next();
        String value2 = scanner.next();
        try
        {
            a = Integer.parseInt(value);
            b = Integer.parseInt(value2);
            if (a > 10 || b > 10)
            {
                throw new Exception();
            }
            System.out.println(getResult(a, b, operation));
        } catch (Exception e)
        {
            a = romanToArabic(value);
            b = romanToArabic(value2);
            if (a > 10 || b > 10)
            {
                throw new IllegalArgumentException();
            }
            System.out.println(arabicToRomain(getResult(a, b, operation)));
        }

    }
    private static int getResult(int a, int b, String operation) {
        if (operation.equals("+")) {
            return a + b;
        } else if (operation.equals("-")) {
            return a - b;
        } else if (operation.equals("*")) {
            return a * b;
        } else if (operation.equals("/")) {
            return a / b;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public  static int romanToArabic(String input) {
        String romanNumber = input.toUpperCase();
        int res = 0;

        List romanNumbers = RomanNumbers.getListSortedOfValues();

        int i = 0;

        while ((romanNumber.length() > 0) && (i < romanNumbers.size()))
        {
            RomanNumbers symbol = (RomanNumbers) romanNumbers.get(i);
            if (romanNumber.startsWith(symbol.name()))
            {
                res += symbol.getValue();
                romanNumber = romanNumber.substring(symbol.name().length());
            }
            else
            {
                i++;
            }
        }
        if (romanNumber.length() > 0)
        {
            throw new IllegalArgumentException();
        }
        return res;
    }
    public static String arabicToRomain(int number) {
        if ((number <= 0) || (number > 4000))
        {
            throw new IllegalArgumentException();
        }

        List romanNumbers = RomanNumbers.getListSortedOfValues();

        int i = 0;

        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumbers.size()))
        {
            RomanNumbers currentSymbol = (RomanNumbers) romanNumbers.get(i);
            if (currentSymbol.getValue() <= number)
            {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            }
            else
            {
                i++;
            }
        }
        return sb.toString();
    }
}
