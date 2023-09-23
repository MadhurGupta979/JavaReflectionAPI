package com.dev;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Cat {
    private final String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void thisIsAPublicMethod(){
        System.out.println("MeWow :p");
    }

    private void thisIsAPrivateMethod(){
        System.out.println("How did You do all this ?");
    }

    public static void thisIsAPublicStaticMethod(){
        System.out.println("This is a public static method..");
    }

    private static void thisIsAPrivateStaticMethod(){
        System.out.println("This is a private static method..");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        // write your code here
        Cat myCat = new Cat("Stella", 6);
        Field[] fields  = myCat.getClass().getDeclaredFields();

        //Changing the value of Private final field
        for(Field f : fields){
            if(f.getName().equals("name")){
                f.setAccessible(true);
                f.set(myCat, "Ollie");
            }
        }

        System.out.println(myCat.getName());

        Method[] methods = myCat.getClass().getDeclaredMethods();

        for(Method m : methods){
            if(m.getName().equals("thisIsAPrivateStaticMethod")) {
                m.setAccessible(true);
                m.invoke(null);
            }
        }

    }
}
