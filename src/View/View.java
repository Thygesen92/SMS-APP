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
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//import Model.model;

import javax.xml.soap.Text;

public class View extends Application
{
    private Scene scene;
    private Button btnSend;
    private VBox vBox;
    private Button seeTabelview;
    private TextArea textArea;
    private Label txtLabel;
    Controller controller_instance = new Controller();

    public View()
    {
    }


    public static void main(String[] args) {
       // new model();
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception
    {

        sndButton();
        setSeeTabelview();
        setTextArea();

        vBox = new VBox(10);
        vBox.getChildren().addAll(btnSend, seeTabelview, textArea, txtLabel);

        btnSend.setOnAction((event) -> {
            treadBegin();
        });

        scene = new Scene(vBox, 500,450);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void sendMsg() {
        try {
            String number = "";
            String msg = textArea.getText();
            String sender = "BORTFØREREN";
            this.controller_instance.sendSMS(number, msg, sender);
        }
        catch (Exception var5)
        {
        }
    }

    private void sndButton()
    {
        btnSend = new Button("Start konkurrence");
        btnSend.setMaxWidth(150);
        btnSend.setTranslateX(40);
        btnSend.setTranslateY(205);
    }


    private void setSeeTabelview()
    {
        seeTabelview = new Button("Se kundetabel");
        seeTabelview.setTranslateX(300);
        seeTabelview.setTranslateY(170);
    }


    private void setTextArea()
    {
        textArea = new TextArea();
        txtLabel = new Label("Besked her!");
        textArea.setTranslateX(0);
        textArea.setTranslateY(-50);
        txtLabel.setTranslateY(-260);
    }


    public void treadBegin()
    {
        RunningThread thread1 = new RunningThread("TestThread", this );
        thread1.start();
    }
}

class RunningThread implements Runnable
{

    private Thread thread;
    private String threadName;
    View view;

    RunningThread(String Name, View view)
    {
        threadName = Name;
        this.view = view;
        System.out.println("Creating: " + threadName);
    }

    @Override
    public void run()
    {
        System.out.println("Running " + threadName);
        try
        {
            for(int i = 1; i <= 40; i++)
            {
                System.out.println("Thread: " + threadName + ", " + i);
                java.lang.Thread.sleep((long)(1000));
            }
            System.out.println("Thread ending");

        }
        catch (InterruptedException e)
        {
            System.out.println("Error catched " + e);
        }
        view.sendMsg();
    }
    public void start()
    {
        System.out.println("Starting: " + threadName);
        if(thread == null)
        {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }
}
