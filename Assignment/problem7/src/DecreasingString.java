public class DecreasingString {
    public static void printLongestDecreasingSubstringLength(String inputString) {
		int lenstr = inputString.length();
        int maxlen=1;
        int check=1;
        int diff_str[] = new int[lenstr];
        diff_str[0]=-1;
        for(int i=1;i<lenstr;i++){
            //if(i==0){diff_str[i]=-1;}
            diff_str[i]=inputString.charAt(i)-inputString.charAt(i-1);
            if(diff_str[i]<0){check++;}
            else{check=1;}
            if(maxlen<check){maxlen=check;}
        }

        System.out.println(maxlen);
    }
}
