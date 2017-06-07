package com.andrius.baltrunas;

import com.andrius.baltrunas.annotation.DoubleNum;
import com.andrius.baltrunas.example.FirstClass;
import com.andrius.baltrunas.example.SecondClass;
import com.andrius.baltrunas.example.ThirdClass;
import sun.reflect.generics.scope.MethodScope;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andriusbaltrunas on 6/6/2017.
 */
public class MyMainApp {
    public static void main(String[] args) {
        List<Class> clazz = new ArrayList<>();
        clazz.add(FirstClass.class);
        clazz.add(SecondClass.class);
        clazz.add(ThirdClass.class);

        for (Class c : clazz) {
            Method[] methods = c.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                int val = 0;
                try {
                    val = (int)methods[i].invoke(c.newInstance(), 10, 10);
                    if(isNeedTwiceSumNum(methods[i])){
                       val = calculateValue(methods[i], val);
                    }
                    System.out.println("val -> " + val + " class name -> " +c.getName());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                System.out.println();
            }
        }
    }

    private static int calculateValue(Method method, int val){
        DoubleNum annotation = method.getAnnotation(DoubleNum.class);
        if(annotation.number() > 0){
            val *=annotation.number();
        }
        return val;
    }

    private static boolean isNeedTwiceSumNum(Method method){
        return method.isAnnotationPresent(DoubleNum.class);
    }
}
