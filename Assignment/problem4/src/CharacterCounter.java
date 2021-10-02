public class CharacterCounter {
    public static void countCharacter(String str) {
		int lowerAlp[] = new int[26];
        int upperAlp[] = new int[26];
        int lenstr = str.length();

        for(int i=0;i<lenstr;i++){
            char elem = str.charAt(i);
            if(97<=elem && elem<=122) {lowerAlp[elem-97]++;}
            else if(65<=elem && elem<=90) {upperAlp[elem-65]++;}
        }

        for(int i=0;i<26;i++){
            if(lowerAlp[i]>0 && upperAlp[i]==0){
                printCount((char) (i+97),lowerAlp[i]);
                System.out.println("");
            }
            else if(lowerAlp[i]==0 && upperAlp[i]>0){
                printCount((char) (i+65),upperAlp[i]);
                System.out.println("");
            }
            else if(lowerAlp[i]>0 && upperAlp[i]>0){
                printCount((char) (i+65),upperAlp[i]);
                System.out.printf(", ");
                printCount((char) (i+97),lowerAlp[i]);
                System.out.println("");
            }
        }
    }

    private static void printCount(char character, int count) {
        System.out.printf("%c: %d times", character, count);
    }
}
