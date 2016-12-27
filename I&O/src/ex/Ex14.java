package ex;

import book.BufferedInputFile;
import ex.test.Test;
import ex.test.TestParam;
import ex.test.Tester;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by belows on 2016/12/21.
 */
public class Ex14 {

    private static final String RFILE = "/Users/belows/IdeaProjects/thinking_in_java/I&O/src/ex/11.txt";
    private static final String WFILE = "/Users/belows/IdeaProjects/thinking_in_java/I&O/src/ex/22.txt";

    public static void main(String[] args) throws IOException {
        List<Test<PrintWriter>> tests = new ArrayList<>();
        String content = BufferedInputFile.read(RFILE);
        tests.add(new Test<PrintWriter>("normal") {
            @Override
            public int run(PrintWriter writer, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    try {
                        writer = new PrintWriter(new FileWriter(WFILE));
                        write(writer,content);
                        writer.close();
                    } catch (Exception e) {
                    }
                }

                return param.loops;
            }
        });
         Tester<PrintWriter> tester = new Tester<PrintWriter>(PrintWriter.class,tests);
        tester.setInitContainer(new Tester.InitContainer<PrintWriter>() {
            @Override
            public PrintWriter init(TestParam param) {
                return null;
            }
        });
        tester.run();


        tests.clear();
        tests.add(new Test<PrintWriter>("buffer") {
            @Override
            public int run(PrintWriter writer, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    try {
                        writer = new PrintWriter(new BufferedWriter(new FileWriter(WFILE)));
                        write(writer,content);
                        writer.close();
                    } catch (Exception e) {
                    }
                }

                return param.loops;
            }
        });
        tester = new Tester<PrintWriter>(PrintWriter.class,tests);
        tester.setInitContainer(new Tester.InitContainer<PrintWriter>() {
            @Override
            public PrintWriter init(TestParam param) {
                return null;
            }
        });
        tester.run();
    }

    private static void write(PrintWriter writer,String content) {
        writer.write(content);
    }
}
