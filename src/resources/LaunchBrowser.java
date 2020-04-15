package resources;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LaunchBrowser {
    public static void runner() throws IOException, URISyntaxException {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {

            Desktop.getDesktop().browse(new URI("cameraVisualizer/visualizer.html"));
        }


    }

}
