package resources;

import Controllers.BaseScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ScenesControl extends Application {

//    public static void renderFinal() throws Exception{
//        Parent finalScreenroot = FXMLLoader.load(getClass().getResource("FxmlScreens/finalScreen.fxml"));
//        Scene finalScreen = new Scene(finalScreenroot);
//       // window.setScene();
//    }

   
@Override
    public void start(Stage stage) throws Exception{
        //window = stage;
       Parent baseScreenRoot = FXMLLoader.load(getClass().getResource("../FxmlScreens/baseScreen.fxml"));
       Scene baseScreen = new Scene(baseScreenRoot);


       stage.setTitle("BlingMonitor");
       stage.setScene(baseScreen);

       stage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}
