

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Index extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1;

    public Index() {

        setSize(1300,430);
        setLayout(null);
        setLocation(40,180);

        l1 = new JLabel("");
        b1 = new JButton("Next");

        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.magenta);



        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/indexicon.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1360, 390,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);

        JLabel lid=new JLabel("Tic-Tac-Toe Game");
        lid.setBounds(30,300,1500,100);
        lid.setFont(new Font("serif",Font.PLAIN,70));
        lid.setForeground(Color.white);
        l1.add(lid);

        b1.setBounds(1100,325,150,50);
        l1.setBounds(0, 0, 1366, 390);

        l1.add(b1);
        add(l1);

        b1.addActionListener(this);
        setVisible(true);

        while(true){
            lid.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }
    }

    public void actionPerformed(ActionEvent ae){
        new SelectGame().setVisible(true);
        this.setVisible(false);

    }

    public static void main(String[] args) {
        Index window = new Index();
        window.setVisible(true);
    }
}