package creational.singleton.dbMirror;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class ConfigureDatabase {
    private static Properties p = null;
    private static Connection master;
    private static Connection slave;

    public static void configureDatabases(File file) throws SQLException {

        String masterUrl;
        String masterUser;
        String masterPassword;
        String masterDriver;
        String slaveUrl;
        String slavePassword;
        String slaveUser;
        String slaveDriver;


        p = getProperties(file);

        if (master == null) {
            masterUrl = p.getProperty("masterUrl");
            masterUser = p.getProperty("masterUser");
            masterPassword = p.getProperty("masterPassword");
            masterDriver = p.getProperty("masterDriver");
            master = DriverManager.getConnection(masterUrl, masterUser, masterPassword);
        }

        if (slave == null) {
            slaveUrl = p.getProperty("slaveUrl");
            slaveUser = p.getProperty("slaveUser");
            slavePassword = p.getProperty("slavePassword");
            slaveDriver = p.getProperty("slaveDriver");
            slave = DriverManager.getConnection(slaveUrl, slaveUser, slavePassword);
        }
    }

    private static Properties getProperties(File file) {
        try {

            p = new Properties();
            p.load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return p;
    }

    public static String getProperty(String key) {
        return p.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        p.setProperty(key, value);
    }

    public static Connection getMaster() {
        return master;
    }

    public static void setMaster(Connection master) {
        ConfigureDatabase.master = master;
    }

    public static Connection getSlave() {
        return slave;
    }

    public static void setSlave(Connection slave) {
        ConfigureDatabase.slave = slave;
    }
}
