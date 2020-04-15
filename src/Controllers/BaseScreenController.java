package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.PopupWindow;
import resources.GetCameraUrls;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BaseScreenController implements Initializable{
@FXML private BorderPane mainPane;
public String startScreenUrl = "../FxmlScreens/startScreen.fxml";
public String finalScreenUrl = "../FxmlScreens/finalScreen.fxml";
public String screenToShowUrl;



        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                //Testa quantos elementos tem na baseScreen, se tiver mais que 1 quer dizer que já tem coisa dentro e não precisa mais carregar o inicialize

                renderStart();


        }
        public void renderStart(){


                File camerasIndexed = new File("../camerasIndexed.json");

                if(camerasIndexed.exists()){
                        screenToShowUrl = finalScreenUrl;
                }else{
                        screenToShowUrl = startScreenUrl;
                }
                try {
                        renderScene(screenToShowUrl);



                } catch (IOException e) {
                        e.printStackTrace();
                }

        }
        public void renderScene(String fileFXML) throws IOException {
                BorderPane pane = mainPane;
                //System.out.println(pane);
                AnchorPane startScreen;
                startScreen =  FXMLLoader.load(getClass().getResource(fileFXML));
                pane.setCenter(startScreen);
        }

        public void test() {
                System.out.println("heu");
        }
}
