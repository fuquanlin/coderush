package cn.fql.coderush.base;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by fuquanlin on 19/11/2016.
 */
public class SystemInTest {
    public static void main(String[] args) throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String s = null;
        while (!(s = bufferedReader.readLine()).equals("exit")) {
            System.out.println(s);
        }
        System.out.println("End");
    }
}
