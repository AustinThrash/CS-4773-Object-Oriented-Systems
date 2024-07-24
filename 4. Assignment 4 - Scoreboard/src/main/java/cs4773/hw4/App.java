package cs4773.hw4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import model.TeamModel;
import viewModel.ScoreboardViewModel;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    ListView<String> listView;
    TeamModel[] teams;

    @Override
    public void start(Stage stage) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Scoreboard.fxml"));
    	ScoreboardViewModel scoreboard = new ScoreboardViewModel();
    	teams = new TeamModel[5];
		teams[0] = new TeamModel(0, "Highly Irresistable Lions", 45);
		teams[0].addObserver(scoreboard);
		teams[1] = new TeamModel(1, "Immovable Tigers", 75);
		teams[1].addObserver(scoreboard);
		teams[2] = new TeamModel(2, "Super Duper Bears", 100);
		teams[2].addObserver(scoreboard);
		teams[3] = new TeamModel(3, "Incomparable Otters", 30);
		teams[3].addObserver(scoreboard);
		teams[4] = new TeamModel(4, "Resplendent Ocelots", 8);
		teams[4].addObserver(scoreboard);
		
    	fxmlLoader.setController(scoreboard);
    	
    	scene = new Scene(fxmlLoader.load(), 334, 195);
        stage.setTitle("Team Scoreboard");
        stage.setScene(scene);
        scoreboard.setTeams(teams);
        stage.show();
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}