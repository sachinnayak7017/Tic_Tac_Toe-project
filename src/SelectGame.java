
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SelectGame extends JFrame implements ActionListener{

    JLabel l1,l2;


    JButton b1,b2;

    SelectGame(){

        super("Game");



        l1 = new JLabel("Game with Computer");
        l1.setFont(new Font("serif",Font.PLAIN,20));
        l1.setBounds(40,10,170,70);
        add(l1);

        l2 = new JLabel("Game with Players");
        l2.setFont(new Font("serif",Font.PLAIN,20));
        l2.setBounds(40,80,170,70);
        add(l2);

        b1 = new JButton("Play");
        b1.setBounds(260,20,110,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2 = new JButton("Play");
        b2.setBounds(260,100,110,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        JLabel lid=new JLabel("Tic-Tac-Toe Game");
        lid.setBounds(100,185,250,50);
        lid.setFont(new Font("serif",Font.PLAIN,28));
        lid.setForeground(Color.green);
        add(lid);



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/images.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(400,5,270,270);
        add(l3);


        b1.addActionListener(this);

        b2.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setSize(700,300);
        setLocation(300,200);

    }
//
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new Computer().setVisible(true);
            setVisible(false);
        }
        if(ae.getSource()==b2)
        {
            new Players().setVisible(true);
            setVisible(false);
        }

    }
    public static void main(String[] arg){
        new SelectGame();
    }
}
