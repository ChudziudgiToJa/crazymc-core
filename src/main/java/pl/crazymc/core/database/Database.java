package pl.crazymc.core.database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;
import pl.crazymc.core.CorePlugin;
import pl.crazymc.core.objects.User;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;

public class Database {
    public static final HashMap<String, User> objects = new HashMap<>();
    public static Dao<User, String> dao;

    public static void load() {
        try {
            final String databaseUrl = "jdbc:sqlite:" + new File(CorePlugin.getInstance().getDataFolder().toString(), "users.db");
            final JdbcConnectionSource jdbcConnectionSource = new JdbcConnectionSource(databaseUrl);
            dao = DaoManager.createDao(jdbcConnectionSource, User.class);
            TableUtils.createTableIfNotExists(jdbcConnectionSource, User.class);
            loadObjects();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadObjects() {
        for (final Object object : dao) {
            final User it = (User) object;
            objects.put(it.getName(), it);
        }
    }

    public static void saveObject(final User user) {
        try {
            dao.createOrUpdate(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveDatabase() {
        for (User value : objects.values()) {
            saveObject(value);
        }
    }
}
