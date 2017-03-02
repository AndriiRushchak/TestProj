package MVC.dao.mock;

import MVC.bean.User;

import java.util.LinkedList;
import java.util.List;

public class DataSource {
    private static DataSource ourInstance = new DataSource();

    public static DataSource getInstance() {
        return ourInstance;
    }

    private DataSource() {
    }

    private List<User> users = new LinkedList<User>() {{
        add(new User("Karkowski", 123l, 1));
        add(new User("Potsula", 124l, 2));
        add(new User("Kulak", 125l, 1));
        add(new User("Udincev", 126l, 2));
    }};

    private long maxUserId = 126l;

    public List<User> getUsers() {
        return users;
    }

    public User createOrUpdate(User newUser) {
        if (newUser == User.NULL_USER)
            return User.NULL_USER;

        //новий користувач(new User)

        if (newUser.getId() == 0)
            return createNewUser(newUser);
        else
            return updateUser(newUser);
    }

    private User createNewUser(User newUser) {
        User clone = newUser.clone(++maxUserId);
        users.add(clone);
        return clone;
    }

    private User updateUser(User newUser) {
        for (User user : users) {
            if (user.getId() == newUser.getId()) {
                user.setName(newUser.getName());
                user.setLevel(newUser.getLevel());
                return user;
            }
        }
        // Якщо ми не знайшли такого користувача
        return User.NULL_USER;
    }
}