package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cs4773.hw4.Observer;
import cs4773.hw4.Subject;

public class TeamModel implements Subject {

	int index;
	String name;
	int score;
	String date;
	
	private List<Observer> observers = new ArrayList<>();
	
	public TeamModel(int i, String name, int score) {
		this.index = i;
		this.name = name;
		this.score = score;
		SimpleDateFormat formatter = new SimpleDateFormat();
		Date date = new Date();
		this.date = formatter.format(date);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getScore() {
		return String.valueOf(score);
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getDate() {
		return date;
	}
	public void updateDate() {
		SimpleDateFormat formatter = new SimpleDateFormat();
		Date date = new Date();
		this.date = formatter.format(date);
	}
	
	public String toString() {
		int nameSize = name.length();
		String text = name;
		if(nameSize <= 4) {
			text += "\t\t\t\t\t\t\t\t\t\t\t";
		} else if(nameSize < 8 && nameSize > 4) {
			text += "\t\t\t\t\t\t\t\t\t\t";
		} else if(nameSize < 12 && nameSize >= 8) {
			text += "\t\t\t\t\t\t\t\t\t";
		} else if(nameSize < 14 && nameSize >= 12) {
			text += "\t\t\t\t\t\t\t\t";
		} else if(nameSize < 18 && nameSize >= 14) {
			text += "\t\t\t\t\t\t\t";
		} else if(nameSize < 22 && nameSize >= 18) {
			text += "\t\t\t\t\t\t";
		} else if(nameSize < 26 && nameSize >= 22){
			text += "\t\t\t\t\t";
		}
		text += String.valueOf(score);
		return text;
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
		
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
		
	}

	@Override
	public void notifyObservers() {
		observers.forEach(observer -> {
			observer.update(index, name, score, date);
		});	
	}
	public void updateInfo(String name, int score, String date) {
		this.name = name;
		this.score = score;
		this.date = date;
		notifyObservers();
	}
	
}
