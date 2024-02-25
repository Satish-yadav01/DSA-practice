package interviewBasics.string;


//Question1 : find true if string content vowels
public class Question1 {
    public static void main(String[] args) {
        String s1= "satish";
        System.out.println(s1.toLowerCase().matches(".*[aeiou].*"));
    }
}
