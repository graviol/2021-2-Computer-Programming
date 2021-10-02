public class DrawingFigure {
    public static void drawFigure(int n) {
        for(int i=1;i<=n;i++){
            System.out.println("  ".repeat(n+1-i)+"* ".repeat(2*i-2)+"*"+"  ".repeat(n+1-i));
        }

        System.out.printf("* ".repeat(2*n));
        System.out.println("*");


        for(int i=n;i>0;i--){
            System.out.println("  ".repeat(n+1-i)+"* ".repeat(2*i-2)+"*"+"  ".repeat(n+1-i));
        }
    }
}
