package ex;

import book.BinaryFile;
import book.Directory;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by belows on 2016/12/22.
 */
//CAFEBABE
public class Ex20 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String dir = scanner.nextLine();
            Directory.TreeInfo info = Directory.walk(dir,".*\\.class");
            for (File file : info.files) {
                display(file);
//                System.out.println(file.getAbsolutePath());
            }
        }
//        while (scanner.hasNextByte()) {
//            byte b = scanner.nextByte();
//            System.out.println(Integer.toBinaryString(b & (byte) 0b10000000));
//        }
    }

    private static void display(File file) throws IOException {
        byte[] bytes = BinaryFile.read(file);
//        bToStr(bytes,0,4);
       System.out.println(binaryString2hexString(bToStr(bytes,0,4)));
    }

    private static String bToStr(byte[] bytes,int start, int offset) {
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<offset; ++i) {
            byte b = bytes[start + i];
            int k = 0x00000080;
            for (int j=0; j<8; ++j) {
                builder.append((k&b)!=0?'1':'0');
                k = (byte) (k>>1);
                Integer.toBinaryString(b);
            }
        }

        return builder.toString();
    }

    public static String binaryString2hexString(String bString)
    {
        if (bString == null || bString.equals("") || bString.length() % 8 != 0)
            return null;
        StringBuffer tmp = new StringBuffer();
        int iTmp = 0;
        for (int i = 0; i < bString.length(); i += 4)
        {
            iTmp = 0;
            for (int j = 0; j < 4; j++)
            {
                iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);
            }
            tmp.append(Integer.toHexString(iTmp));
        }
        return tmp.toString();
    }
}
