import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//MAIN CLASS
public class App {
    public static void main(String[] args) throws Exception {
        framedesigning obj= new framedesigning();
        obj.output();
    }
}
//CLASS FRAMEDESIGNING
class framedesigning extends Frame implements ActionListener{
    //VARIABLE INITIALIZATION
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    TextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    Button b1,b2;
    TextArea ta1;
public void output(){
    //LABEL 1
    l1 = new Label("STUDENT GRADE CALCULATOR");
    l1.setBounds(50,10,315,60);
    l1.setForeground(Color.BLACK);
    l1.setFont(new Font("Bazooka",Font.BOLD|Font.ITALIC,20));
    //LABEL 2
    l2= new Label("TAMIL");
    l2.setBounds(20,70,70,30);
    l2.setFont(new Font("Arial",Font.BOLD,20));
    //TEXT FIELD 1
    t1= new TextField("");
    t1.setBounds(120,70,60,30);
    t1.setBackground(Color.white);
    t1.setFont(new Font("Arial",Font.BOLD,17));
    //label 3
    l3= new Label("ENGLISH");
    l3.setBounds(20,110,90,30);
    l3.setFont(new Font("Arial",Font.BOLD,20));
    //TEXT FIELD 2
    t2= new TextField("");
    t2.setBounds(120,110,60,30);
    t2.setBackground(Color.white);
    t2.setFont(new Font("Arial",Font.BOLD,17));
    //LABEL 4
    l4= new Label("MATHS");
    l4.setBounds(20,150,75,30);
    l4.setFont(new Font("Arial",Font.BOLD,20));
    //TEXT FIELD 3
    t3= new TextField("");
    t3.setBounds(120,150,60,30);
    t3.setBackground(Color.white);
    t3.setFont(new Font("Arial",Font.BOLD,17));
    //LABEL 5
    l5= new Label("SCIENCE");
    l5.setBounds(20,190,95,30);
    l5.setFont(new Font("Arial",Font.BOLD,20));
    //TEXT FIELD 4
    t4= new TextField("");
    t4.setBounds(120,190,60,30);
    t4.setBackground(Color.white);
    t4.setFont(new Font("Arial",Font.BOLD,17));
    //LABEL 6
    l6= new Label("SOCIAL");
    l6.setBounds(20,230,95,30);
    l6.setFont(new Font("Arial",Font.BOLD,20));
    //TEXT FIELD 5
    t5= new TextField("");
    t5.setBounds(120,230,60,30);
    t5.setBackground(Color.white);
    t5.setFont(new Font("Arial",Font.BOLD,17));
    //LABEL7
    l7 = new Label("TOTAL MARKS");
    l7.setBounds(20,280,150,30);
    l7.setFont(new Font("Arial",Font.BOLD,20));
    //TEXT FIELD 6
    t6= new TextField("");
    t6.setBounds(40,315,70,40);
    t6.setBackground(Color.white);
    t6.setFont(new Font("Arial",Font.BOLD,25));
    t6.setEditable(false);
    //LABEL8
    l8 = new Label("AVERAGE");
    l8.setBounds(180,280,100,30);
    l8.setFont(new Font("Arial",Font.BOLD,20));
    //TEXT FIELD 7
    t7= new TextField("");
    t7.setBounds(190,315,70,40);
    t7.setBackground(Color.white);
    t7.setFont(new Font("Arial",Font.BOLD,25));
    t7.setEditable(false);
    //LABEL9
    l9 = new Label("GRADE");
    l9.setBounds(300,280,100,30);
    l9.setFont(new Font("Arial",Font.BOLD,20));
    //TEXT FIELD 8
    t8= new TextField("");
    t8.setBounds(300,315,80,60);
    t8.setBackground(Color.white);
    t8.setFont(new Font("Arial",Font.BOLD,25));
    t8.setEditable(false);
    //LABEL 10
    l10= new Label("NOTE-ENTER THE MARKS");
    l10.setBounds(4, 375, 400, 40);
    l10.setFont(new Font("arial",Font.BOLD,30));
    //label 11
    l11= new Label("(OUT OF 100)");
    l11.setBounds(100, 400, 400, 70);
    l11.setFont(new Font("arial",Font.BOLD,30));
    //BUTTON RESET
    b1= new Button("RESET");
    b1.setBounds(250,72,70 ,30);
    b1.setFont(new Font("Arial",Font.BOLD,20));
    b1.addActionListener(this);
    //TEXT AREA
     String text = "GRADE EVALUTION\n" +
              "90 TO 100 - A+\n" +
              "80 TO 90  - A\n" +
              "70 TO 80  - B+\n" +
              "60 TO 70  - B\n" +
              "50 TO 60  - C\n" +
              "BELOW 50  - F";
              ta1=new TextArea(text,10,14,TextArea.SCROLLBARS_NONE);
              ta1.setBounds(200,100,170,130);
              ta1.setEditable(false);
              ta1.setFont(new Font("ARIAL",Font.BOLD,15));
              ta1.setBackground(Color.black);
              ta1.setForeground(Color.white);
    //CHECK RESULT BUTTON
    b2= new Button("CHECK");
    b2.setBounds(250, 230, 80, 30);
    b2.setFont(new Font("Arial",Font.BOLD,20));
    b2.addActionListener(this);
    //INSERTING INTO THE FRAME 
    add(l1);
    add(l2);
    add(t1);
    add(l3);
    add(t2);
    add(l4);
    add(t3);
    add(l5);
    add(t4);
    add(l6);
    add(t5); 
    add(l7);
    add(t6);
    add(l8);
    add(t7);
    add(l9);
    add(t8);
    add(l10);
    add(l11);
    add(b1);
    add(ta1);
    add(b2);
    //ACTION HANDLING 
    //FRAME CONSTRAINTS
    setSize(400, 500);
    setBackground(new Color(255,102,102));
    setLayout(null);
    setTitle("STUDENT GRADE CALCULATOR");
    setVisible(true);
    setResizable(false);
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
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
        }
        if(E.getSource()==b2){
            String sub1=t1.getText();
            String sub2=t2.getText();
            String sub3=t3.getText();
            String sub4=t4.getText();
            String sub5=t5.getText();
            Compute obj1 = new Compute();
            String add=obj1.total(sub1, sub2, sub3, sub4, sub5);
            t6.setText(add);
            String avg=obj1.average(add);
            t7.setText(avg);
            //GRADE CHECKER 
            String grade=obj1.gradechecker(avg);
            t8.setText(" "+grade);
            t8.setFont(new Font("Serif",Font.BOLD,60));
        }
    }
}
//COMPUTE CLASS 
class Compute{
    //TOTAL MARKS FUNCTION
    public String total(String tam,String eng,String mat,String sci,String soc){
       int s1=Integer.parseInt(tam);
       int s2=Integer.parseInt(eng);
       int s3=Integer.parseInt(mat);
       int s4=Integer.parseInt(sci);
       int s5=Integer.parseInt(soc);
       int total=s1+s2+s3+s4+s5;
       return Integer.toString(total);
    }
    //AVERAGE MARK FUNCTION
    public String average(String add){
        double d=Double.parseDouble(add);
        double avg=d/5;
        return Double.toString(avg);
    }
    //GRADE CHECKER FUNCTION
    public String gradechecker(String avg){
        double gv=Double.parseDouble(avg);
        if(gv>=90&&gv<=100){
            return "A+";
        }
        else if(gv>=80&&gv<90){
            return "A";
        }
        else if(gv>=70&&gv<80){
            return "B+";
        }
        else if(gv>=60&&gv<70){
            return "B";
        }
        else if(gv>=50&&gv<60){
            return "C";
        }
        return "F";
    }
}

