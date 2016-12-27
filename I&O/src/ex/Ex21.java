package ex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by belows on 2016/12/22.
 */
public class Ex21 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("/Users/belows/IdeaProjects/thinking_in_java/I&O/src/ex/Ex21.java"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line.toUpperCase());
        }
    }
}
