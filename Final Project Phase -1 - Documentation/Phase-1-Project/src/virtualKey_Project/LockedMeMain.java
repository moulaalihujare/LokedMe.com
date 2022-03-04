package virtualKey_Project;
import virtualKey_Project.menuOptions;
public class LockedMeMain {
public static void main(String[] args) {
// Create "main" folder if not present in current folder structure
FileOperation.createMainFolderIfNotPresent("main");
menuOptions.printWelcomeScreen("Locker", "Moulaali");
HandleOption.handleWelcomeScreenInput();
}
}