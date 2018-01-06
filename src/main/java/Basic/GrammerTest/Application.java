package Basic.GrammerTest;

public class Application {
    public static void main(String[] args){
        String a = new String("hello");
        String b = a.intern();
        System.out.println(a == b);
    }

    public static void testStringPass(){
        String a = "hello", b = "world";
        System.out.println(a + " : " + b);
        Change(a, b);
        System.out.println(a + " : " + b);
        StringBuffer ab = new StringBuffer("hello");
        StringBuffer bb = new StringBuffer("world");
        System.out.println(ab + " : " + bb);
        Change(ab,bb);
        System.out.println(ab + " : " + bb);
    }

    public static void Change(String a, String b){
        a = b;
        b = a + b;
    }
    public static void Change(StringBuffer a, StringBuffer b){
        a = b;
        b = b.append(a);
    }
}
