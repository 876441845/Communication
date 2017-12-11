package com.cnty.auto.net;

import com.cnty.auto.pojo.Rail;
import com.cnty.auto.service.RailService;
import com.cnty.auto.utils.SpringContextUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: poker face
 * @date: 2017/11/28 0028 9:16
 * @since: JDK1.8.0_31
 * @version: X
 * Description:
 */
@Slf4j
public class Server {
    private ServerSocket serverSocket = null;

    /**
     * 线程池
     * 弃用: private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
     */
    private ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("pool-%d").build();
    private ExecutorService threadPool = new ThreadPoolExecutor(5,200,0L,
            TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(1024),threadFactory,new ThreadPoolExecutor.AbortPolicy());

    /**
     * 构造方法
     */
    public Server() {
        try {
            int port = 8001;
            serverSocket = new ServerSocket(port);
            log.info("服务器已启动..." + serverSocket);
            System.out.println("服务器已启动..." + serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动，侦听客户端 v2afr
     */
    public void start() {
        //noinspection InfiniteLoopStatement
        while (true) {
            Socket socket;
            try {
                socket = serverSocket.accept();
                log.info("新客户端: " + socket + "[已连接]");
                System.out.println("有新的客户端连接进来," + socket);
                // 将输入、输出交给线程处理
                threadPool.execute(new ServerThread(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Server().start();
    }
}
