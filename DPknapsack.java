import javax.swing.*;
import java.util.Arrays;

public class DPknapsack {

    public static void printArrayK(int K[][])
    {
        for (int i=0; i< K.length;i++)
        {
            System.out.print("n= "+i+"[");
            for (int j=0; j<K[i].length; j++)
            {
                System.out.print(K[i][j]+", ");
            }
            System.out.print("]\n");
        }
    }

    static void knapsack(int Weight, int Weight_items[], int profit[], int n)
    {
        int [] P = new int[Weight+1];
        for (int k = 0; k<Weight; k++) {
        P[k]=0;
        }
        for (int i=n; i>=1; i--)
        {
            for (int k=Weight; k>=Weight_items[i-1];k--)
            {
                if (P[k-Weight_items[i-1]]+profit[i-1]>P[k])
                {
                    P[k]=P[k-Weight_items[i-1]] + profit[i-1];
                }
            }
            System.out.println("i="+i);
            System.out.println(Arrays.toString(P));
        }
    }

    public static void main(String[] args) {
        int profit[] = new int[]{40,40,25,30,50};
        int Weight_items[] = new int[]{2,6,2,4,5};
        int weight = 9;
        int n = profit.length;

        System.out.println("Capacity: "+weight);
        System.out.println("Weight: "+Arrays.toString(Weight_items));
        System.out.println("Profit: "+Arrays.toString(profit));
        knapsack(weight,Weight_items,profit,n);
        //DPSC(weight,Weight_items,profit,n);
    }
}
