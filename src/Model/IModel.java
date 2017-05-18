package Model;

/**
 * Created by thyge on 18-05-2017.
 */
import java.util.List;
import Model.User;

public interface IModel {
    User getUser();

    List<User> getUsers();
}

