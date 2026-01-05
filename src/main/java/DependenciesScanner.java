// by SlavaEnergy

import java.util.Scanner;
import java.io.File;
import java.io.InputStream;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;
import java.util.List;
import com.electronwill.nightconfig.core.Config;
import com.electronwill.nightconfig.toml.TomlParser;


public class DependenciesScanner {
    public static void main(String[] args) throws Exception {

        System.out.println("To analyze all the dependencies of the modifications, enter the path to the mods directory: \n");
        System.out.print("> ");

        Scanner scanner = new Scanner(System.in);

        String pathdir = scanner.nextLine();
        File dir = new File(pathdir);
        if (dir.exists()) {
            if (dir.isDirectory()) {
                File[] filesindir = dir.listFiles();
                int quantityfilesindir = filesindir.length;

                int ifquantityfilesindir = 0;
                int score = 0;

                System.out.println("\nAnalysis...\n\n");
                System.out.print("\rThe following dependencies were found:");

                while (ifquantityfilesindir < quantityfilesindir) {

                    if (filesindir[ifquantityfilesindir].getName().endsWith(".jar")) {

                        File currentfile = filesindir[ifquantityfilesindir];
                        JarFile jar = new JarFile(currentfile);
                        JarEntry entry = jar.getJarEntry("META-INF/mods.toml");

                        if (entry != null) {

                            TomlParser parser = new TomlParser();

                            try (InputStream in = jar.getInputStream(entry)) {
                                Config config = parser.parse(in);
                                Config depsRoot = config.get("dependencies");

                                for (String modKey : depsRoot.valueMap().keySet()) {
                                    Object list = depsRoot.get(modKey);

                                    if (list instanceof List<?>) {
                                        for (Object obj : (List<?>) list) {
                                            Config dep = (Config) obj;

                                            String modId = dep.get("modId");
                                            String version = dep.get("versionRange");

                                            if (!"minecraft".equals(modId) && !"forge".equals(modId)) {
                                                System.out.print("\n" + modKey + " requires " + modId + " version " + version);
                                                score = score + 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }// else () { // для будущих версий под другие форматы модов
                        jar.close();
                    }
                    ifquantityfilesindir = ifquantityfilesindir + 1;
                }

                if (score == 0) {
                    System.out.print("\rNo dependencies found.                ");
                }

            } else {
                System.out.println("Error: The specified path is not a directory.");
            }
        } else {
            System.out.println("Error: There is no such directory.");
        }
    }
}