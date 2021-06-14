package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import core.ViewModelFactory;
import view.TimestampController;

import java.io.IOException;

//import core.ViewModelFactory;

public class ViewHandler {

    private Stage stage;
//    private TimestampViewModel viewModel;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
        this.stage = stage;
//        this.viewModel = viewModel;
        this.viewModelFactory = viewModelFactory;
    }

    public void start() throws Exception{
        openView("Timestamp");
    }

    public void openView(String viewToOpen) throws IOException {
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(getClass().getResource("../view/" + viewToOpen +"View.fxml"));
        root = loader.load();
        if("Timestamp".equals(viewToOpen)) {
            TimestampController view = loader.getController();
            view.init(viewModelFactory.getTimestampViewModel());
//            view.init(viewModel);
            stage.setTitle("Timestamp");
        }

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
