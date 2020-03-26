package com.atguigu.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Bio 服务器针对客户端的每个请求都会创建一个线程,去read 业务处理,写
 * 当并发较大时,需要创建大量的线程来处理请求连接,资源消耗较大.
 * 建立连接后没有数据进行读取,线程就会阻塞在read上,造成线程资源浪费..
 */
public class BioServer {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("服务器启动了");

            while (true) {
                //监听,等待客户端连接
                System.out.println("等待连接.....");
                final Socket acceptSocket = serverSocket.accept();
                System.out.println("连接到一个客户端");
                //开启一个线程
                executorService.execute(new Runnable() {
                    public void run() {
                        System.out.println("当前线程是: " + Thread.currentThread().getId() + " 线程名字是: " + Thread.currentThread().getName());
                        //可以和客户端通讯.
                        handlerInfo(acceptSocket);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static  void handlerInfo(Socket acceptSocket) {
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = acceptSocket.getInputStream();
            while (true) {
                //读取数据放到bytes数组里面.
                System.out.println("reading.....");
                int read = inputStream.read(bytes);
                //打印读取到的数据,注意要判断读取的内容不能为空
                if (read != -1) {
                    System.out.println("当前线程是: " + Thread.currentThread().getId() + " 线程名字是: " + Thread.currentThread().getName());
                    System.out.println(new String(bytes,0,read));
                }else{
                    //读取不到内容就不处理
                    System.out.println("读取不到内容");
                    break;
                }
                System.out.println("一次信息读取结束");
            }

        } catch (IOException e) {
            e.printStackTrace();
            try {
                acceptSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
