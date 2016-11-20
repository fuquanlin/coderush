package cn.fql.coderush.pattern;

/**
 * Created by fuquanlin on 19/11/2016.
 */
public class Factory {

    Animal create(String name) {
        if ("tiger".equals(name)) {
            return new Tiger();
        } else if ("rabbit".equals(name)) {
            return new Rabbit();
        }   else{
            return null;
        }
    }
}
