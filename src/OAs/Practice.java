package OAs;

public class Practice {
    public static String solution(String S, int K){
        StringBuilder sol = new StringBuilder();
        int i;
        int j = 0;
        int k;
        StringBuilder temp = new StringBuilder();
        for ( k = 0; k < S.length();k++){
            if(!(S.charAt(k) == '-')){
                temp = temp.append(S.charAt(k));
            }
        }
        k = temp.length() % K;
        for (i = 0; i < temp.length(); i ++){
            if (i == k && k != 0){
                sol = sol.append('-');
                sol = sol.append(temp.charAt(i));
                j = 1;  //first one
            }else if(j != 0 && j % K == 0 && i != (temp.length()-1)){
                sol = sol.append('-');
                sol = sol.append(temp.charAt(i));
                j = 1;
            }else{
                sol = sol.append(temp.charAt(i));
                j++;
            }
        }
        return sol.toString().toUpperCase();

    }

    public static void main(String[] args){
        String temp = "2-4A0r7-4k";
        int K = 3;
        System.out.println(solution(temp,K));
    }

}

