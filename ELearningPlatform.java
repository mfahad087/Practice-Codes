import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class User {
    String username, password;
    Map<String, Boolean> progress; // Tracks completion status of courses

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.progress = new HashMap<>();
    }

    // Mark a course as completed
    public void completeCourse(String courseName) {
        progress.put(courseName, true);
    }

    // Check if a course is completed
    public boolean isCourseCompleted(String courseName) {
        return progress.getOrDefault(courseName, false);
    }
}

class Course {
    String courseName;
    String lectureContent;
    ArrayList<String[]> quizQuestions; // Each question is stored as [question, option1, option2, option3, correctAnswer]

    public Course(String courseName, String lectureContent, ArrayList<String[]> quizQuestions) {
        this.courseName = courseName;
        this.lectureContent = lectureContent;
        this.quizQuestions = quizQuestions;
    }
}

public class ELearningPlatform {
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();
    private static User currentUser = null;

    public static void main(String[] args) {
        // Define quiz questions for each course
        ArrayList<String[]> javaQuiz = new ArrayList<>();
        javaQuiz.add(new String[]{"What is Java primarily used for?", "Web Development", "Mobile Apps", "Data Analysis", "Mobile Apps"});
        javaQuiz.add(new String[]{"Which company developed Java?", "Microsoft", "Oracle", "Google", "Oracle"});
        javaQuiz.add(new String[]{"What is the extension of a Java file?", ".js", ".java", ".py", ".java"});

        ArrayList<String[]> pythonQuiz = new ArrayList<>();
        pythonQuiz.add(new String[]{"What is Python known for?", "Complexity", "Simplicity", "Speed", "Simplicity"});
        pythonQuiz.add(new String[]{"Which of these is a Python framework?", "Django", "Spring", "React", "Django"});
        pythonQuiz.add(new String[]{"What is the extension of a Python file?", ".java", ".py", ".html", ".py"});

        ArrayList<String[]> webQuiz = new ArrayList<>();
        webQuiz.add(new String[] {"What does HTML stand for?", "HyperText Markup Language", "HighText Machine Language", "HyperText Machine Language", "HyperText Markup Language"});
        webQuiz.add(new String[] {"Which language is used for styling web pages?", "JavaScript", "CSS", "Python", "CSS"});
        webQuiz.add(new String[] {"What is JavaScript used for?", "Styling", "Backend Logic", "Adding Interactivity", "Adding Interactivity"});

        // Add courses with their lecture content and quiz questions
        courses.add(new Course("Java Programming", 
            "<html><h1>What is Java?</h1>" +
            "<p>Java is a high-level, class-based, object-oriented programming language " +
            "that is designed to have as few implementation dependencies as possible. " +
            "It is widely used for building enterprise-scale applications, mobile apps (Android), " +
            "and large systems. Java is known for its portability, performance, and security.</p></html>",
            javaQuiz
        ));
        courses.add(new Course("Python Basics", 
            "<html><h1>What is Python?</h1>" +
            "<p>Python is an interpreted, high-level, general-purpose programming language. " +
            "It is known for its simplicity and readability, making it a great choice for beginners. " +
            "Python is widely used in web development, data analysis, artificial intelligence, " +
            "scientific computing, and more.</p></html>",
            pythonQuiz
        ));
        courses.add(new Course("Web Development", 
            "<html><h1>Introduction to Web Development</h1>" +
            "<p>Web development involves building and maintaining websites and web applications. " +
            "It is divided into two main areas:</p>" +
            "<ul><li><b>Frontend Development:</b> Deals with the user interface and user experience (HTML, CSS, JavaScript).</li>" +
            "<li><b>Backend Development:</b> Deals with server-side logic, databases, and APIs (Node.js, Python, Java, etc.).</li></ul></html>",
            webQuiz
        ));

        showLoginScreen();
    }

    public static void showLoginScreen() {
        JFrame frame = new JFrame("E-Learning Platform - Login");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel for the login form
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        loginPanel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel lblTitle = new JLabel("E-Learning Platform", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(lblTitle, gbc);

        // Username
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        loginPanel.add(lblUsername, gbc);

        JTextField txtUsername = new JTextField(20);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 1;
        loginPanel.add(txtUsername, gbc);

        // Password
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(lblPassword, gbc);

        JPasswordField txtPassword = new JPasswordField(20);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginPanel.add(txtPassword, gbc);

        // Buttons
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.setBackground(new Color(0, 102, 204));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            for (User user : users) {
                if (user.username.equals(username) && user.password.equals(password)) {
                    currentUser = user;
                    frame.dispose();
                    showDashboard();
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Invalid credentials! Try again.");
        });

        JButton btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Arial", Font.BOLD, 14));
        btnRegister.setBackground(new Color(0, 153, 76));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFocusPainted(false);
        btnRegister.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            users.add(new User(username, password));
            JOptionPane.showMessageDialog(frame, "Registration successful! You can now login.");
        });

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        loginPanel.add(btnLogin, gbc);

