package MVC;

import MVC.controller.Controller;
import MVC.model.MainModel;
import MVC.model.Model;
import MVC.view.EditUserView;
import MVC.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();
        EditUserView editUserView = new EditUserView();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);
        editUserView.setController(controller);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Ulmer", 124, 1);
        usersView.fireEventShowDeletedUsers();

    }
}