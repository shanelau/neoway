package cn.jsr.cloud.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-31
 * Time: 下午4:28
 * To change this template use File | Settings | File Templates.
 */
public class FileService {
    public void writeToFile(String content,String filePath){
        File file = new File("d:\\aa.html");
        FileWriter resultFile = null;
        try {
            resultFile = new FileWriter(file);
            PrintWriter myFile = new PrintWriter(resultFile);
            myFile.println(content);
            myFile.close();
            resultFile.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
