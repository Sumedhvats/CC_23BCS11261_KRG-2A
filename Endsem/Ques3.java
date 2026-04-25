import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Ques3 {
   static int[] lpsArray(String pattern) {
      int n = pattern.length();
      int[] lps = new int[n];
      int len = 0;
      int i = 1;

      while (i < n) {
         if (pattern.charAt(i) == pattern.charAt(len)) {
            len++;
            lps[i] = len;
            i++;
         } else {
            if (len != 0) {
               len = lps[len - 1];
            } else {
               lps[i] = 0;
               i++;
            }
         }
      }

      return lps;
   }

   static List<Integer> kmpSearch(String text, String pattern) {
      List<Integer> result = new ArrayList<>();

      if (pattern.length() == 0) {
         for (int i = 0; i <= text.length(); i++) {
            result.add(i);
         }
         return result;
      }

      int[] lps = lpsArray(pattern);
      int i = 0;
      int j = 0;

      while (i < text.length()) {
         if (text.charAt(i) == pattern.charAt(j)) {
            i++;
            j++;
         }

         if (j == pattern.length()) {
            result.add(i - j);
            j = lps[j - 1];
         } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
            if (j != 0) {
               j = lps[j - 1];
            } else {
               i++;
            }
         }
      }

      return result;
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String text = sc.nextLine();
      String pattern = sc.nextLine();

      List<Integer> matches = kmpSearch(text, pattern);

      if (matches.isEmpty()) {
         System.out.println(-1);
      } else {
         for (int idx : matches) {
            System.out.print(idx + " ");
         }
         System.out.println();
      }

      sc.close();
   }
}
