package ex;

import java.io.*;

/**
 * Created by belows on 2016/12/24.
 */
public class Ex27 {

    private static class T1 implements Serializable {
        T2 t2;
        int ii;
        public T1(T2 t2, int i) {
            ii = i;
            this.t2 = t2;
        }

        @Override
        public String toString() {
            return "t1.ii = " + ii +"," + t2.toString();
        }
    }

    private static class T2 implements Serializable {
        int kk = 0;
        public T2(int k) {
            kk = k;
        }

        @Override
        public String toString() {
            return "t2.kk =" + kk;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/belows/IdeaProjects/thinking_in_java/I&O/src/ex/11.txt"));
        out.writeObject(new T1(new T2(33),44));
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/belows/IdeaProjects/thinking_in_java/I&O/src/ex/11.txt"));
        System.out.println(in.readObject());
    }
}
