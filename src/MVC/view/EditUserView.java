package MVC.view;

import MVC.controller.Controller;
import MVC.model.ModelData;

/**
 * Created by Rushchak on 28.02.2017.
 */
public class EditUserView implements View {

    private Controller controller;

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
        System.out.println("\t" + modelData.getActiveUser().toString());
        System.out.println("===================================================");
    }


    public void fireEventUserChanged(String name, long id, int level)
    {
        controller.onUserChange(name, id, level);
    }

    public void fireEventShowAllUsers()
    {
        controller.onShowAllUsers();
    }

    public void fireEventUserDeleted(long id)
    {
        controller.onUserDelete(id);
    }


    @Override
    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }


}
