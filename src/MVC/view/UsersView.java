package MVC.view;

import MVC.bean.User;
import MVC.controller.Controller;
import MVC.model.ModelData;

/**
 * Created by Rushchak on 27.02.2017.
 */
public class UsersView implements View {

    private Controller controller;

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList())
            System.out.println("All deleted users:");
        else
            System.out.println("All users:");

        for (User x:modelData.getUsers()) {
            System.out.println("\t" + x.toString());
        }
        System.out.println("===================================================");

    }

    public void fireEventShowAllUsers()
    {
        controller.onShowAllUsers();
    }

    @Override
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
}
