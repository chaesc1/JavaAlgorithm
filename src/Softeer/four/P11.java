package Softeer.four;

public class P11 {
    static class A {
        public void m() {
            System.out.print("A");
        }
    }

    static class B extends A {
        public void m() {
            System.out.print("B");
        }
    }

    static class C extends B {
        public void m() {
            System.out.print("C");
        }
    }

    static class D extends C {
        public void m() {
            System.out.print("D");
        }
    }

    public static class Main {
        public static void main(String[] args) {
            D d = new D();
            C c = d;
            B b = c;
            A a = b;

            d.m(); // D 클래스의 m() 메서드 호출
            c.m(); // 실제 타입은 D이므로 D 클래스의 m() 메서드 호출
            b.m(); // 실제 타입은 D이므로 D 클래스의 m() 메서드 호출
            a.m(); // 실제 타입은 D이므로 D 클래스의 m() 메서드 호출
        }
    }
}
