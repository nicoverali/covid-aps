package Model;

public interface IModel {
    void setListener(IModelListener listener);
    void searchWord(String term);
}
