package OAs;

import java.util.Scanner;

public class Rope {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] ropes = new int[n];
        int sum = 0;
        int min = 0;
        for(int i = 0; i < n; i++){
            ropes[i] = in.nextInt();
            sum += ropes[i];
        }
        min = ropes[0];
        for(int i = 1; i < n; i++){
            if(ropes[i] < ropes[i+1])
                min = ropes[i];
        }   //find min
        if(n > m){
            System.out.println(min);
            return;
        }else{
            int high = sum / m;
            int low = 0;
            while(low != m) {
                for (int i = 1; i < n; i++) {
                    low += ropes[i] / min;  //lowerbound
                }
                int diff = (sum - low * m) / m;
                min -= diff;
            }
            System.out.println(min);
        }
    }
}
