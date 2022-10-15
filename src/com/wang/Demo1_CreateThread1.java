package com.wang;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Demo1_CreateThread1 implements Runnable{
    private String url;//网络图片地址
    private String name;//报错扥文件名

    //有参构造
    public Demo1_CreateThread1(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为:" + name);
    }

    public static void main(String[] args) {
        Demo1_CreateThread1 t = new Demo1_CreateThread1("https://img-home.csdnimg.cn/images/20201124032511.png", "1.png");
        Demo1_CreateThread1 t1 = new Demo1_CreateThread1("https://img-home.csdnimg.cn/images/20201124032511.png", "2.png");
        Demo1_CreateThread1 t2 = new Demo1_CreateThread1("https://img-home.csdnimg.cn/images/20201124032511.png", "3.png");
       new Thread( t).start();
       new Thread( t1).start();
       new Thread( t2).start();




    }


    //下载器
    class WebDownloader {
        //下载方法
        public void downloader(String url, String name) {
            try {
                FileUtils.copyURLToFile(new URL(url), new File(name));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO异常,downloader方法出现问题");
            }
        }
    }
}
