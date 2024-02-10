import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {



    private Container c;
    private JTextField t;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bClear, bDot, bAdd, bSubtract, bMultiply, bDivide, bPercent, bSolve,bDelete;




    Calculator() {
        go();
    }

    public void go() {

        this.setTitle("CALCULATOR");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(300, 100, 500, 400);

        c = this.getContentPane();
        c.setLayout(null);

        t = new JTextField(20);
        t.setHorizontalAlignment(JTextField.LEFT);
        t.setFont(t.getFont().deriveFont(25f));


        b1 = new JButton("1");
        b1.setFont(b1.getFont().deriveFont(18f));
        b2 = new JButton("2");
        b2.setFont(b2.getFont().deriveFont(18f));
        b3 = new JButton("3");
        b3.setFont(b3.getFont().deriveFont(18f));
        b4 = new JButton("4");
        b4.setFont(b4.getFont().deriveFont(18f));
        b5 = new JButton("5");
        b5.setFont(b5.getFont().deriveFont(18f));
        b6 = new JButton("6");
        b6.setFont(b6.getFont().deriveFont(18f));
        b7 = new JButton("7");
        b7.setFont(b7.getFont().deriveFont(18f));
        b8 = new JButton("8");
        b8.setFont(b8.getFont().deriveFont(18f));
        b9 = new JButton("9");
        b9.setFont(b9.getFont().deriveFont(18f));
        b0 = new JButton("0");
        b0.setFont(b0.getFont().deriveFont(18f));
        bDot = new JButton(".");
        bDot.setFont(bDot.getFont().deriveFont(18f));
        bClear = new JButton("C");
        bClear.setFont(bClear.getFont().deriveFont(18f));
        bAdd = new JButton("+");
        bAdd.setFont(bAdd.getFont().deriveFont(18f));
        bSubtract = new JButton("-");
        bSubtract.setFont(bSubtract.getFont().deriveFont(18f));
        bMultiply = new JButton("/");
        bMultiply.setFont(bMultiply.getFont().deriveFont(18f));
        bDivide = new JButton("*");
        bDivide.setFont(bDivide.getFont().deriveFont(18f));
        bPercent = new JButton("%");
        bPercent.setFont(bPercent.getFont().deriveFont(18f));
        bSolve = new JButton("=");
        bSolve.setFont(bSolve.getFont().deriveFont(18f));
        bDelete = new JButton("Del");
        bDelete.setFont(bDelete.getFont().deriveFont(18f));


        p1 = new JPanel();
        p1.setBounds(20, 30, 450, 50);
        p1.setBackground(Color.BLACK);
        c.add(p1);

        t.setBackground(Color.WHITE);
        p1.add(t);


        p2 = new JPanel();
        p2.setBounds(20, 100, 320, 250);
        p2.setBackground(Color.darkGray);
        c.add(p2);


        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b7);
        p2.add(b8);
        p2.add(b9);
        p2.add(b0);
        p2.add(bDot);
        p2.add(bClear);
        p2.setLayout(new GridLayout(4, 3));


        p3 = new JPanel();
        p3.setBounds(370, 100, 100, 250);
        p3.setBackground(Color.darkGray);
        c.add(p3);

        p3.add(bAdd);
        p3.add(bSubtract);
        p3.add(bMultiply);
        p3.add(bDivide);
        p3.add(bPercent);
        p3.add(bSolve);
        p3.add(bDelete);
        p3.setLayout(new GridLayout(7, 1));


        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        bDot.addActionListener(this);
        bClear.addActionListener(this);


        bAdd.addActionListener(this);
        bSubtract.addActionListener(this);
        bMultiply.addActionListener(this);
        bDivide.addActionListener(this);
        bPercent.addActionListener(this);
        bSolve.addActionListener(this);
        bDelete.addActionListener(this);

    }



    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.charAt(0) == 'D'){
            String s = t.getText();
            t.setText("");
            for(int i = 0; i<s.length()-1; i++){
                t.setText(t.getText()+s.charAt(i));
            }
        }

        else if(command.charAt(0) == 'C'){
            t.setText("");
        }
        else if(command.charAt(0) == '='){
            t.setText(evaluate(t.getText()));
        }
        else{
            t.setText(t.getText() +command);
        }
    }

    public static String evaluate(String expression){
        char[] arr = expression.toCharArray();
        String a = "", b = "", operator = "";
        double calculation = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] >= '0' && arr[i] <= '9' || arr[i] == '.') {
                if (operator.isEmpty()) {
                    a += arr[i];
                }
                else{
                    b += arr[i];
                }
            }

            if(arr[i] == '+' || arr[i] == '-' || arr[i] == '/' || arr[i] == '*' || arr[i] == '%'){
                operator += arr[i];
            }
        }

        if(operator.equals("+")){
            calculation = (Double.parseDouble(a) + Double.parseDouble(b));
        }
        else if(operator.equals("-")){
            calculation = (Double.parseDouble(a) - Double.parseDouble(b));
        }
        else if(operator.equals("*")){
            calculation = (Double.parseDouble(a) * Double.parseDouble(b));
        }
        else if(operator.equals("/")){
            calculation = (Double.parseDouble(a) / Double.parseDouble(b));
        }
        else{
            calculation = (Double.parseDouble(a) / 100);
        }
        return (String.valueOf(calculation));
    }




    public static void main(String [] args){
        JFrame f = new JFrame();
        Calculator calc = new Calculator();

        f.getContentPane().setLayout(null);
        f.add(calc.c);
        f.add(calc.p1);
        f.add(calc.p2);
        f.add(calc.p3);
        f.show();

        f.setSize(500, 520);
        f.setVisible(true);


    }


}



