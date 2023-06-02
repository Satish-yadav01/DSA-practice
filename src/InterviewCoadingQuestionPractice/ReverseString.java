package InterviewCoadingQuestionPractice;

// 1. from array
// 2. String buffer and string Builder
// 3. iterative approach
// 4. recursion

public class ReverseString {
    public static void main(String[] args) {
        String s= "satish";
        String s1 = reverseFromArray(s);
        System.out.println(s1);

        System.out.println(reverseFromRecursion(s));

    }

    private static String reverseFromRecursion(String s) {
        if(s.length() ==0) return " ";

        return s.charAt(s.length()-1) + reverseFromRecursion(s.substring(0,s.length()-1));
    }

    private static String reverseFromArray(String s) {
        char[] array = s.toCharArray();
//        StringBuilder temp = new StringBuilder("");
        String temp = "";
        for (int i = array.length-1; i >=0; i--) {
//            temp.append(array[i]);
            temp += array[i];
//            System.out.println(tem
//            p);
        }
//        System.out.println(temp.toString());
        return temp;
    }
}
