package Controller;

/**
 * Created by thyge on 18-05-2017.
 */
import com.nexmo.client.NexmoClient;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;
import Controller.iController;
import java.util.ArrayList;
import java.util.List;
import Model.User;
import Model.model;
import nexo_quickstart.Util;

public class Controller implements iController {
    model model_instance = new model();
    List<User> users = new ArrayList();

    public Controller() {
    }

    public void sendSMS(String number, String msg, String sender) throws Exception {
        Util.configureLogging();
        String API_KEY = "??????????????????????????????????";
        String API_SECRET = "???????????????????????????????";
        String TO_NUMBER = "0045" + number;
        TokenAuthMethod auth = new TokenAuthMethod(API_KEY, API_SECRET);
        NexmoClient client = new NexmoClient(new AuthMethod[]{auth});
        System.out.println(sender);
        SmsSubmissionResult[] responses = client.getSmsClient().submitMessage(new TextMessage(sender, TO_NUMBER, msg));
        SmsSubmissionResult[] var11 = responses;
        int var12 = responses.length;

        for(int var13 = 0; var13 < var12; ++var13) {
            SmsSubmissionResult response = var11[var13];
            System.out.println(response);
        }

    }

    public List<User> getUsers() {
        return this.model_instance.connectToBD();
    }
}

