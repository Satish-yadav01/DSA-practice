package interviewBasics.interfaces;

@FunctionalInterface
interface A{
    public void show();
}

//class B implements A{
//
//    @Override
//    public void show() {
//        System.out.println("demo");
//    }
//}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
//        B b = new B();
//        b.show();

        //using anonymous class
//        A obj = new A(){
//            @Override
//            public void show() {
//                System.out.println("demo");
//            }
//        };
//
//        obj.show();

        //using lambda expression
        A obj = ()-> System.out.println("webomates");
        obj.show();
    }
}
