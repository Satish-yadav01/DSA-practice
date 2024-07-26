package lld.elevator.data;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class ExternalButton implements Button{

    @Override
    public void pressButton() {
        System.out.println("External Press button");
    }
}
