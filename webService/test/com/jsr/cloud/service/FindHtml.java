package com.jsr.cloud.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo
 * Date: 13-10-31
 * Time: 下午12:34
 * To change this template use File | Settings | File Templates.
 */
public class FindHtml {
    private static String getStaticPage(String surl) {
        String htmlContent = "";
        try {
            java.io.InputStream inputStream;
            java.net.URL url = new java.net.URL(surl);
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
            connection.connect();
            inputStream = connection.getInputStream();
            byte bytes[] = new byte[1024 * 2000];
            int index = 0;
            int count = inputStream.read(bytes, index, 1024 * 2000);
            while (count != -1) {
                index += count;
                count = inputStream.read(bytes, index, 1);
            }
            htmlContent = new String(bytes, "UTF-8");
            connection.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return htmlContent.trim();
    }

    public static void main(String[] args) {
        String url = "http://58.60.184.211:8888/weatherService_war/";
        String url1 = url + "data/sk/101010300";
        String url2 = url + "data/101010300";

        String url3 = url + "getWeather?cityCode=101010300&simple=true&userId=ak2";
        String src = getStaticPage(url1);
        System.out.println(src);
    }

    public void saveToFile(String src) {
        File file = new File("d:\\aa.html");
        FileWriter resultFile = null;
        try {
            resultFile = new FileWriter(file);
            PrintWriter myFile = new PrintWriter(resultFile);
            myFile.println(src);

            myFile.close();
            resultFile.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
