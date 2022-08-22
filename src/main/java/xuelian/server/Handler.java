package xuelian.server;

import javafx.scene.control.TextArea;
import xuelian.util.DialogUtil;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Handler implements Runnable {

    Socket socket;
    TextArea message;

    public Handler() {
        super();
    }

    public Handler(TextArea message, Socket socket) {
        super();
        this.message = message;
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(in));
            //OutputStream out = socket.getOutputStream();
            //PrintWriter pWriter = new PrintWriter(out);
            //pWriter数据打印、发送数据等其它事项

            //收消息
            String msg;
            message.appendText("msg:"+"\n");

            while (true) {
                msg = bReader.readLine();
                message.appendText(msg+"\n");
                System.out.println("Handler.run" + "----msg值= " + msg);
                //调用微服务接口处理http事务
                if("接口测试".equals(msg)){
                    //显示弹窗
                    DialogUtil.showDialogMessage("提示","测试","接口测试");
                    //调用接口
                }
            }
//            System.out.println("finish---------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}