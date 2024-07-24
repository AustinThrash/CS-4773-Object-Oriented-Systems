package memento;
import java.util.LinkedList;

public class CareTaker {
	LinkedList<Memento> savedCommands = new LinkedList<Memento>();
	
	public void addMemento(Memento m) { savedCommands.push(m); }
	
	public Memento getMemento() { return savedCommands.pop(); }
	
	public boolean hasHistory() {
		if(savedCommands.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}
