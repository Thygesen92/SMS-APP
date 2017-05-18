package View; /**
 * Created by thyge on 18-05-2017.
 */
import Controller.Controller;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.User;
import Model.model;

public class View extends Application {
    private Stage stage;
    private Scene scene;
    private TextField antal;
    private TextField produkt;
    private Button btnSend;
    private VBox vBox;
    Controller controller_instance = new Controller();

    public View() {
    }

    public static void main(String[] args) {
        new model();
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.btnSend = new Button("Start konkurrence");
        this.btnSend.setOnAction((event) -> {
            this.sendMsg(event);
        });
        this.antal = new TextField("Antal");
        this.produkt = new TextField("Produkt");
        this.vBox = new VBox();


        this.vBox.getChildren().addAll( this.antal, this.produkt, btnSend);
        this.scene = new Scene(this.vBox, 500,450);
        this.stage.setScene(this.scene);
        this.stage.show();
    }

    private void sendMsg(ActionEvent event) {
        try {
            String number = "???????????????????";
            String msg = "Du har vundet " + this.antal.getText() + " af " + this.produkt.getText();
            String sender = "Castus";
            this.controller_instance.sendSMS(number, msg, sender);
        } catch (Exception var5) {
            ;
        }

    }
/*
    public ComboBox fillCombobox(ComboBox cb) {
        List Users = this.controller_instance.getUsers();

        for(int i = 0; i < Users.size(); ++i) {
            cb.getItems().addAll(new Object[]{Integer.valueOf(((User)Users.get(i)).getNumber())});
        }

        cb.setValue("Numbers");
        return cb;
    } */


}
