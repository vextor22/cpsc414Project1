/*
Author: Matthew Higgins


Base file provided by Oracle Java JavaFX HelloWorld tutorial.


*/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class ApplicationMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
		Scene scene = new Scene(new VBox(), 300, 250);

		MenuBar menuBar = new MenuBar();

		Menu menu = new Menu("File");
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent t){
				System.exit(0);
			}
		});
		menu.getItems().add(new MenuItem("Go!"));
		menu.getItems().add(quitMenuItem);

		menuBar.getMenus().add(menu);
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		menuBar.setLayoutX(100);
		menuBar.setLayoutY(0);		
	
		((VBox) scene.getRoot()).getChildren().addAll(menuBar);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
