import java.util.Scanner;

public class NumberSystemConverter {

    // Decimal to Binary
    static String toBinary(int n) {
        if (n == 0) return "0";
        StringBuilder r = new StringBuilder();
        int num = Math.abs(n);
        while (num > 0) { r.insert(0, num % 2); num /= 2; }
        return (n < 0 ? "-" : "") + r;
    }

    // Decimal to Octal
    static String toOctal(int n) {
        if (n == 0) return "0";
        StringBuilder r = new StringBuilder();
        int num = Math.abs(n);
        while (num > 0) { r.insert(0, num % 8); num /= 8; }
        return (n < 0 ? "-" : "") + r;
    }

    // Decimal to Hexadecimal
    static String toHex(int n) {
        if (n == 0) return "0";
        char[] h = "0123456789ABCDEF".toCharArray();
        StringBuilder r = new StringBuilder();
        int num = Math.abs(n);
        while (num > 0) { r.insert(0, h[num % 16]); num /= 16; }
        return (n < 0 ? "-" : "") + r;
    }

    // Binary to Decimal
    static int fromBinary(String s) {
        int r = 0, p = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != '0' && c != '1') throw new IllegalArgumentException("Invalid binary digit: " + c);
            r += (c - '0') * (int) Math.pow(2, p++);
        }
        return r;
    }

    // Octal to Decimal
    static int fromOctal(String s) {
        int r = 0, p = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int d = s.charAt(i) - '0';
            if (d < 0 || d > 7) throw new IllegalArgumentException("Invalid octal digit: " + s.charAt(i));
            r += d * (int) Math.pow(8, p++);
        }
        return r;
    }

    // Hexadecimal to Decimal
    static int fromHex(String s) {
        int r = 0, p = 0;
        s = s.toUpperCase();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int d;
            if (c >= '0' && c <= '9') d = c - '0';
            else if (c >= 'A' && c <= 'F') d = c - 'A' + 10;
            else throw new IllegalArgumentException("Invalid hex digit: " + c);
            r += d * (int) Math.pow(16, p++);
        }
        return r;
    }

    // Show all conversions from a decimal value
    static void showAll(int dec) {
        System.out.println("  Decimal     :  " + dec);
        System.out.println("  Binary      :  " + toBinary(dec));
        System.out.println("  Octal       :  " + toOctal(dec));
        System.out.println("  Hexadecimal :  " + toHex(dec));
    }

    // Demo table
    static void runDemo() {
        System.out.println("═".repeat(55));
        System.out.println("  DEMO CONVERSION TABLE");
        System.out.println("═".repeat(55));
        System.out.printf("  %-10s %-15s %-10s %-12s%n", "Decimal", "Binary", "Octal", "Hexadecimal");
        System.out.println("─".repeat(55));
        int[] s = {0, 1, 2, 7, 8, 10, 15, 16, 31, 32, 63, 64, 100, 127, 128, 255, 256, 512, 1000, 4096};
        for (int n : s)
            System.out.printf("  %-10d %-15s %-10s %-12s%n", n, toBinary(n), toOctal(n), toHex(n));
        System.out.println("═".repeat(55));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("═".repeat(55));
            System.out.println("      NUMBER SYSTEM CONVERTER");
            System.out.println("═".repeat(55));
            System.out.println("  [1]  Decimal      -> Binary, Octal, Hex");
            System.out.println("  [2]  Binary       -> Decimal, Octal, Hex");
            System.out.println("  [3]  Octal        -> Decimal, Binary, Hex");
            System.out.println("  [4]  Hexadecimal  -> Decimal, Binary, Octal");
            System.out.println("  [5]  Run all demo conversions");
            System.out.println("  [0]  Exit");
            System.out.println("─".repeat(55));
            System.out.print("  Choose option: ");

            while (!sc.hasNextInt()) { System.out.print("  Invalid. Enter a number: "); sc.next(); }
            choice = sc.nextInt();
            System.out.println();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("  Enter a Decimal number: ");
                        int dec = sc.nextInt();
                        System.out.println("─".repeat(55));
                        System.out.println("  Converting " + dec + " from Decimal:");
                        System.out.println("─".repeat(55));
                        showAll(dec);
                        System.out.println("─".repeat(55));
                        break;

                    case 2:
                        System.out.print("  Enter a Binary number (e.g. 1101): ");
                        String bin = sc.next();
                        System.out.println("─".repeat(55));
                        System.out.println("  Converting " + bin + " from Binary:");
                        System.out.println("─".repeat(55));
                        showAll(fromBinary(bin));
                        System.out.println("─".repeat(55));
                        break;

                    case 3:
                        System.out.print("  Enter an Octal number (e.g. 17): ");
                        String oct = sc.next();
                        System.out.println("─".repeat(55));
                        System.out.println("  Converting " + oct + " from Octal:");
                        System.out.println("─".repeat(55));
                        showAll(fromOctal(oct));
                        System.out.println("─".repeat(55));
                        break;

                    case 4:
                        System.out.print("  Enter a Hexadecimal number (e.g. 1F): ");
                        String hex = sc.next();
                        System.out.println("─".repeat(55));
                        System.out.println("  Converting " + hex.toUpperCase() + " from Hexadecimal:");
                        System.out.println("─".repeat(55));
                        showAll(fromHex(hex));
                        System.out.println("─".repeat(55));
                        break;

                    case 5:
                        runDemo();
                        break;

                    case 0:
                        System.out.println("  Goodbye!");
                        System.out.println("═".repeat(55));
                        break;

                    default:
                        System.out.println("  Invalid option. Please choose 0-5.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("  ERROR: " + e.getMessage());
                System.out.println("─".repeat(55));
            } catch (Exception e) {
                System.out.println("  ERROR: Invalid input.");
                System.out.println("─".repeat(55));
            }

            System.out.println();

        } while (choice != 0);

        sc.close();
    }
}