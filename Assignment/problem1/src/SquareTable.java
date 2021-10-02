public class SquareTable {
    public static void printSquareTable(int n) {
        int i=1;
        while(Math.pow(i,2)<=n){
            printOneSquare(i,(int) Math.pow(i,2));
            i++;
        }
    }

    private static void printOneSquare(int a, int b) {
        System.out.printf("%d times %d = %d\n", a, a, b);
    }
}
