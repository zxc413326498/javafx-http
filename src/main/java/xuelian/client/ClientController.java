package xuelian.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ClientController {
    @FXML
    public Text client_id;
    @FXML
    public TextField message;
    @FXML
    public Button bn_send;

    String time;

    @FXML
    public void initialize(){
        time=String.valueOf(System.currentTimeMillis());
        client_id.setText(time);
        //启动Client线程
        new Thread(new MyClient(time,bn_send,message)).start();
    }
}
