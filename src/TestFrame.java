//import javax.swing.*;
//import java.awt.*;
//
//public class TestQuestions extends JFrame {
//    TestQuestions(){

//
//    }
//
//    public static void main(String[] args){
//        new TestQuestions();
//    }
//}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame extends JFrame {
    private JPanel questionPanel;
    private int secondsRemaining = 15;
    private JButton nextButton;
    private JLabel timerLabel;
    Timer countdownTimer;
    private Test test;
    public TestFrame() {
        // Initialize UI components
        setSize(1500, 800); // Set the Frame Size
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setTitle("Java Quiz");
        setLocation(0, 0);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon LogoIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png")); // Load the image
        Image LogoImage = LogoIcon.getImage();
        Image LogoscaledImage = LogoImage.getScaledInstance(180, 74, Image.SCALE_SMOOTH);
        ImageIcon LogoscaledIcon = new ImageIcon(LogoscaledImage);
        JLabel Logolabel = new JLabel(LogoscaledIcon);
        Logolabel.setBounds(20, 25, 180, 74); // Set the position and size of the JLabel
        add(Logolabel);

        timerLabel = new JLabel("Time Left: " + secondsRemaining + " seconds");
        timerLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        timerLabel.setForeground(Color.RED);
        timerLabel.setBounds(1200, 25, 300, 40);
        add(timerLabel);

        countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsRemaining--;
                timerLabel.setText("Time Left: " + secondsRemaining + " seconds");
                if (secondsRemaining <= 0) {
                    ((Timer) e.getSource()).stop();
                    test.moveToNextQuestion();
                    showCurrentQuestion();
                    secondsRemaining=15;
                }
            }
        });
        countdownTimer.start();

        questionPanel = new JPanel();
        questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.PAGE_AXIS));
        questionPanel.setFont(new Font("Roboto",Font.PLAIN,28));
        questionPanel.setBackground(Color.WHITE);
        questionPanel.setBounds(100,100,1000,600);
        add(questionPanel);

        nextButton = new JButton("Next");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Create a test with two questions
        test = new Test();

        showCurrentQuestion();
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test.moveToNextQuestion();
                showCurrentQuestion();
            }
        });
    }

    private void showCurrentQuestion() {
        countdownTimer.start();
        questionPanel.removeAll();
        Question currentQuestion = test.getCurrentQuestion();
        if (currentQuestion != null) {
            // Display the question text
            JLabel questionLabel = new JLabel(currentQuestion.getQuestionText());
            questionLabel.setFont(new Font("Roboto",Font.BOLD,28));
            questionPanel.add(questionLabel);
            // Display options as radio buttons
            ButtonGroup optionGroup = new ButtonGroup();
            for (int i = 0; i < currentQuestion.getOptions().size(); i++) {
                JRadioButton optionButton = getjRadioButton(currentQuestion, i);
                optionGroup.add(optionButton);
                questionPanel.add(optionButton);
            }
            // Select the user's chosen option if they've answered this question
            int userChoice = currentQuestion.getUserChoice();
            if (userChoice >= 0 && userChoice < currentQuestion.getOptions().size()) {
                optionGroup.getElements().nextElement().setSelected(true);
            }

            revalidate();
            repaint();
        }
    }

    private JRadioButton getjRadioButton(Question currentQuestion, int i) {
        JRadioButton optionButton = new JRadioButton(currentQuestion.getOptions().get(i));
        optionButton.setFont(new Font("Roboto",Font.PLAIN,24));
        optionButton.setBackground(Color.WHITE);
        optionButton.setActionCommand(String.valueOf(i));
        optionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedOption = Integer.parseInt(e.getActionCommand());
                test.checkAnswer(selectedOption);
            }
        });
        return optionButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TestFrame().setVisible(true);
            }
        });
    }
}




class Question {
    private String questionText;
    private java.util.List<String> options;
    private int correctOption;
    private int userChoice = -1;
    public Question(String questionText, java.util.List<String> options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
    public String getQuestionText() {
        return questionText;
    }
    public java.util.List<String> getOptions() {
        return options;
    }
    public int getCorrectOption() {
        return correctOption;
    }
    public int getUserChoice() {
        return userChoice;
    }
    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }
}
class Test {
    private java.util.List<Question> questions;
    private int currentQuestionIndex;
    public Test() {
        questions = new java.util.ArrayList<>();
        // Add your questions here
        questions.add(new Question("Who invented Java Programming?", java.util.Arrays.asList(
                "Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup"), 1));

        questions.add(new Question("Which statement is true about Java?", java.util.Arrays.asList(
                "Java is a sequence-dependent programming language",
                "Java is a code dependent programming language",
                "Java is a platform-dependent programming language",
                "Java is a platform-independent programming language"), 4));

        questions.add(new Question("Which component is used to compile, debug and execute the java programs?", java.util.Arrays.asList(
                "JRE",
                "JIT",
                "JDK",
                "JVM"),3));

        questions.add(new Question("Which one of the following is not a Java feature?", java.util.Arrays.asList(
                "Object-oriented",
                "Use of pointers",
                "Portable",
                "Dynamic and Extensible"), 2));






        currentQuestionIndex = 0;
    }
    public Question getCurrentQuestion() {
        if (currentQuestionIndex >= 0 && currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null;
    }
    public void moveToNextQuestion() {
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
        }
    }
    public void moveToPreviousQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
        }
    }
    public void checkAnswer(int selectedOption) {
        Question currentQuestion = getCurrentQuestion();
        if (currentQuestion != null) {
            currentQuestion.setUserChoice(selectedOption);
        }
    }
}

