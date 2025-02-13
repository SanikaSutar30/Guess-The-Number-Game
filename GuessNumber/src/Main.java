public class Main {
    public static void main(String[] args) {
        // Show the splash screen for 3 seconds
        SplashScreen splash = new SplashScreen();
        splash.showSplash(3000);

        // Launch the main game GUI
        GuessTheNumberGUI game = new GuessTheNumberGUI();
    }
}
