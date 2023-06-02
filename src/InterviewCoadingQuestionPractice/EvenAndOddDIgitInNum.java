package InterviewCoadingQuestionPractice;

public class EvenAndOddDIgitInNum {
    public static void main(String[] args) {
        int num = 12345611;
        int evenCount = 0;
        int oddCount = 0;

        while(num !=0){
            int digit = num % 10;
            if(digit%2==0){
                evenCount++;
            }else {
                oddCount++;
            }
            num/=10;
        }

        System.out.println("evenCount:" + evenCount + "\noddcount:"+oddCount);
    }
}
