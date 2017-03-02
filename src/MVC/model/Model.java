package MVC.model;

import MVC.bean.User;

import java.util.List;

/**
 * Created by Rushchak on 27.02.2017.
 */
public interface Model {
    ModelData getModelData();

    void loadDeletedUsers();

    void loadUsers();

    void loadUserById(long userId);

    void deleteUserById(long id);

    List<User> getAliveAllUsers();

    void changeUserData(String name, long id, int level);
}