public class NumberCounter {
    public static void countNumbers(String str0, String str1, String str2) {
		int numCount[] = new int[10];
        int intstr0 = Integer.parseInt(str0);
        int intstr1 = Integer.parseInt(str1);
        int intstr2 = Integer.parseInt(str2);

        int prod = intstr0*intstr1*intstr2;
        String str_prod = String.valueOf(prod);
        int lenstr = str_prod.length();

        for(int i=0;i<lenstr;i++){
            char elem = str_prod.charAt(i);
            numCount[elem-48]++;
        }

        for(int i=0;i<10;i++){
            if(numCount[i]>0){
                printNumberCount(i,numCount[i]);
            }
        }

        System.out.println("length: "+lenstr);
    }

    private static void printNumberCount(int number, int count) {
        System.out.printf("%d: %d times\n", number, count);
    }
}
