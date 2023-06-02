package InterviewCoadingQuestionPractice;

import java.util.HashSet;
import java.util.Set;

public class DuplicateInArray {
    public static void main(String[] args) {
        String[] sArray = {"c","java","c++","ASP","c"};
        Set <String> set = new HashSet<>();
        boolean isDuplicate = false;

        for (int i = 0; i < sArray.length; i++) {
            if(!set.add(sArray[i])){
                isDuplicate = true;
                break;
            }
        }

        if (isDuplicate){
            System.out.println("Duplicate found");
        }else {
            System.out.println("not found");
        }
    }
}
