<p align="right">
[РУСКОЯЗЫЧНАЯ ВЕРСИЯ](https://github.com/SlavaEnergy/Mods-Dependencies-Scanner/blob/main/README_ru.md)
</p>

# Mods Dependencies Scanner
This application allows you to quickly display a list of modifications-dependencies of all modifications in the Minecraft build, without launching Minecraft itself and then reading the Crash-log. 
The application is console-based (it does not have a GUI, it is controlled via the console). After launching, the application will require you to enter the path to the directory (folder) with the 
modifications, the list of dependencies of which must be displayed. And then it will display the entire list of necessary modifications-dependencies, modifications  that require them, as well as 
their required version.

At the moment, the application only supports the analysis of modifications created for the Forge loader, for Minecraft versions higher than 1.14. But in future updates, I will implement support 
for all types of Minecraft modifications, for all types of loaders.

## To launch the application, download the version you need on the releases page, or simply download the latest version using the button below:
[there will be a download button]
Then move the downloaded **.jar** file to any directory from which you will run it (or leave it in the same one).
Run any supporting console, for example CMD.exe(if your operating system is Windows).
Navigate to the directory where you placed the downloaded file (the command depends on the console you selected).
And then do the following in it:
`java -jar "Mods Dependencies Scanner-1.0.jar"` , by changing the version in the command to the version of the uploaded file.
This will launch the program, then follow the requirements of the program itself. As soon as the program completes its operation, you must enter the command again to restart it.
**Attention:** Java of any supported version is required on the JRE system to run the program, but I recommend Java 21.

## Compilation
If you want to recompile the jar file from the source files provided here, you can follow the instructions below, or if you have the skills to do it yourself:
To compile, you should download the project as a zip archive, unpack it, and then perform further actions with it, or clone this repository and work with it.
To compile, simply run the following command from the project directory:
`gradle wrapper` ,
and then this one:
`gradle build`.
**Attention:** to compile this program, you will need Gradle installed on the system, as well as JDK Java 21 (or any other supported version, but in this case you willneed to edit the build 
file.gradle).


Have a good day to everyone reading this =)
