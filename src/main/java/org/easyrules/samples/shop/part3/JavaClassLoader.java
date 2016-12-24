package org.easyrules.samples.shop.part3;

import org.easyrules.samples.shop.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author ashraf
 *
 */
 public  class JavaClassLoader extends ClassLoader {

    public Object invokeClassMethod(String classBinName, String methodName,Person person){

        try {

            // Create a new JavaClassLoader
            ClassLoader classLoader = this.getClass().getClassLoader();

            // Load the target class using its binary name
            Class loadedMyClass = classLoader.loadClass(classBinName);

            System.out.println("Loaded class name: " + loadedMyClass.getName());

            // Create a new instance from the loaded class
            Constructor constructor = loadedMyClass.getConstructor(Person.class);
            Object myClassObject = constructor.newInstance(person);

            // Getting the target method from the loaded class and invoke it using its name
            Method method = loadedMyClass.getMethod(methodName);
            System.out.println("Invoked method name: " + method.getName());
            method.invoke(myClassObject);

            return myClassObject;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
