package mainApp;

import java.io.IOException;

import ES1_30_2018.controllers.GUIController;
import ES1_30_2018.models.EmailModel;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


@SuppressWarnings("restriction")
public class Email extends Application{
	
	private Stage primaryStage;
    private AnchorPane rootLayout;
	private ObservableList<EmailModel> observableListEmailsSubjects;
	
	@Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");
        
		TabPane mainPane = FXMLLoader.load(Email.class.getResource("/gui.fxml"));
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.show();

        initRootLayout();

        showEmailOverview();
    }

	private void initRootLayout() {
		try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Email.class.getResource("/gui.fxml"));
            rootLayout = (AnchorPane) loader.load();
            // Mostra a scene (cena) contendo o root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/*private void showEmailOverview() {
		 try {
	            // Carrega o person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Email.class.getResource("/gui.fxml"));
	            AnchorPane emailOverview = (AnchorPane) loader.load();
	            
	            GUIController controller = loader.getController();
				//controller.setEmailApp(this);
	          
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}*/
	
	public void showEmailOverview() {
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Email.class.getResource("/gui2.fxml"));
			AnchorPane emailGUI = (AnchorPane) loader.load();
			
			GUIController controller = loader.getController();
			controller.setEmailApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static void main(String[] args) {
        Application.launch(args);
    }

    public ObservableList<EmailModel> getEmailData(){
		return observableListEmailsSubjects;
	}
	
}
