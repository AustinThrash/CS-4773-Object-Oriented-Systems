package viewModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cs4773.hw4.App;
import cs4773.hw4.Observer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import model.TeamModel;

public class ScoreboardViewModel implements Observer {
	
	private TeamModel[] Teams;
	@FXML 
	public ListView<String> myListView;
	@FXML 
	public Label label;
	
	@FXML
	public void handleMouseClick() {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Editor.fxml"));
		EditorViewModel editorView = new EditorViewModel();
		int teamIndex = myListView.getSelectionModel().getSelectedIndex();
		Teams[teamIndex].addObserver(editorView);
		fxmlLoader.setController(editorView);
		Stage stage = new Stage();
		stage.setTitle("Team Editor");
		try {
			stage.setScene(new Scene(fxmlLoader.load(), 396, 152));
			editorView.setData(Teams[teamIndex]);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setTeams(TeamModel[] teams) {
		Teams = teams;
		TeamModel t1 = Teams[0];
		TeamModel t2 = Teams[1];
		TeamModel t3 = Teams[2];
		TeamModel t4 = Teams[3];
		TeamModel t5 = Teams[4];
		
		//This is where I am running into issues, I don't understand why myListView is null
		myListView.getItems().setAll(t1.toString(),t2.toString(), t3.toString(),t4.toString(), t5.toString());
    	myListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}
	@Override
	public void update(int index, String name, int score, String date) {
		Teams[index].setName(name);
		Teams[index].setScore(score);
		Teams[index].updateDate();
		
		myListView.getItems().setAll(Teams[0].toString(),Teams[1].toString(),
				Teams[2].toString(),Teams[3].toString(), Teams[4].toString());
		
    	myListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}
}
