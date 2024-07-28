package lld.elevator.data;

import lld.elevator.constant.Constant;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Door {
    private String doorStatus = Constant.CLOSED;

    public void openDoor(){
        if(doorStatus.equals(Constant.CLOSED)){
            doorStatus = Constant.OPEN;
            System.out.println("Door is open");
        }
        try{
            Thread.sleep(2000);  //2sec
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeDoor(){
        if(doorStatus.equals(Constant.OPEN)){
            doorStatus = Constant.CLOSED;
            System.out.println("Door is closed");
        }
    }
}
