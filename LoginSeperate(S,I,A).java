import java.util.Scanner;

class LoginModule {
    private AuthService authService;
    private Scanner scanner;

    LoginModule(AuthService authService) {
        this.authService = authService;
        this.scanner = new Scanner(System.in);
    }

    User start() {
        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerUser();
                    break;

                case 2:
                    return loginUser(); // Return the logged-in user

                case 3:
                    System.out.println("Exiting...");
                    return null;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Choose role (1. Student, 2. Instructor, 3. Admin): ");
        int role = scanner.nextInt();
        scanner.nextLine();

        User user = role == 1 ? new Student(username, password, email, authService.getNextId()) :
                role == 2 ? new Instructor(username, password, email, authService.getNextId()) :
                role == 3 ? new Admin(username, password, email, authService.getNextId()) : null;

        if (user != null) {
            authService.register(user);
        } else {
            System.out.println("Invalid role.");
        }
    }

    private User loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User loggedInUser = authService.login(username, password);
        if (loggedInUser != null) {
            return loggedInUser; // Return the logged-in user
        }
        return null;
    }
}