        gbc.gridy = 4;
        loginPanel.add(btnRegister, gbc);

        frame.add(loginPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void showDashboard() {
        JFrame frame = new JFrame("E-Learning Platform - Dashboard");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel for course buttons
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create colorful buttons for each course and quiz
        for (Course course : courses) {
            JButton courseButton = new JButton(course.courseName);
            courseButton.setFont(new Font("Arial", Font.BOLD, 16));
            courseButton.setBackground(getCourseColor(course.courseName));
            courseButton.setForeground(Color.WHITE);
            courseButton.setFocusPainted(false);
            courseButton.addActionListener(e -> showLecture(course.lectureContent));
            buttonPanel.add(courseButton);

            JButton quizButton = new JButton("Take Quiz");
            quizButton.setFont(new Font("Arial", Font.BOLD, 14));
            quizButton.setBackground(new Color(255, 102, 102));
            quizButton.setForeground(Color.WHITE);
            quizButton.setFocusPainted(false);
            quizButton.addActionListener(e -> takeQuiz(course));
            buttonPanel.add(quizButton);
        }

        // Logout button
        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogout.setBackground(new Color(204, 0, 0));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFocusPainted(false);
        btnLogout.addActionListener(e -> {
            currentUser = null;
            frame.dispose();
            showLoginScreen();
        });

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(btnLogout, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void showLecture(String lectureContent) {
        JFrame lectureFrame = new JFrame("Lecture");
        lectureFrame.setSize(600, 500);
        lectureFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        lectureFrame.setLayout(new BorderLayout());

        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setText(lectureContent);
        textPane.setEditable(false);
        textPane.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(textPane);
        lectureFrame.add(scrollPane, BorderLayout.CENTER);
        lectureFrame.setVisible(true);
    }

    public static void takeQuiz(Course course) {
        JFrame quizFrame = new JFrame("Quiz - " + course.courseName);
        quizFrame.setSize(500, 400);
        quizFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        quizFrame.setLayout(new BorderLayout());

        JPanel quizPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        quizPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        ArrayList<JRadioButton[]> optionsList = new ArrayList<>();
        ButtonGroup[] buttonGroups = new ButtonGroup[course.quizQuestions.size()];

        for (int i = 0; i < course.quizQuestions.size(); i++) {
            String[] questionData = course.quizQuestions.get(i);
            JLabel questionLabel = new JLabel("<html><b>" + (i + 1) + ". " + questionData[0] + "</b></html>");
            questionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            quizPanel.add(questionLabel);

            buttonGroups[i] = new ButtonGroup();
            JRadioButton[] options = new JRadioButton[3];
            for (int j = 0; j < 3; j++) {
                options[j] = new JRadioButton(questionData[j + 1]);
                options[j].setFont(new Font("Arial", Font.PLAIN, 14));
                buttonGroups[i].add(options[j]);
                quizPanel.add(options[j]);
            }
            optionsList.add(options);
        }

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.setBackground(new Color(0, 102, 204));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(e -> {
            int score = 0;
            for (int i = 0; i < course.quizQuestions.size(); i++) {
                String[] questionData = course.quizQuestions.get(i);
                JRadioButton[] options = optionsList.get(i);
                for (int j = 0; j < 3; j++) {
                    if (options[j].isSelected() && options[j].getText().equals(questionData[4])) {
                        score++;
                    }
                }
            }
            JOptionPane.showMessageDialog(quizFrame, "Your score: " + score + "/" + course.quizQuestions.size());
            if (score == course.quizQuestions.size()) {
                currentUser.completeCourse(course.courseName);
                JOptionPane.showMessageDialog(quizFrame, "Congratulations! You have completed the course: " + course.courseName);
            }
            quizFrame.dispose();
        });

        quizFrame.add(quizPanel, BorderLayout.CENTER);
        quizFrame.add(submitButton, BorderLayout.SOUTH);
        quizFrame.setVisible(true);
    }

    // Helper method to assign colors to courses
    private static Color getCourseColor(String courseName) {
        switch (courseName) {
            case "Java Programming":
                return new Color(0, 102, 204); // Blue
            case "Python Basics":
                return new Color(255, 128, 0); // Orange
            case "Web Development":
                return new Color(0, 153, 76); // Green
            default:
                return Color.GRAY;
        }
    }
}