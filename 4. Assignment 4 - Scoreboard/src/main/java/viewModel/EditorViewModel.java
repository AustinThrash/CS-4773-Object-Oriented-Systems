package viewModel;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import cs4773.hw4.Observer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.TeamModel;

public class EditorViewModel implements Initializable, Observer {

	private TeamModel team;
	@FXML
	private Label errorLabel;
	@FXML
	private TextField myName;
	@FXML
	private TextField myScore;
	@FXML
	private TextField myDate;
    @FXML
    private void saveData() {
    	errorLabel.setText(null);
    	if(myName.getText() != "" && myScore.getText() != "") {
    		try {
            	int score = Integer.parseInt(myScore.getText());
            	SimpleDateFormat formatter = new SimpleDateFormat();
        		Date date = new Date();
            	team.updateInfo(myName.getText(), score, formatter.format(date));
            	
            } catch (NumberFormatException nfe) {
            	errorLabel.setText("Please Enter a valid Team Score");
            }  
    	} else {
    		if(myName.getText() == "") {
            	errorLabel.setText("Please Enter a Team Name.");
            }
            if(myScore.getText() == "") {
            	errorLabel.setText("Please Enter a Team Score");
            }
    	}   
    }
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}


	
	public void setData(TeamModel currentTeam) {
		this.team = currentTeam;
		myName.setText(team.getName());
		myScore.setText(team.getScore());
		myDate.setText(team.getDate());
		
	}
	@Override
	public void update(int index, String name, int score, String date) {
		myName.setText(name);
		myScore.setText(String.valueOf(score));
		myDate.setText(date);
		
	}

}