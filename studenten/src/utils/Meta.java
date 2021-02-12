package utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Dit is een static class (of toch final) met static methods die meer toegang geven tot de
 * meta-informatie over classes. Bijvoorbeeld alle classes uit een bepaalde package
 * opvragen in een arraylist zodat die waarden kunnen gebruikt worden in een generator.
 *
 * @author  Johan
 * @version 1.0
 * @since   2021-01-19
 */
public final  class Meta {

    //region get package classes
    public static ArrayList<String> getPackageClasses(String packageName) throws ClassNotFoundException, IOException {
        // https://dzone.com/articles/get-all-classes-within-package

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<File>();

        while (resources.hasMoreElements()) {
            URL resource = (URL) resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }

        ArrayList<String> classes = new ArrayList<String>();
        for (Object file : dirs) {
            classes.addAll(findClasses((File)file, packageName));
        }

        return classes;
    }

    private static List findClasses(File directory, String packageName) throws ClassNotFoundException {

        List classes = new ArrayList<String>();

        if (!directory.exists()) {
            return classes;
        }

        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                if ( Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)).getPackageName() == packageName)
                {
                    classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)).getSimpleName());
                }
            }
        }
        return classes;
    }
    //endregion

}
