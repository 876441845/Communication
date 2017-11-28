package com.cnty.auto.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: poker face
 * @date: 2017/11/28 0028 9:16
 * @since: JDK1.8.0_31
 * @version: X
 * Description:
 */
public class Server {
    private ServerSocket serverSocket = null;

    /**
     * 线程池
     */
    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    /**
     * 构造方法
     */
    Server() {
        try {
            int port = 8001;
            serverSocket = new ServerSocket(port);
            System.out.println("服务器已启动..." + serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动，侦听客户端 v2afr
     */
    private void start() {
        while (true) {
            Socket socket;
            try {
                socket = serverSocket.accept();
                System.out.println("有新的客户端连接进来," + socket);
                // 将输入、输出交给线程处理
                cachedThreadPool.execute(new ServerThread(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server().start();
    }
}
