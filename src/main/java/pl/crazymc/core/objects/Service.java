package pl.crazymc.core.objects;

import java.util.List;

public class Service {
    private final String name;
    private final String command;
    private final List<String> message;

    public Service(final String name, final String command, final List<String> message) {
        this.name = name;
        this.command = command;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

    public List<String> getMessage() {
        return message;
    }
}
