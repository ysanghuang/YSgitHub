package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOSDemo {
    public static void main(String[] args) throws IOException {
        /*
         * 文件输出流创建出来，默认为覆盖模式，
         * 即:当操作的文件已经存在，那么在创建好文件输出
         * 流时会先将该文件所有数据清除。然后通过该流写出
         * 的所有数据作为文件数据。
         *
         * 文件流还支持重载构造方法，在第一个参数基础上
         * 可以再传入一个boolean类型的参数，当该值为true
         * 时，则是追加模式。
         * 即:文件原有数据全部保留，通过该流写出的数据会被
         * 追加到文件末尾。
         *
         */
        FileOutputStream fos
                = new FileOutputStream("fos.txt",true);

		String line = "";
        // String line = "只因为犯下天条被逐落人间，";
        byte[] data = line.getBytes("UTF-8");
        fos.write(data);

        line = "我才流浪世间.";
        data = line.getBytes("UTF-8");
        fos.write(data);

        System.out.println("写出完毕!");
        fos.close();

        write();
    }

    private static void write() throws IOException{
        FileInputStream fis
                = new FileInputStream("fos.txt");

        byte[] data = new byte[1024];
        int len = fis.read(data);

        String string = new String(data,0,len,"utf-8");
        System.out.println(string);
    }
}
