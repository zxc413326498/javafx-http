package xuelian.server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class ServerController {

    @FXML
    private TextArea message;
    @FXML
    private Text msg;

    Thread thread;

    @FXML
    public void initialize(){
    }
    @FXML
    public void start(ActionEvent actionEvent) {
        msg.setText("服务已启动");
        //启动server线程
        thread=new Thread(new MyServer(message));
        thread.start();
    }
    @FXML
    public void close(ActionEvent actionEvent) {
        msg.setText("服务已关闭");
        //关闭服务
        System.exit(0);
    }
}
