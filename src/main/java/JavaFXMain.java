import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFXMain extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Wikipedia Revision Finder");

        GridPane gridPane = new GridPane();

        Label displayLabel = new Label("Please type the name of a Wiki article.");
        Button searchButton = new Button("Search");
        searchButton.setPrefSize(60,20);
        searchButton.setOnAction(value -> {
            displayLabel.setText("searching stuff");
                });

        gridPane.add(displayLabel,0,0,2,1);
        gridPane.add(searchButton,3,4,4,3);

        Scene mainScene = new Scene(gridPane,600,600);
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
