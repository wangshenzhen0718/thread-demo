package com.wang;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class Demo1_CreateThread2 implements Callable<Boolean> {
    private String url;//网络图片地址
    private String name;//报错扥文件名

    //有参构造
    public Demo1_CreateThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为:" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo1_CreateThread2 t = new Demo1_CreateThread2("https://img-home.csdnimg.cn/images/20201124032511.png", "1.png");
        Demo1_CreateThread2 t1 = new Demo1_CreateThread2("https://img-home.csdnimg.cn/images/20201124032511.png", "2.png");
        Demo1_CreateThread2 t2 = new Demo1_CreateThread2("https://img-home.csdnimg.cn/images/20201124032511.png", "3.png");
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Boolean> submit = executorService.submit(t);
        Future<Boolean> submit1 = executorService.submit(t1);
        Future<Boolean> submit2 = executorService.submit(t2);
        System.out.println(submit.get());
        System.out.println(submit1.get());
        System.out.println(submit2.get());
        executorService.shutdown();


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
