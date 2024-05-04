package algorithm.leetcode.string;

/**
 * @author : Satish Yadav  | satishyadav.ssy02@gmail.com
 * @problem   1903. Largest Odd Number in String
 *
 * @apiNote   :You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * example :
 * Input: num = "52"
 * Output: "5"
 * Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
 * Example 2:
 *
 * Input: num = "4206"
 * Output: ""
 * Explanation: There are no odd numbers in "4206".
 * Example 3:
 *
 * Input: num = "35427"
 * Output: "35427"
 * Explanation: "35427" is already an odd number.
 *
 *
 * @Note : for big String this solution will not work just like for this "239537672423884969653287101"
 *
 * so for that new solution is there largestOddNumber2() instead
 */
public class LargestOddNumberInString {
    public static void main(String[] args) {
//        String s = largestOddNumber("239537672423884969653287101");
        String s = largestOddNumber2("52");
        System.out.println("s : "+s);
    }

    private static String largestOddNumber2(String number) {
        StringBuilder num = new StringBuilder(number);

        while (num.length() !=0 ){
            if(((num.charAt(num.length()-1) - '0') & 1) !=0){
                return num.substring(0, num.length()).toString();
            }
            num.deleteCharAt(num.length()-1);
        }
        return "";
    }

    private static String largestOddNumber(String num) {
        long largestOdd=0, odd=0;
        long number = Long.parseLong(num);

        while(number != 0){

            if((number & 1) !=0){
                return Long.toString(number);
            }

            long mod = number % 10;
            if((mod & 1) !=0){
                odd= mod;
            }
            number = number/10;
            if(largestOdd < odd){
                largestOdd = odd;
            }
        }

        if (largestOdd ==0) return "";

        return Long.toString(largestOdd);
    }


}
