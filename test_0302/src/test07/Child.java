package test07;

/**
 * Created by Juhee on 3/2/16.
 */
public class Child extends Parent {
    int child;

    Child(int child, String a, String b) {
        super(a);
        this.child=child;
       this.b = b;
        this.a =a;
        // this.a = a;
        //this.b = b;

    }
      void printfun(){System.out.println("here is child " + this.child + " "+this.a+" " +b);
    }
    @Override
    void printSound(){
        System.out.println("Ddd");
    }
    void fun1(){
        System.out.println("test2");
       // super.fun1();
    }
}
