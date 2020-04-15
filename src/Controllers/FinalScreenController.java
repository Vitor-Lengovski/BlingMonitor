package Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import resources.GetCameraUrls;
import resources.JavaHTTPServer;
import resources.JsonWriter;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.cert.PolicyNode;
import java.util.List;
import java.util.ResourceBundle;

public class FinalScreenController  implements Initializable {

    public String startScreenUrl = "../FxmlScreens/startScreen.fxml";
    public String finalScreenUrl = "../FxmlScreens/finalScreen.fxml";
    public String screenToShowUrl;
    @FXML public Pane camerasPane;
    @FXML public Button visualizarBtn;
    @FXML public Label status;


    List<String> camerasUrls;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        autoScan();
    }
    public void autoScan(){
        GetCameraUrls gt = new GetCameraUrls();
        try {
            camerasUrls = gt.main(1,254,8081,8100);
            JsonWriter.main(camerasUrls);

            for (int counter = 0; counter < camerasUrls.size(); counter++) {
                addCameras(camerasUrls.get(counter));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addCameras(String port) throws IOException {
        BorderPane cameraContainer = new BorderPane();
        cameraContainer.setPrefWidth(170);
        cameraContainer.setPrefWidth(170);
        cameraContainer.setStyle("-fx-background-color: #e6e6e6;"+ "-fx-border-color: #bfbfbf;"+ "-fx-background-radius: 13;"+"-fx-border-radius: 13;");


        Label url = new Label();
        url.setText(port);
        url.setFont(Font.font ("System", 15));
        url.setPrefWidth(160);
        url.setStyle("-fx-alignment: center");


        File file = new File("src/Controllers/camera.png");
        Image cameraImg = new Image(file.toURI().toString());
        ImageView imageView = new ImageView();
       // Image cameraImg = new Image("camera.png");
        imageView.setImage(cameraImg);
        imageView.setFitWidth(160);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);



        cameraContainer.setCenter(imageView);
        cameraContainer.setBottom(url);



        camerasPane.getChildren().add(cameraContainer);

        scanFinished();

    }

    public  void scanFinished() {
        visualizarBtn.setVisible(true);

    }

    public void showCamerasPage(ActionEvent actionEvent) {
        System.out.println("action");
        new Thread() {

            @Override
            public void run() {
                JavaHTTPServer.main(null);

            }
        }.start();


    }

}
