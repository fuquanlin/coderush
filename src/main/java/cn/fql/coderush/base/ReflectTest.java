package cn.fql.coderush.base;

import java.lang.reflect.Method;

/**
 * Created by fuquanlin on 19/11/2016.
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        Class<?> aClass = Class.forName("cn.fql.coderush.pattern.Singleton");
        Method getInstance = aClass.getDeclaredMethod("getInstance");
        getInstance.invoke(null) ;

        Class<?> bClass = Class.forName("cn.fql.coderush.base.Test");
        //inner class can not get new instance
        Object newInstance = bClass.newInstance();
        Method say = bClass.getDeclaredMethod("say",String.class);
        say.invoke(newInstance,"hello world!");
    }

    public class MyTest{

        public MyTest(){

        }


        public void print(){
            System.out.println("print");
        }

        public void say(String msg){
            System.out.println(msg);
        }
    }
}
