package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import resources.GetCameraUrls;
import resources.ScenesControl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class StartScreenController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    public void autoScanAction(ActionEvent actionEvent) throws Exception {
        //ScenesControl.renderFinal();

        Parent loadingScreenRoot = FXMLLoader.load(getClass().getResource("../FxmlScreens/finalScreen.fxml"));
        Scene loadingScreen = new Scene(loadingScreenRoot);
        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

       // window.setTitle("BlingMonitor");
        window.setScene(loadingScreen);
        window.show();





    }
}
