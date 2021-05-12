public class ClassA {
    ClassA classA = new ClassA();

    public void print(){
        System.out.println(String.format("Hello, GeekBrains! %d", show()));
    }

    private int show(){
        return true ? null : 0;
    }
}
