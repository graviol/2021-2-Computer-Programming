public class PrimeNumbers {
    public static void printPrimeNumbers(int m, int n) {
        for(int i=m;i<=n;i++){
            int j=2;
            if(i==2 || i==3){
                System.out.printf(i+" ");
            }
            while(j*j<=i){
                if(i%j==0){
                    break;
                }
                j++;
                if(j*j>i){
                    System.out.printf(i+" ");
                }
            }

        }
    }
}
