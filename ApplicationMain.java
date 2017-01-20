/*
Author: Matthew Higgins


Base file provided by Oracle Java JavaFX HelloWorld tutorial.


*/

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import java.util.Random;
import java.util.Optional;
 
public class ApplicationMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }
	private static int circleState = 0; //0: no circle, 1: there is a circle    

	public static int getCircleState(){
		return circleState;
	}
	public static void setCircleState(int newCircleState){
		circleState = newCircleState;
	}


    @Override
    public void start(Stage primaryStage) {
		//program's UI setup
	    	final Random rand = new Random();
		
		final Pane circlePane = new Pane();	
		final Color paintArray[] = {Color.RED, Color.BLUE, Color.BLACK, Color.GREEN, 
				Color.DARKGOLDENROD}; 
        primaryStage.setTitle("Circle Application");
		final Scene scene = new Scene(new VBox(), 640, 480);

		final Circle circle = new Circle();

		//when the circle gets clicked on, generate an alert message
		//if the user clicked OK, end the program
		circle.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent t){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle(null);
				alert.setHeaderText(null);
				alert.setContentText("You have successfully selected the circle!");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.isPresent() && result.get() == ButtonType.OK)
					System.exit(0);
			}
		});
		MenuBar menuBar = new MenuBar();

		Menu menu = new Menu("File");
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent t){
				System.exit(0);
			}
		});

		//Go! item sets up the circle and places it in a Pane
		//A Pane was used for the circle's container because it allows manual positioning
		//of child objects
		MenuItem goMenuItem = new MenuItem("Go!");
		goMenuItem.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent t){			
				if(ApplicationMain.getCircleState() == 0){
					circle.setCenterX(320.0f);
					circle.setCenterY(200.0f);
					circle.setRadius(50.0f);
					circle.setFill(paintArray[rand.nextInt(paintArray.length)]);
					circlePane.getChildren().addAll(circle);
					ApplicationMain.setCircleState(1);
				}
			}
		});
		menu.getItems().add(goMenuItem);
		menu.getItems().add(quitMenuItem);

		menuBar.getMenus().add(menu);
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		
		//Here the menu bar is added directly to the scene root VBox
		//and the circle's container is added beneath.
		((VBox) scene.getRoot()).getChildren().addAll(menuBar);
		((VBox) scene.getRoot()).getChildren().addAll(circlePane);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
