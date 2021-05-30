import java.awt.event.*;
import javax.swing.*;

class COVID extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton []jb =new JRadioButton[3];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0,current=0,x=1,now=0;
    int []m =new int[10];
    COVID(String s)
    {
        super(s);
        l=new JLabel();
        add(l);
        bg=new ButtonGroup();
        for(int i=0;i<3;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Next");
        b2=new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);

        b1.setBounds(100,240,100,30);
        b2.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(800,550);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==9)
            {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Bookmark"))
        {
            JButton bk=new JButton("Bookmark"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if(e.getActionCommand().equals("Bookmark"+y))
            {
                if(check())
                    count=count+1;
                now=current;
                current=m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }

        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;

            if(count>3){
                JOptionPane.showMessageDialog(this,"Your score is "+count+" You need to consult a doctor immediately or contact Halton Regional Police Service COVID-19 helpline 905-825-4722");

                System.exit(0);
            }else if(count<3){
                JOptionPane.showMessageDialog(this," Your score is "+count+" You are safe, Take care!");

                System.exit(0);
            }
        }


    }
    void set()
    {
        jb[2].setSelected(true);
        if(current==0)
        {
            l.setText("Question 1: Are you experiencing Coughing?");
            jb[0].setText("Yes");jb[1].setText("No");
        }
        if(current==1)
        {
            l.setText("Question 2:Are you sneezing often?");
            jb[0].setText("Yes");jb[1].setText("No");
        }
        if(current==2)
        {
            l.setText("Question 3: Are you experiencing Diarrhea?");
            jb[0].setText("Yes");jb[1].setText("No");
        }
        if(current==3)
        {
            l.setText("Question 4: Do you have a headache?");
            jb[0].setText("Yes");jb[1].setText("No");
        }
        if(current==4)
        {
            l.setText("Question 5:Do you experience difficulty in breathing?");
            jb[0].setText("Yes");jb[1].setText("No");
        }
        if(current==5)
        {
            l.setText("Question 6: Are you more frequently fatigued?");
            jb[0].setText("Yes");jb[1].setText("No");
        }
        if(current==6)
        {
            l.setText("Question 7: Are you experiencing body aching? ");
            jb[0].setText("Yes");jb[1].setText("No");
        }
        if(current==7)
        {
            l.setText("Question 8: Are you experiencing dizziness?");
            jb[0].setText("Yes");jb[1].setText("No");
        }
        if(current==8)
        {
            l.setText("Question 9: Have you travelled outside of Canada in the past 14 days?");
            jb[0].setText("Yes");jb[1].setText("No");
        }
        if(current==9)
        {
            l.setText("Question 10: Have you had close contact with a confirmed or probable case of COVID-19?");
            jb[0].setText("Yes");jb[1].setText("No");
        }
        l.setBounds(30,40,450,20);

    }
    boolean check()
    {
        if(current==0)
            return(jb[0].isSelected());
        if(current==1)
            return(jb[0].isSelected());
        if(current==2)
            return(jb[0].isSelected());
        if(current==3)
            return(jb[0].isSelected());
        if(current==4)
            return(jb[0].isSelected());
        if(current==5)
            return(jb[0].isSelected());
        if(current==6)
            return(jb[0].isSelected());
        if(current==7)
            return(jb[0].isSelected());
        if(current==8)
            return(jb[0].isSelected());
        if(current==9)
            return(jb[0].isSelected());
        return false;
    }
    public static void main(String[] args)
    {
        new COVID("Online COVID 19 Test");
    }
}