
import javax.swing.*;
import java.awt.event.*;
class show implements ActionListener
{
JFrame f;
JTextField t1,t2;
JLabel lb1,lb2;
JButton b1;
show()
{
f=new JFrame("event demo");
t1=new JTextField();
t2=new JTextField();
lb1=new JLabel("billno=");
lb2=new JLabel("name");

b1=new JButton("OK");

f.setVisible(true);
f.setLayout(null);
f.setSize(900,900);
//f.setBackground(Color.red);
//b1.setBackground(Color.green);
//b2.setBackground(Color.blue);
lb1.setBounds(40,40,90,40);

t1.setBounds(100,40,90,40);
lb2.setBounds(200,40,90,40);

t2.setBounds(300,40,90,40);
b1.setBounds(40,100,90,40);
f.add(t1);
f.add(lb1);
f.add(lb2);

f.add(t2);
f.add(b1);

b1.addActionListener(this);

}
public void actionPerformed(ActionEvent ae)
{
if (ae.getSource()==b1)
{
	String bn=t1.getText();
	String nm=t2.getText();

ending fa=new ending(bn,nm);
f.setVisible(false);

}}
public static void main(String ar[])
{
	show ss=new show();}}