package View;

import Controller.IController;
import Model.IModel;
import Model.IModelListener;

public class ViewImpl implements IView {
    private final IModel model;
    private final IController controller;

    public ViewImpl(IModel model, IController controller) {
        this.model = model;
        this.controller = controller;
        initListener();
    }

    private void initListener() {
        model.setListener(new IModelListener() {
            public void onWordUpdate() {

            }

            public void onWordNotFound() {

            }
        });
    }
}
