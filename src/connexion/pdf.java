package connexion;

import java.io.File;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.stage.Stage;

/**
 *
 * @author Macbook Pro
 */
public class pdf extends Application {

    
    public void host(File file){
 
HostServices hostServices = getHostServices();
 hostServices.showDocument(file.getAbsolutePath());

    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
    }
    
}