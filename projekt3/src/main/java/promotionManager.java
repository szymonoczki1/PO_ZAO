import java.util.*;


//invoker
public class promotionManager {
    private List<command> commands = new ArrayList<>();

    public void addCommand(command command) {
        commands.add(command);
    }

    public void executeCommands() {
        for (command command : commands) {
            command.execute();
        }
    }

    public void undoCommands() {
        for (command command : commands) {
            command.undo();
        }
    }

    public List<command> getCommands(){
        return commands;
    }
}
