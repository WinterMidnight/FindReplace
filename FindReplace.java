import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FindReplace extends JFrame {
    JTextField inputField;
    JTextField findField;
    JTextField replaceField;
    JTextField resultField;
    JButton findButton;
    JButton replaceButton;
    JButton clearButton;

    public FindReplace() {
        setTitle("Text Replacement Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10)); 
        getContentPane().setBackground(Color.PINK);

        inputField = new JTextField();
        findField = new JTextField();
        replaceField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        findButton = new JButton("Find");
        replaceButton = new JButton("Replace");
        clearButton = new JButton("Clear");

        add(new JLabel("Enter Text:"));
        add(inputField);
        add(new JLabel("Text to Find:"));
        add(findField);
        add(new JLabel("Text to Replace:"));
        add(replaceField);
        add(new JLabel("Result:"));
        add(resultField);

        add(findButton);
        add(replaceButton);
        add(clearButton);

        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performFind();
            }
        });

        replaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performReplacement();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    public void performFind() {
        String inputText = inputField.getText();
        String findText = findField.getText();

        if (findText.isEmpty()) {
            resultField.setText("Find text cannot be empty.");
            return;
        }

        int count = (inputText.length() - inputText.replace(findText, "").length()) / findText.length();
        if (count > 0) {
            resultField.setText("Found " + count + " occurrence(s) of \"" + findText + "\".");
        } else {
            resultField.setText("Text not found.");
        }
    }

    public void performReplacement() {
        String inputText = inputField.getText();
        String findText = findField.getText();
        String replaceText = replaceField.getText();

        if (findText.isEmpty()) {
            resultField.setText("Find text cannot be empty.");
            return;
        }

        String resultText = inputText.replace(findText, replaceText);
        int count = (inputText.length() - resultText.length()) / findText.length();

        resultField.setText(resultText + " (Replacements: " + count + ")");
    }

    public void clearFields() {
        inputField.setText("");
        findField.setText("");
        replaceField.setText("");
        resultField.setText("");
    }

    public static void main(String[] args) {
        FindReplace app = new FindReplace();
        app.setVisible(true);
    }
}
