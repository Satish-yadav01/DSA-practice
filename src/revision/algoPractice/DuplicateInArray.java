package revision.algoPractice;

import java.util.HashSet;

public class DuplicateInArray{
    public static void main(String[] args) {
        String []s = {"satish","java","c","c++"};
        boolean duplicate = isDuplicate(s);
        System.out.println(duplicate);
    }

    private static boolean isDuplicate(String[] s) {
        HashSet<String> set = new HashSet<>();
        for (String e : s){
            if(!set.add(e)){
                return true;
            }
        }
        return false;
    }

}
