package memento.guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history (undo list)
    private List<IMemento> redoList; // Undone states (redo list)

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoList = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        redoList.clear();
        model.setOption(optionNumber, choice);
        gui.updateHistory();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        redoList.clear();
        model.setIsSelected(isSelected);
        gui.updateHistory();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            redoList.add(model.createMemento());
            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoList.isEmpty()) {
            System.out.println("Memento found in redo list");
            history.add(model.createMemento());
            IMemento nextState = redoList.remove(redoList.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    // returns the undo history for display in the history window
    public List<IMemento> getHistory() {
        return history;
    }

    // restore the model to the state at the given index in the history list
    public void restoreFromHistory(int index) {
        if (index < 0 || index >= history.size()) {
            return;
        }
        IMemento selected = history.get(index);
        // move the current state and the more recent states to the redo list
        redoList.add(model.createMemento());
        while (history.size() > index + 1) {
            redoList.add(history.remove(history.size() - 1));
        }
        history.remove(index);
        model.restoreState(selected);
        gui.updateGui();
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }
}

