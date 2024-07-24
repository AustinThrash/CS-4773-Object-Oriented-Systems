package cs4773.hw4;

public interface Subject {
	public void addObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers();
}
