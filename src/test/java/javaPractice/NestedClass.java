package javaPractice;

class A {
    int age;

    public  void show() {
        System.out.println("In show");
    }

    class B {
        public void config() {
            System.out.println("In config");
        }
    }
}

public class NestedClass {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();

        // how to call the class B
        A.B obj1 = obj.new B();
        obj1.config();
    }
}