package my.learn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/29
 */
public class MyNIO {

    public static void main(String[] args) throws IOException {
        String src = "./LICENSE";
        String dst1 = "./out/nio1";
        fastFileCopy(src, dst1);
    }

    public static void fastFileCopy(String src, String dst) throws IOException {
        FileChannel fcin = null;
        FileChannel fcout = null;
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        try {
            fcin = new FileInputStream(src).getChannel();
            fcout = new FileOutputStream(dst).getChannel();

            while (-1 != fcin.read(buffer)) {
                // 读写模式切换
                buffer.flip();
                // 把缓冲区的内容写入输出文件中
                fcout.write(buffer);
                // 清空缓冲区
                buffer.clear();
            }
        } finally {
            if (null != fcin) {
                fcin.close();
            }
            if (null != fcout) {
                fcout.close();
            }
        }
    }
}
