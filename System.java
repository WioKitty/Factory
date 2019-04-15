import java.util.List;
import java.util.ArrayList;
import java.lang.String;
import javafx.application.Application; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler; 
import javafx.geometry.Insets;
import javafx.scene.Scene; 
import javafx.scene.control.Button;
import javafx.scene.control.Label; 
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.lang.Throwable;
import manufacture.*;

public class System extends Application{
    public static void main(String[] args) {
		Application.launch(args);
	}
@Override
public void  start(Stage primaryStage) {
	Factory Factory = new Factory();
	Store Store = new Store();
	Director Director = new Director();
	
	BorderPane root = new BorderPane();
	Scene scene = new Scene(root, 260, 250);
	
	AnchorPane anchorpane = new AnchorPane();
	double x =5;
	Label label1 = new Label("Welcome to Factory!");
	anchorpane.getChildren().add(label1);
	AnchorPane.setLeftAnchor(label1, x);
	AnchorPane.setTopAnchor(label1, 5.0);
	Button HireButton = new Button("Hire a new worker");
	anchorpane.getChildren().add(HireButton);
	AnchorPane.setLeftAnchor(HireButton, x);
	AnchorPane.setTopAnchor(HireButton, 35.0);
	Label NameHiredWorker = new Label();
	anchorpane.getChildren().add(NameHiredWorker);
	AnchorPane.setLeftAnchor(NameHiredWorker, x);
	AnchorPane.setTopAnchor(NameHiredWorker, 63.0);
	Button AutomobileButton = new Button("Automobile");
	anchorpane.getChildren().add(AutomobileButton);
	AnchorPane.setLeftAnchor(AutomobileButton, x);
	AnchorPane.setTopAnchor(AutomobileButton, 90.0);
	Button CookerButton = new Button("Cooker");
	anchorpane.getChildren().add(CookerButton);
	AnchorPane.setLeftAnchor(CookerButton, x+90);
	AnchorPane.setTopAnchor(CookerButton, 90.0);
	Button MatchButton = new Button("Match");
	anchorpane.getChildren().add(MatchButton);
	AnchorPane.setLeftAnchor(MatchButton, x+155);
	AnchorPane.setTopAnchor(MatchButton, 90.0);
	Button CreateButton = new Button("Create a product");
	anchorpane.getChildren().add(CreateButton);
	AnchorPane.setLeftAnchor(CreateButton, x);
	AnchorPane.setTopAnchor(CreateButton, 130.0);
	Button SendButton = new Button("Send production\n to store");
	anchorpane.getChildren().add(SendButton);
	AnchorPane.setLeftAnchor(SendButton, x+140);
	AnchorPane.setTopAnchor(SendButton, 130.0);
	Label CreationInformation = new Label();
	anchorpane.getChildren().add( CreationInformation);
	AnchorPane.setLeftAnchor( CreationInformation, x);
	AnchorPane.setTopAnchor( CreationInformation, 155.0);
	Label FactoryProduction = new Label();
	anchorpane.getChildren().add(FactoryProduction);
	AnchorPane.setRightAnchor(FactoryProduction, x);
	AnchorPane.setBottomAnchor(FactoryProduction, 50.0);
	Label StoreProduction = new Label();
	anchorpane.getChildren().add(StoreProduction);
	AnchorPane.setRightAnchor(StoreProduction, x);
	AnchorPane.setBottomAnchor(StoreProduction, 20.0);

	

	HireButton.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent e) {
			NameHiredWorker.setText("Hired worker: " + Factory.hireWorker().getName());
			}
	});
	CreateButton.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent e) {
			try {
				CreationInformation.setText(Factory.makeProduct() + " created");
				FactoryProduction.setText("Count of production at factory: "+Factory.getCountOfProduction());
			}
			catch(Exception ex) {
				CreationInformation.setText(ex.getMessage());
			}
			}
		
	});
	AutomobileButton.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent e) {
			Director.changeTypeOfProduct("Automobile");
			AutomobileButton.setStyle("-fx-border-color: #ff0000");
			CookerButton.setStyle("");
			MatchButton.setStyle("");
			}
	});
	CookerButton.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent e) {
			Director.changeTypeOfProduct("Cooker");
			CookerButton.setStyle("-fx-border-color: #ff0000");
			AutomobileButton.setStyle("");
			MatchButton.setStyle("");
			}
	});
	MatchButton.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent e) {
			Director.changeTypeOfProduct("Match");
			MatchButton.setStyle("-fx-border-color: #ff0000");
			AutomobileButton.setStyle("");
			CookerButton.setStyle("");
			}
	});
	SendButton.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent e) {
			Factory.sendProduction();
			StoreProduction.setText("Count of production at store: "
			+ Store.getCountOfProduction());
			FactoryProduction.setText("Count of production at factory: "
			+Factory.getCountOfProduction());
			}
	});
	root.setCenter(anchorpane);
	primaryStage.setScene(scene);
	primaryStage.show();
}
}
