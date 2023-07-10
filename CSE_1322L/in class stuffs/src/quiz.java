abstract class A {
    public int do_stuff1() {
        return 3;
    }

    public abstract int do_stuff2();
}

class B extends A {
    @Override
    public int do_stuff1() {
        return 4;
    }
    @Override
    public int do_stuff2() {
        return 7;
    }
}

class Main {
    public static void main(String[] args) {
        B myB = new B();
        myB.do_stuff1();
        myB.do_stuff2();
    }
}