import java.util.Arrays;

public class MatrixMultiply
{

    public static void matrixMultiply(int[]p,int n)
    {

        int [][] m = new int[n][n];
        int [][] s = new int[n][n];

        int i, j, k, L, q;


        for (i = 1; i < n; i++)
            m[i][i] = 0;


        for (L=2; L<n; L++)
        {
            for (i=1; i<n-L+1; i++)
            {
                j = i+L-1;
                if(j == n) continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k=i; k<=j-1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                    int x= k+1;
                    int y= i-1;
                    System.out.println("M["+i+"]["+j+"]=M["+i+"]["+k+"]+M["+x+"]["+j+"]+p["+y+"]*p["+k+"]*p["+j+"]="+q);
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        System.out.println("Array M");
        printArrayK(m);
        System.out.println("Array S");
        printArrayK(s);
    }
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

    public static void main(String[] args) {

        int p[] = new int[]{6,4,3,3,2};
        System.out.println("Array P: "+ Arrays.toString(p));
        matrixMultiply(p,p.length);
    }
}
