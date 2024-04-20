package pl.crazymc.core.managers;

import org.bukkit.entity.Player;
import pl.crazymc.core.database.Database;
import pl.crazymc.core.objects.User;

public class UserManager extends Database {

    public static User getUser(final Player p) {
        if (objects.get(p.getName()) == null) {
            return createUser(new User(p.getName()));
        }
        return objects.get(p.getName());
    }

    public static User getUserOrNull(final String name) {
        return objects.get(name);
    }

    public static User getUserOrNull(final Player p) {
        return getUserOrNull(p.getName());
    }

    public static User createUser(final User u) {
        objects.put(u.getName(), u);
        return u;
    }
}
