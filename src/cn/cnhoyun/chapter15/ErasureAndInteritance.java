package cn.cnhoyun.chapter15;// generics/ErasureAndInheritance.java

class GenericBase<T> {
    private T element;

    public void set(T arg) {
        element = arg;
    }

    public T get() {
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {
}

class Derived2 extends GenericBase {
} // No warning

// class Derived3 extends GenericBase<?> {}
// Strange error:
// unexpected type
// required: class or interface without bounds
public class ErasureAndInteritance {
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        System.out.println(obj);
        // Warning here!
        d2.set(obj);

        System.out.println("=== ===");

        Derived1<String> stringDerived1 = new Derived1<>();
        stringDerived1.set("s");
        String s = stringDerived1.get();
        System.out.println(s);

    }
}
