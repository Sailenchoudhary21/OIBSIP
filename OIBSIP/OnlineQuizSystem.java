import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class OnlineQuizSystem {
    private User currentUser;
    private Timer questionTimer;
    private int score;

    public static void main(String[] args) {
        OnlineQuizSystem quizSystem = new OnlineQuizSystem();
        quizSystem.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            if (currentUser == null) {
                System.out.print("Enter username: ");
                String username = scanner.next();
                System.out.print("Enter password: ");
                String password = scanner.next();

                // Authenticate user (simplified, not using a database)
                if (isValidUser(username, password)) {
                    currentUser = new User(username);
                    System.out.println("Logged in successfully.");
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }
            }

            System.out.println("1. Start Quiz");
            System.out.println("2. Update Profile");
            System.out.println("3. Change Password");
            System.out.println("4. Logout");

            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    startQuiz();
                    break;
                case 2:
                    updateProfile();
                    break;
                case 3:
                    changePassword();
                    break;
                case 4:
                    logout();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private boolean isValidUser(String username, String password) {
        // In a real system, this would involve database or user storage validation
        return "testuser".equals(username) && "password".equals(password);
    }

    public void startQuiz() {
        System.out.println("Starting quiz...");

        // Implement a simplified quiz with multiple-choice questions
        // Simulate timer and auto-submit (for demonstration purposes)

        score = 0;
        int totalQuestions = 5; // Number of questions in the quiz
        int timeLimit = 60; // Time limit for the entire quiz in seconds
        int questionTime = timeLimit / totalQuestions; // Time for each question

        for (int i = 1; i <= totalQuestions; i++) {
            System.out.println("Question " + i + ": What is 2 * " + i + "?");

            // Simulate timer for each question
            simulateTimer(questionTime);

            // Simulate user selecting answers (simplified)
            System.out.print("Your answer: ");
            Scanner scanner = new Scanner(System.in);
            int userAnswer = scanner.nextInt();

            // Check the answer (simplified)
            if (userAnswer == 2 * i) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + (2 * i));
            }
        }

        System.out.println("Quiz completed. Your score: " + score + " out of " + totalQuestions);
    }

    private void simulateTimer(int seconds) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                timer.cancel();
            }
        }, seconds * 1000);
    }

    public void updateProfile() {
        // Simplified profile update functionality
        System.out.println("Updating profile...");
    }

    public void changePassword() {
        // Simplified password change functionality
        System.out.println("Changing password...");
    }

    public void logout() {
        currentUser = null;
        System.out.println("Logged out successfully.");
    }
}

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }
}
