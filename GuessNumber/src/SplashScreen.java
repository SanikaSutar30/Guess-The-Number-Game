import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {

    public SplashScreen() {
        createSplashUI();
    }

    private void createSplashUI() {
        // Get screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Set splash screen size to match the screen
        setBounds(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());

        // Create a panel for splash screen content
        JPanel content = new JPanel();
        content.setLayout(null);
        content.setBackground(new Color(50, 50, 150));

        // Add welcome message
        JLabel welcomeLabel = new JLabel("Welcome to Guess The Number Game!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setBounds(50, (int) screenSize.getHeight() / 3, (int) screenSize.getWidth() - 100, 60);
        content.add(welcomeLabel);

        // Add subtext
        JLabel subTextLabel = new JLabel("Get ready to test your guessing skills!", SwingConstants.CENTER);
        subTextLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        subTextLabel.setForeground(Color.LIGHT_GRAY);
        subTextLabel.setBounds(50, (int) screenSize.getHeight() / 2, (int) screenSize.getWidth() - 100, 50);
        content.add(subTextLabel);

        // Add loading animation or placeholder
        JLabel loadingLabel = new JLabel("Loading...", SwingConstants.CENTER);
        loadingLabel.setFont(new Font("Arial", Font.ITALIC, 25));
        loadingLabel.setForeground(Color.LIGHT_GRAY);
        loadingLabel.setBounds(50, (int) screenSize.getHeight() - 150, (int) screenSize.getWidth() - 100, 40);
        content.add(loadingLabel);

        setContentPane(content);
    }

    public void showSplash(int duration) {
        setVisible(true);

        // Pause for the specified duration
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setVisible(false);
        dispose();
    }
}
