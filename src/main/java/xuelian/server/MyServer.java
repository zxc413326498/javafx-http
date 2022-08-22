package xuelian.server;

import javafx.scene.control.TextArea;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer implements Runnable {

    //Server端监听的端口号
    public static final int PORT = 9999;

    TextArea message;

    public MyServer() {

    }

    public MyServer(TextArea message) {
        super();
        this.message = message;
    }

    @Override
    public void run() {
        ServerSocket server;
        Socket socket;
        try {
            server = new ServerSocket(PORT);
            while(true) {
                System.out.println("MyServer.run" + "----启动" );
                socket = server.accept();
                System.out.println("MyServer.run" + "----接收到客户端连接" );
                //一个客户端接入就启动一个handler线程去处理
                new Thread(new Handler(message, socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}