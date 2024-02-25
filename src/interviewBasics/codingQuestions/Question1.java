package interviewBasics.codingQuestions;


//how to delete element from an array from kth position
public class Question1 {
    public int[] deleteElement(int []a,int k){
        int temp[] = new int[a.length-1];
        int index=0;
        for (int i = 0; i <= a.length-1; i++) {
            if(i==k){
                continue;
            }
            temp[index] = a[i];
            index++;
        }
        return temp;
    }

    public static void main(String[] args) {
        int array[] = {1,2,3,4,5,6,7,8};
        int k=2;

        Question1 obj = new Question1();
        int[] element = obj.deleteElement(array, k);
        for (int i = 0; i <=element.length-1; i++) {
            System.out.print(element[i]+" ");

        }
    }
}
