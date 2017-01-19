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
		final Random rand = new Random();
		final Color paintArray[] = {Color.RED, Color.BLUE, Color.BLACK, Color.GREEN, 
				Color.DARKGOLDENROD}; 
        primaryStage.setTitle("Hello World!");
		final Scene scene = new Scene(new VBox(), 300, 250);

		final Circle circle = new Circle();
		circle.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent t){
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
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
		MenuItem goMenuItem = new MenuItem("Go!");
		goMenuItem.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent t){			
				if(ApplicationMain.getCircleState() == 0){
					circle.setCenterX(100.0f);
					circle.setCenterY(100.0f);
					circle.setRadius(50.0f);
					circle.setFill(paintArray[rand.nextInt(paintArray.length)]);
					((VBox) scene.getRoot()).getChildren().addAll(circle);
					ApplicationMain.setCircleState(1);
				}
			}
		});
		menu.getItems().add(goMenuItem);
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
