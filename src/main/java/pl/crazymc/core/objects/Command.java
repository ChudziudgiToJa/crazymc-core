package pl.crazymc.core.objects;

import java.util.List;

public class Command {
    private final String name;
    private final List<String> message;

    public Command(String name, List<String> message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public List<String> getMessage() {
        return message;
    }
}
