
import javax.swing.*;
import java.awt.event.*;
class welcome implements ActionListener
{
JFrame f;
JButton b1,b2,b3;
welcome()
{
f=new JFrame("event demo");
b1=new JButton("STOCK");
b2=new JButton("SELL");
b3=new JButton("SHOW");
f.setVisible(true);
f.setLayout(null);
f.setSize(900,900);
//f.setBackground(Color.red);
//b1.setBackground(Color.green);
//b2.setBackground(Color.blue);

b1.setBounds(40,40,90,40);
b2.setBounds(200,40,90,40);
b3.setBounds(40,100,90,40);
f.add(b1);
f.add(b2);
f.add(b3);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);

}
public void actionPerformed(ActionEvent ae)
{
if (ae.getSource()==b1)
{
pro pp=new pro();
f.setVisible(false);
}
if (ae.getSource()==b3)
{
show sp=new show();
f.setVisible(false);
}
if (ae.getSource()==b2)
{
customer cc=new customer();
f.setVisible(false);

}}
public static void main(String aa[])
{
welcome ww=new welcome();
}}