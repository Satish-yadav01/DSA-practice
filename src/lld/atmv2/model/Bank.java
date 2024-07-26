package lld.atmv2.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Satish Yadav
 * @purpose :
 */
public class Bank {
    private String bankName;
    private Map<User,UserDetail> details;

    public Bank(String bankName) {
        this.bankName = bankName;
        details = new HashMap<>();
    }
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Map<User, UserDetail> getDetails() {
        return details;
    }

    public void setUserDetailByUser(User user, UserDetail userDetail) {
//        if(!details.containsKey(user)){
//            details.put(user, userDetail);
//        }
        details.put(user, userDetail);
    }
}
