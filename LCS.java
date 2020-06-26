import java.util.Arrays;

public class LCS
{
    public static void printArrayK(int K[][])
    {
        for (int i=0; i< K.length;i++)
        {
            System.out.print("i= "+i+"[");
            for (int j=0; j<K[i].length; j++)
            {
                System.out.print(K[i][j]+", ");
            }
            System.out.print("]\n");
        }
    }
    public static void printArrayKK(String K[][])
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

    static void lcs( char[] X, char[] Y, int m, int n )
    {
        int L[][] = new int[m+1][n+1];
        String B[][] = new String[m+1][n+1];

        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                }
                else if (X[i-1] == Y[j-1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                    B[i][j] = "/";
                }
                else
                {
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
                    B[i][j] ="^";
                }
            }
        }
        System.out.println("Array C");
        printArrayK(L);
        System.out.println("Array B");
        printArrayKK(B);
    }
    static int max(int a, int b)
    {
        return (a > b)? a : b;
    }

    public static void LCS(char [] X, char [] Y)
    {
        int m= X.length;
        int n= Y.length;
        int [][] c= new int[m+1][n+1];
        String [][] b= new String[m+1][n+1];

        for (int i=0; i<m;i++)
        {
            c[i][0]=0;
        }
        for (int j=0; j<n; j++)
        {
            c[0][j]=0;
        }

        for (int i=1; i<=m; i++)
        {
            for (int j=1; j<=n; j++)
            {
                if (X[i-1]==Y[j-1])
                {
                    c[i][j]= c[i-1][j-1]+1;
                    b[i][j]="/";
                }
                else if (c[i-1][j]>=c[i][j-1])
                {
                    c[i][j] = c[i-1][j];
                    b[i][j]="^";
                }
                else
                {
                    c[i][j]=c[i][j-1];
                    b[i][j]="<";
                }

            }
        }

        System.out.println("Array C");
        printArrayK(c);
        System.out.println("Array B");
        printArrayKK(b);
    }
    public static void main(String[] args) {
        String s1="ABCBDAB";
        String s2="BDCABA";

        char [] X= s1.toCharArray();
        char [] Y= s2.toCharArray();

        lcs(X,Y,X.length,Y.length);

        LCS(X,Y);

    }
}
