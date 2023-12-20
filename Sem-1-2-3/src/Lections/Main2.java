package Lections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
      Class<?>car = Class.forName("Lections.Car2");
        Constructor<?>[] constructors = car.getConstructors();
        Object gaz = constructors[0].newInstance("Gaz");
        System.out.println(gaz);

        Field[]fields = gaz.getClass().getFields();
        int temp = fields[fields.length - 1].getInt(gaz);
        fields[fields.length-1].setInt(gaz,temp *=2);
        System.out.println(gaz);

        Method[] methods = gaz.getClass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }

//        Lections.Car2 a = new Lections.Car2("BMW");
//        System.out.println(a.name);
    }
}
