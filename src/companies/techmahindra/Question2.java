package companies.techmahindra;

import java.util.Optional;

public class Question2 {

    public static Optional<String> getName(String name){
        String name1 = null;
        return Optional.ofNullable(name1);
    }

    public static void main(String[] args) throws Exception {
        String str = "tech mahindra";
        Optional<String> str1 = Optional.ofNullable(str);
        if(str1.isPresent()){
            System.out.println(str1.get());
            System.out.println(str1.orElse("No value"));

        }

        System.out.println(getName("satish").orElseThrow(()->new ResourceException("new exception")));
    }
}
