package View;

import Data.DatabaseHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StoffdatenView.fxml"));
        primaryStage.setTitle("Stofflagerungsverwaltung");
        primaryStage.setScene(new Scene(root, 1025, 800));
        primaryStage.show();
    }


    public static void main(String[] args) throws SQLException {

        launch(args);

    }
}
