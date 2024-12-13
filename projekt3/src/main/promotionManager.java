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
}
