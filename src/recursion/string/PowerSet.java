package recursion.string;

public class PowerSet {
    public static void main(String[] args) {
        String s = "abc";
        String cur = "";
        powerset(s,0, cur);
    }

    private static void powerset(String s, int i, String cur) {
        if(i==s.length()){
            System.out.println(cur);
            return;
        }

        powerset(s,i+1,cur+s.charAt(i));
        powerset(s,i+1,cur);
    }

}
