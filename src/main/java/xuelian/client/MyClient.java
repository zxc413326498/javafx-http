package xuelian.client;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class MyClient implements Runnable {

    String time;
    Button button;
    TextField message;

    public MyClient() {
        super();
    }

    public MyClient(String time, Button button, TextField message) {
        super();
        this.time=time;
        this.button=button;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            //初始化先进行socket连接
            Socket socket = new Socket("127.0.0.1", 9999);
            OutputStream out = socket.getOutputStream();
            PrintWriter pWriter = new PrintWriter(out);
            //绑定按钮点击事件，在用户输入数据并点击后获取时间+信息发送到服务端
            button.setOnAction(e->{
                pWriter.write(time+":" + message.getText() + "\r\n");
                pWriter.flush();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}