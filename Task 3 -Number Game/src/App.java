import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class App {
    public static void main(String[] args) throws Exception {
        Output obj= new Output();
        obj.display();
    }
}
class Output extends Frame implements ActionListener{
    Label l1,l2,attemptsLabel;
    int attempts=3;
    TextField t1;
    Button b1,b2;
    TextArea ta1;
    int randomNumber = (int)(Math.random() * 100) + 1;
    public void display(){
    System.out.println(randomNumber);
    //LABEL 1
    l1 = new Label("NUMBER GUESSING GAME");
    l1.setBounds(50,30,315,40);
    l1.setForeground(Color.white);
    l1.setFont(new Font("Bazooka",Font.BOLD|Font.ITALIC,20));
    //TEXT FIELD 1
    t1= new TextField("");
    t1.setBounds(120,70,100,30);
    t1.setBackground(Color.white);
    t1.setFont(new Font("Arial",Font.BOLD,27));
    //BUTTON B1
    b1= new Button("CHECK");
    b1.setBounds(250,72,75 ,30);
    b1.setFont(new Font("Arial",Font.BOLD,20));
    b1.setBackground(Color.white);
    b1.addActionListener(this);
    //TEXTAREA T1
    ta1 = new TextArea("RESULT WILL BE APPEAR", 5, 20, TextArea.SCROLLBARS_NONE);
    ta1.setBounds(80,140,270,40);
    ta1.setEditable(false);
    ta1.setFont(new Font("ARIAL",Font.BOLD,15));
    ta1.setBackground(Color.black);
    ta1.setForeground(Color.white);
    // ATTEMPTS LABEL
    attemptsLabel = new Label("Attempts: 3");
    attemptsLabel.setBounds(290, 100, 100, 30); // Top-right corner
    attemptsLabel.setForeground(Color.white);
    attemptsLabel.setFont(new Font("Arial", Font.BOLD, 14));

    //FRAME CONSTRAINTS
    setSize(400, 300);
    setBackground(Color.BLUE);
    setLayout(null);
    setTitle("NUMBER_GAME");
    setVisible(true);
    setResizable(false);
    //INSERTING INTO THEE FUNCTION
    add(l1);
    add(t1);
    add(b1);
    add(ta1);
    add(attemptsLabel); 
    //WINDOW CLOSING PROTOCOL
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    public void actionPerformed(ActionEvent E){
        if(E.getSource()==b1){
            attempts--;
            attemptsLabel.setText("Attempts:" + attempts);
            int number = Integer.parseInt(t1.getText());
            if (number == randomNumber){
            ta1.setText("YOUR GUESS IS RIGHT");
            } 
        else {
             if(number>randomNumber){
            ta1.setText("YOUR GUESS IS TOO HIGH");
                }
            else{
            ta1.setText("YOUR GUEESS IS TOO LOW");
             }
    }
                if(attempts == 0){
                    b1.setEnabled(false); // Disable the button
                    t1.setEnabled(false); // Optionally disable input
                    ta1.setText("NO MORE ATTEMPTS LEFT");
                    showDialogBox(); // Custom method below
                }
        }
    }
    //DIALOGBOX FUNCTION
    void showDialogBox() {
    Dialog d = new Dialog(this, "Game Over", true);
    d.setLayout(new BorderLayout());
    Label msg = new Label("Out of attempts! The correct number was: " + randomNumber, Label.CENTER);
    d.add(msg, BorderLayout.NORTH);
    Panel buttonPanel = new Panel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
    Button retry = new Button("Retry");
    retry.addActionListener(e -> {
        attempts = 3;
        attemptsLabel.setText("Attempts:" + attempts);
        ta1.setText("RESULT WILL BE APPEAR");
        t1.setText("");
        b1.setEnabled(true);
        t1.setEnabled(true);
        randomNumber = (int)(Math.random() * 100) + 1; 

        d.setVisible(false);
    });
    Button exit = new Button("Exit");
    exit.addActionListener(e -> {
        d.setVisible(false);
        dispose();
    });
    buttonPanel.add(retry);
    buttonPanel.add(exit);
    d.add(buttonPanel, BorderLayout.SOUTH);
    d.setSize(350, 150);
    d.setLocationRelativeTo(this);
    d.setVisible(true);
}
}

