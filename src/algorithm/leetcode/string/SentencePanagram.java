package algorithm.leetcode.string;
/*

A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.



Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
Example 2:

Input: sentence = "leetcode"
Output: false


Constraints:

1 <= sentence.length <= 1000
sentence consists of lowercase English letters.

 */


public class SentencePanagram {
    public static void main(String[] args) {
        boolean checkedIfPangram = checkIfPangram("thequickbrownfoxjumpsoverthelazydog");

//        System.out.println(checkedIfPangram);
        int number = 123324;
        StringBuilder sbr = new StringBuilder();
        sbr.append(number);

        System.out.println(sbr.toString().charAt(0));

        System.out.println(String.valueOf(number));
    }

    public static boolean checkIfPangram(String sentence) {
        return sentence.matches("[a-z]");
    }
}
