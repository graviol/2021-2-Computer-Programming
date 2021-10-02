import java.util.stream.IntStream;

public class FibonacciNumbers {
    public static void printFibonacciNumbers(int n) {
        int arr[] = new int[40];

        for(int i=0;i<n;i++){
            if(i==0){
                arr[i]=0;
                if(n==1){System.out.printf("%d\n",arr[i]);}
                else{System.out.printf("%d ",arr[i]);}
            }
            else if(i==1){
                arr[i]=1;
                if(n==2){System.out.printf("%d\n",arr[i]);}
                else{System.out.printf("%d ",arr[i]);}
            }
            else{
                arr[i]=arr[i-1]+arr[i-2];
                if(i<n-1) {System.out.printf("%d ",arr[i]);}
                else {System.out.printf("%d\n",arr[i]);}
            }
        }

        int sum = IntStream.of(arr).sum();
        if(sum<100000){
            System.out.print("sum = "+sum);
        }
        // Only when n=33 this situation occurs.
        else if(sum>=100000 && sum%100000<10000){
            System.out.print("last five digits of sum = 0"+sum%100000);
        }
        // Actually it doesn't happen. (0<=sum%100000<1000)
        else if(sum>=100000 && sum%100000<1000){
            System.out.print("last five digits of sum = 00"+sum%100000);
        }
        else if(sum>=100000 && sum%100000<100){
            System.out.print("last five digits of sum = 000"+sum%100000);
        }
        else if(sum>=100000 && sum%100000<10){
            System.out.print("last five digits of sum = 0000"+sum%100000);
        }
        else if(sum>=100000 && sum%100000==0){
            System.out.print("last five digits of sum = 00000");
        }
        else{
            System.out.print("last five digits of sum = "+sum%100000);
        }
    }
}
