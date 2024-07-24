package commands;

import scene.Editor;

public interface Command {
	public void execute(Editor scene);
	public void undo(Editor scene);
}
