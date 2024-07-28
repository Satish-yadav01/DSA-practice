package lld.atmv2.atmstate;

import lld.atmv2.model.Atm;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class IdleState extends AtmState{

    @Override
    public void insertCard(Atm atm) {
        System.out.println("Card is Inserted");
        atm.setAtmState(new HashCardState());
    }
}
