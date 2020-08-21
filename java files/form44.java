import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.plaf.*;
class form implements ActionListener
{
	JButton b1;
		JTextField t1,t2,t3;
		JLabel lb1,lb2,lb3;
JFrame f;
form()
{

	 f=new JFrame("form application");
	f.setLayout(null);

	f.setSize(300,800);
	f.setVisible(true);
    t1= new JTextField();
	t2= new JTextField();
	t3= new JTextField();

	lb1= new JLabel("Name");
	lb2= new JLabel("Roll no");
	lb3= new JLabel("city");
	b1= new JButton("Submit");


lb1.setBounds(40,40,100,30);
t1.setBounds(170,40,100,30);



lb2.setBounds(40,80,100,30);
t2.setBounds(170,80,100,30);
lb3.setBounds(40,120,100,30);
t3.setBounds(170,120,100,30);
b1.setBounds(80,200,100,30);



f.add(lb1);
f.add(t1);
f.add(lb2);
f.add(t2);

f.add(lb3);
f.add(t3);
f.add(b1);

b1.addActionListener(this);

	}

public void actionPerformed(ActionEvent ae)
{


if(ae.getActionCommand()=="Submit")
	{


		String name=t1.getText();
			String cid=t2.getText();
			String city=t3.getText();
			//int cid=Integer.parseInt(sid);
		connect c=new connect(cid,name,city);

}

}

	public static void main(String args[])
{
form fr=new form();
	}}