import java.util.*;
public class Crypto {
    public static void main(String[] args)
    {   System.out.print("Enter a string : ");
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        String newN = normalText(n);
        System.out.print("Enter the shift amount: ");
        int key = input.nextInt();
        String caesaredN = caesarify(newN , key);
        System.out.print("Enter the number of letters per group :");
        int letters = input.nextInt();
        String encryptedString = groupify(caesaredN,letters);
        System.out.println(encryptedString);
    }
    public static String normalText(String n)
    {
        n = n.replace(" ","");
        n = n.replaceAll("[\\!\\?\\.\\,\\:\\;\'\\(\\)\"]","");
        n = n.toUpperCase();
        return n;
    }
    public static String caesarify(String n,int shift)
    {
        String newResult = shiftAlphabet(shift);
        String Result = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < n.length();i++) {
            char temp = n.charAt(i);
            int indexOfLetter = Result.indexOf(temp);
            char charInNewResult = newResult.charAt(indexOfLetter);
            n = n.replace(temp, charInNewResult);
        }
        return n;
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }
    public static String groupify(String n, int letters )
    {
        while (n.length()%letters != 0){
            n += 'x';
        }
        int stringLength = n.length();
        String result = "";
        int start = 0;
        for(int j = 0; j < ((stringLength/letters)-1); j++)
        {
            int end = start + letters;
            result = result +  n.substring(start,end) + " ";
            start = start + letters ;

        }
        result = result + n.substring(stringLength-letters,stringLength);
        return result;
    }
}
