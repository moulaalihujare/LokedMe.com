package virtualKey_Project;
import java.util.List;
import java.util.Scanner;
import virtualKey_Project.menuOptions;
public class HandleOption {
public static void handleWelcomeScreenInput() {
boolean running = true;
Scanner sc = new Scanner(System.in);
do {
try {
menuOptions.displayMenu();
int input = sc.nextInt();
switch (input) {
case 1:
FileOperation.displayAllFiles("main");
break;
case 2:
HandleOption.handleFileMenuOptions();
break;
case 3:
System.out.println("Program exited successfully.");
running = false;
sc.close();
System.exit(0);
break;
default:
System.out.println("Please select a valid option from above.");
}
} catch (Exception e) {
System.out.println(e.getClass().getName());
handleWelcomeScreenInput();
}
} while (running == true);
}
public static void handleFileMenuOptions() {
boolean running = true;
Scanner sc = new Scanner(System.in);
do {
try {
menuOptions.displayFileMenuOptions();
FileOperation.createMainFolderIfNotPresent("main");
int input = sc.nextInt();
switch (input) {
case 1:
// File Add
System.out.println("Enter the name of the file to be added to the \"main\" folder");
String fileToAdd = sc.next();
FileOperation.createFile(fileToAdd, sc);
break;
case 2:
// File/Folder delete
System.out.println("Enter the name of the file to be deleted from \"main\" folder");
String fileToDelete = sc.next();
FileOperation.createMainFolderIfNotPresent("main");
List<String> filesToDelete =
FileOperation.displayFileLocations(fileToDelete, "main");
String deletionPrompt = "\nSelect index of which file to delete?"+ "\n(Enter 0 if you want to delete all elements)";
System.out.println(deletionPrompt);
int idx = sc.nextInt();
if (idx != 0) {
FileOperation.deleteFileRecursively(filesToDelete.get(idx - 1));
} else {
for (String path : filesToDelete) {
FileOperation.deleteFileRecursively(path);
}
}
break;
case 3:
// File/Folder Search
System.out.println("Enter the name of the file to be searched from \"main\" folder");
String fileName = sc.next();
FileOperation.createMainFolderIfNotPresent("main");
FileOperation.displayFileLocations(fileName,
"main");
break;
case 4:
HandleOption.handleWelcomeScreenInput();
case 5:
// Exit
System.out.println("Program exited successfully.");
running = false;
sc.close();
System.exit(0);
default:
System.out.println("Please select a valid option from above.");
}
} catch (Exception e) {
System.out.println(e.getClass().getName());
handleFileMenuOptions();
}
} while (running == true);
}
}