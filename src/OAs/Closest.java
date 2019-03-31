package OAs;

public class Closest {
    public static int[] solution(int[] stores, int[] houses){
        //iterate through the houses, and find the closest store, put its index to the result array.
        int[] result = new int[houses.length];
        int i, j;
        int distance;
        int closest;
        int cindex = 0;     //the index of the closest store
        for ( i = 0; i < houses.length; i++){
            closest = Math.abs(stores[0] - houses[i]);
            for (j = 0; j < stores.length; j++){
                distance = Math.abs(stores[j] - houses[i]);     //current store's distance
                if (distance < closest){
                    closest = distance;     //update the current shortest distance
                    cindex = j;     //record the closest index
                }
            }
            //After iteration, store the closest index into result array.
            result[i] = stores[cindex];
            cindex = 0;
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr1 = {1,5,20,11,16};
        int[] arr2 = {5,10,17};
        int[] res = solution(arr1, arr2);
        int i;
        for (i = 0; i < res.length; i++){
            System.out.println(res[i] + " ");
        }
    }
}
