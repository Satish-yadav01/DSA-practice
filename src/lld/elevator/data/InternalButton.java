package lld.elevator.data;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class InternalButton implements Button{
    @Override
    public void pressButton() {
        System.out.println("Inside pressButton");
    }
}
