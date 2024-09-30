import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FinalSecurePass {
    private static int quizScore = 0;  // To store quiz score
    private static ArrayList<String> passwordList = new ArrayList<>();  // To store passwords

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Did you take the SecurePass quiz? (yes or no)");
        String tookQuiz = scanner.nextLine().toLowerCase();

        if (tookQuiz.equals("no")) {
            takeQuiz(scanner);  // Run the quiz
        }

        // Menu to interact with the user
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1 - See my quiz score");
            System.out.println("2 - Retake SecurePass quiz");
            System.out.println("3 - Generate Password");
            System.out.println("4 - See my passwords");
            System.out.println("5 - Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            if (choice == 1) {
                System.out.println("Your score: " + quizScore + "/5");
            } else if (choice == 2) {
                takeQuiz(scanner);  // Retake the quiz
            } else if (choice == 3) {
                String newPassword = generatePassword();
                System.out.println("Your new password: " + newPassword);
                passwordList.add(newPassword);  // Save the password
            } else if (choice == 4) {
                System.out.println("Saved passwords:");
                for (String password : passwordList) {
                    System.out.println(password);
                }
            } else if (choice == 5) {
                System.out.println("Thank you using SecurePass!");
                exit = true;  // Exit the loop
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // Simple quiz with 5 questions
    public static void takeQuiz(Scanner scanner) {
        quizScore = 0;  // Reset score
        System.out.println("Answer with true or false:");

        System.out.print("1. You should use the same password for all accounts. ");
        boolean answer1 = scanner.nextBoolean();
        if (!answer1) quizScore++;

        System.out.print("2. Adding numbers makes your password stronger. ");
        boolean answer2 = scanner.nextBoolean();
        if (answer2) quizScore++;

        System.out.print("3. A password shorter than 8 characters is secure. ");
        boolean answer3 = scanner.nextBoolean();
        if (!answer3) quizScore++;

        System.out.print("4. It's safe to share your password with friends. ");
        boolean answer4 = scanner.nextBoolean();
        if (!answer4) quizScore++;

        System.out.print("5. Using your birthday as a password is a good idea. ");
        boolean answer5 = scanner.nextBoolean();
        if (!answer5) quizScore++;

        System.out.println("Your score: " + quizScore + "/5");
    }

    // Generate a random password with letters, numbers, and symbols
    public static String generatePassword() {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()_+";

        String combinedChars = upperCaseLetters + lowerCaseLetters + numbers + symbols;
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Generate an 8-character password
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(combinedChars.length());
            password.append(combinedChars.charAt(index));
        }

        return password.toString();
    }
}
