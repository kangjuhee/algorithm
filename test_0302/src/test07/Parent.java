package test07;

/**
 * Created by Juhee on 3/2/16.
 */
public abstract class Parent {
    private String a;
    String b;


    Parent(String a) {
        this.a = a;
    }
    abstract void printSound();
}
