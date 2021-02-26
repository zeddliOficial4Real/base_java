package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author zedd
 * @date 2021/2/23
 **/
public class FileReader {

    //C:\Users\powersi\Desktop
    static void readFile(String path) throws IOException {
//        path.split()
        if (Files.exists(Paths.get(path))) {
            List<String> txt = Files.readAllLines(Paths.get(path));
            System.out.println(txt);
        } else throw new FileNotFoundException("===文件未找到===");
    }

    public static void main(String[] args) throws IOException {
        FileReader.readFile("C:\\Users\\powersi\\Desktop\\文本.txt");
    }
}
