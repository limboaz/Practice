package OAs;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int price = in.nextInt();
            int change = 1024 - price;
            int num = 0;
            num += change / 64;
            change = change % 64;
            num += change / 16;
            change = change % 16;
            num += change / 4;
            change = change % 4;
            num += change;
            System.out.println(num);

        }
    }
}
