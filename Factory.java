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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.lang.Throwable;

public class Factory extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	
private ArrayList<Worker> workers = new ArrayList<Worker>();
private ArrayList<Product> products = new ArrayList<Product>();
private String TypeOfProduct;

public Worker hireWorker () {
	Worker wrkr = new Worker();
	workers.add(wrkr);
	return wrkr;
}
public void makeProduct() {
	if (workers.isEmpty()) throw new RuntimeException("No workers!");
	for (int i=0; i<workers.size();i++) {
		workers.get(i).work();	
	}
	products.add(new Automobile());
	for (int i=0; i<workers.size();i++) {
		workers.get(i).smoke();	
	}
}


@Override
public void  start(Stage primaryStage) {
	primaryStage.setResizable(false);
	BorderPane root = new BorderPane();
	Scene scene = new Scene(root, 200, 200);
	
	GridPane gridpane = new GridPane();
	gridpane.setPadding(new Insets(5));
	gridpane.setHgap(5);
	gridpane.setVgap(5);
	
	
	Label label = new Label("You are Factory!");
	gridpane.add(label, 0,0);
	Label NameHiredWorker = new Label();
	gridpane.add(NameHiredWorker, 0, 2);
	Label CreationInformation = new Label();
	gridpane.add(CreationInformation, 0, 4);

	
	Button HireButton = new Button("Hire a new worker");
	gridpane.add(HireButton, 0, 1);
	
	Button CreateButton = new Button("Create Automobile");
	gridpane.add(CreateButton, 0, 3);
	
	HireButton.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent e) {
			hireWorker();
			NameHiredWorker.setText("Hired worker: " + hireWorker().getName());
			}
	});
	
	CreateButton.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent e) {
			try {
				makeProduct();
				CreationInformation.setText("");
			}
			catch(Exception ex) {
				CreationInformation.setText(ex.getMessage());
			}
			}
		
	});
	
	root.setCenter(gridpane);
	primaryStage.setScene(scene);
	primaryStage.show();
}
}
