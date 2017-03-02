package MVC.model;


import MVC.bean.User;
import MVC.model.service.UserService;
import MVC.model.service.UserServiceImpl;

import java.util.List;


/**
 * Created by Rushchak on 27.02.2017.
 */
public class MainModel implements Model
{
    private UserService userService = new UserServiceImpl();
    private ModelData modelData = new ModelData();

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        modelData.setUsers(getAliveAllUsers());
    }

    @Override
    public List<User> getAliveAllUsers()
    {
        return getAllUsers();
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        modelData.setUsers(getAllUsers());
    }

    @Override
    public void loadUsers()
    {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
    }

    @Override
    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(getAllUsers());
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);

    }

    @Override
    public void loadUserById(long userId) {
        modelData.setUsers(getAllUsers());
        modelData.setActiveUser(userService.getUsersById(userId));
    }

    private List<User> getAllUsers()
    {
        List<User> list = userService.getUsersBetweenLevels(1, 100);
        list = userService.filterOnlyActiveUsers(list);
        return list;
    }
}
