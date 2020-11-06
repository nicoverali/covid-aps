package view;

import controller.IController;
import model.IModel;
import model.IModelListener;

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
