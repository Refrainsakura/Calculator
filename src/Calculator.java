import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame{
    private JFrame cal;
    private JPanel tshape;
    private JPanel bshape;
    private JButton[] buttons;
    private JButton cbutton;
    private JTextField text;
    private String str0 = "0";
    private String flag = null;
    private double s1=0.0;
    private double s2=0.0;

    public Calculator(){
        cal = new JFrame("计算器");
        tshape = new JPanel();
        bshape = new JPanel();
        buttons = new JButton[16];
        cbutton = new JButton("C");
        text = new JTextField(14);
        text.setHorizontalAlignment(JTextField.RIGHT);
        String s = "789/456*123-.0=+/";
        for(int i=0;i<buttons.length;i++){
            buttons[i] = new JButton(s.substring(i,i+1));
        }

        init();
        calculate();
    }

	//初始化
    public void init(){
        tshape.setLayout(new FlowLayout());
        tshape.add(text);
        text.setEditable(true);
        tshape.add(cbutton);
        bshape.setLayout(new GridLayout(4,4));
        for(int j=0;j<buttons.length;j++){
            bshape.add(buttons[j]);
        }
        cal.add(tshape,BorderLayout.NORTH);
        cal.add(bshape,BorderLayout.CENTER);
    }

    public void showit(){
        cal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cal.setSize(210,276);
        cal.setVisible(true);
        cal.setLocation(800,500);
        setFontAndColor();
    }

    public void setFontAndColor(){
        Font f = new Font("黑体",Font.BOLD,16);
        text.setFont(f);
        Color c =new Color(238,238,238);
        tshape.setBackground(c);
        for(int j=0;j<buttons.length;j++){
            buttons[j].setBackground(Color.GRAY);
            buttons[j].setContentAreaFilled(false);
        }
        cbutton.setContentAreaFilled(false);
    }

    public void calculate(){
        cbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = e.getActionCommand();
                if(str.equals("C")){
                    str0 = "0";
                    s1 = 0.0;
                    s2 = 0.0;
                    flag = null;
                    text.setText(str0);
                }
            }
        });
        for(int i=0;i<buttons.length;i++){
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String str = e.getActionCommand();
                    if(str.equals("+")){
                        s2 = s1;
                        s1 = 0.0;
                        str0 = "0";
                        flag = "+";
                        s1 = s2+s1;
                    }
                    else if(str.equals("-")){
                        s2 = s1;
                        s1 = 0.0;
                        str0 = "0";
                        flag = "-";
                        s1 = s2-s1;
                    }
                    else if(str.equals("*")){
                        s2 = s1;
                        s1 = 0.0;
                        str0 = "0";
                        flag = "*";
                        s1 = s2*s1;
                    }
                    else if(str.equals("/")){
                        s2 = s1;
                        s1 = 0.0;
                        str0 = "0";
                        flag = "/";
                        s1 = s2/s1;
                    }
                    else if(str.equals("=")){
                        if(flag.equals("+"))
                            s1 = s2+s1;
                        else  if(flag.equals("-"))
                            s1 = s2-s1;
                        else if(flag.equals("*"))
                            s1 = s2*s1;
                        else if(flag.equals("/"))
                            s1 = s2/s1;
                        flag = null;
                        str0 ="0";
                    }
                    else {
                        str0 =str0+str;
                        s1 = Double.parseDouble(str0);
                    }
                    text.setText(s1+"");
                }
            });
        }

    }

}
