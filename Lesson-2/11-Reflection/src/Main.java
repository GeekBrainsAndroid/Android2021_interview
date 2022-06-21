import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> fooClass = Class.forName("Foo");
        Constructor<?>[] constructors = fooClass.getConstructors();
        Method[] methods = fooClass.getDeclaredMethods();
        Method methodGetBoo = methods[0];
        Field[] fields = fooClass.getDeclaredFields();
        Field fieldBoo = fields[0];

        Object foo = constructors[0].newInstance();
        fieldBoo.setAccessible(true);
        fieldBoo.set(foo, 42);
        Object valueBoo = fieldBoo.get(foo);
        System.out.println(valueBoo);
        methodGetBoo.setAccessible(true);
        Object valueGetBoo = methodGetBoo.invoke(foo);
        System.out.println(valueGetBoo);
    }
}
