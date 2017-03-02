package MVC.view;

import MVC.controller.Controller;
import MVC.model.ModelData;

/**
 * Created by Rushchak on 27.02.2017.
 */
public interface View {
    void refresh(ModelData modelData);

    void fireEventShowDeletedUsers();

    void setController(Controller controller);

}
