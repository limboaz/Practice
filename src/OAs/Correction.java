package OAs;

import java.util.Scanner;

public class Correction {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        String[] print = new String[num];
        for(int i = 0; i < num; i++){   //read each string
            String cur = in.nextLine();
            for(int j = 1; j < cur.length()-1; j++){
                //fix the first case
                if(cur.charAt(j-1) == cur.charAt(j) && cur.charAt(j) == cur.charAt(j + 1)){   //start getting suspicious
                    int next = j+1;
                    while(cur.charAt(next) == cur.charAt(j))
                        next++;
                    cur = cur.substring(0, j+1).concat(cur.substring(next));
                }
            }
            for(int j = 1; j < cur.length();j++){
                if(j < cur.length()-2 && cur.charAt(j-1)== cur.charAt(j)&&cur.charAt(j+1)== cur.charAt(j+2)){
                    cur = cur.substring(0, j+1).concat(cur.substring(j+2));
                }
            }
            print[i] = cur;
        }
        for(int i = 0; i < num; i++){
            System.out.println(print[i]);
        }
    }
}
