package learn;

import java.io.*;
import java.net.URL;
import java.nio.channels.FileChannel;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/29
 */
public class MyIO {

    public static void main(String[] args) throws IOException {
//        File file = new File("/Users/mayuan/Downloads");
//        listAllFiles(file);

//        String src = "./LICENSE";
//        String dst1 = "./out/test1";
//        String dst2 = "./out/test2";
//        copyFileUsingStream(src, dst1);
//        System.out.println("copyFileUsingStream OK!");
//        copyFileUsingChannel(src, dst2);
//        System.out.println("copyFileUsingChannel OK!");

//        readFileContent("./LICENSE");

        testURL("https://www.baidu.com");
    }

    public static void testURL(String link) throws IOException {
        URL url = new URL(link);
        // 字节流
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(url.openStream(), "UTF-8"));
        String line = null;
        while (null != (line = bufferedReader.readLine())) {
            System.out.println(line);
        }
        bufferedReader.close();
    }

    public static void readFileContent(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line = null;
        while (null != (line = bufferedReader.readLine())) {
            System.out.println(line);
        }
        // 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
        // 在调用 BufferedReader 的 close() 方法时会去调用 fileReader 的 close() 方法
        // 因此只要一个 close() 调用即可
        bufferedReader.close();
    }

    public static void listAllFiles(File dir) {
        if (null == dir || !dir.exists()) {
            return;
        }

        if (dir.isFile()) {
            System.out.println("文件->" + dir.getName());
            return;
        } else {
            for (File f : dir.listFiles()) {
                listAllFiles(f);
            }
        }
    }

    public static void copyFileUsingStream(String src, String dst) throws IOException {
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dst);

            int length = 0;
            byte[] buffer = new byte[1024];
            while (-1 != (length = in.read(buffer))) {
                out.write(buffer, 0, length);
            }
        } finally {
            if (null != in) {
                in.close();
            }
            if (null != out) {
                out.close();
            }
        }
    }

    public static void copyFileUsingChannel(String src, String dst) throws IOException {
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;

        try {
            sourceChannel = new FileInputStream(src).getChannel();
            destinationChannel = new FileOutputStream(dst).getChannel();
            destinationChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } finally {
            if (null != sourceChannel) {
                sourceChannel.close();
            }
            if (null != destinationChannel) {
                destinationChannel.close();
            }
        }
    }
}
