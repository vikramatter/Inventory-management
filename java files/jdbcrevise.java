import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class jdbcrevise implements ActionListener
{
 static JFrame f;
JButton b1,b2,b3;
JTextField t1,t2,t4,t3;
JLabel lb1,lb2,lb3,lb4;

jdbcrevise()
{
f=new JFrame();
	f.setVisible(true);
				f.setSize(700,800);
		f.setLayout(null);

		lb1= new JLabel("College== ");
		lb2= new JLabel("Name== ");
		lb3= new JLabel("Roll Number== ");
		lb4= new JLabel("Marks==");


		t1= new JTextField();
		t2= new JTextField();
		t3= new JTextField();
		t4= new JTextField();
	b1= new JButton("UPDATE");
		b2= new JButton("FIND");
		b3= new JButton("ADD");




     t1.setBounds(210,10,120,40);
	lb1.setBounds(30,10,150,40);

	lb2.setBounds(30,90,150,40);


t2.setBounds(210,90,120,40);
	lb3.setBounds(30,170,150,40);
	t3.setBounds(210,170,120,40);
	lb4.setBounds(30,230,150,40);
	t4.setBounds(210,230,120,40);
		//lb7.setBounds(400,230,300,40);
//combo2.setBounds(210,500,220,40);
	b1.setBounds(100,300,120,40);
		b2.setBounds(200,300,120,40);
		b3.setBounds(350,300,120,40);

//f.add(combo2);
	f.add(lb1);

	f.add(t1);
	f.add(lb2);
f.add(t2);
f.add(lb3);
	f.add(t3);
f.add(lb4);
	f.add(t4);
f.add(b2);
	f.add(b1);
		f.add(b3);




	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);

	}



public void actionPerformed(ActionEvent ae)
{if(ae.getActionCommand()=="ADD")
{

	try
		{
		Class.forName("com.mysql.jdbc.Driver"); // step-1
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/revise","root","");
				Statement smt=con.createStatement(); // step-3
	String qr="insert into  form(College,Name,Rollno,Marks)values('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";

			int i=smt.executeUpdate(qr);
	if(i>0)
	{
		System.out.println("record inserted");
		System.out.println();
		System.out.println();
		System.out.println("-----------");

		}


	}
	catch(Exception ea)
	{}


}}
public static void main(String a[])
{
	jdbcrevise ss=new jdbcrevise();
	}
}