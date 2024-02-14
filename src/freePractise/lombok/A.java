package freePractise.lombok;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class A {
    protected int x;
    protected int y;
}

@AllArgsConstructor
class B extends A {
}

class Main {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A(10, 20);

        A b1 = new B();
    }
}