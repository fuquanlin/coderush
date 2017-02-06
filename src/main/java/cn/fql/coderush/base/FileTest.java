package cn.fql.coderush.base;

import java.io.*;

/**
 * Created by fuquanlin on 19/11/2016.
 */
public class FileTest {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/fuquanlin/IdeaProjects/coderush/test.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("aaaa");
        bufferedWriter.newLine();

        bufferedWriter.write("bbbb");
        bufferedWriter.newLine();

        bufferedWriter.write("cccc");
        bufferedWriter.newLine();

        bufferedWriter.write("dddd");
        bufferedWriter.newLine();

        bufferedWriter.write("eeee");
        bufferedWriter.newLine();

        bufferedWriter.flush();
        //FileInputStream inputStream = new FileInputStream(file);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = null;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }
        ;

    }
}
