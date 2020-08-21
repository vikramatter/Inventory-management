import javax.swing.*;
import java.awt.event.*;
import java.util.*;
//import java.text.*;*/
import java.sql.*;
class ending implements ActionListener
{
JFrame f;
int flag=0;
JButton b1;
JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
String bill="",name="",dt="",comp="",typ="",qty="",total="";
ending(String bn,String nm)
{f=new JFrame("billdemo");
lb1=new JLabel();
lb2=new JLabel();
lb3=new JLabel();
lb4=new JLabel();
lb5=new JLabel();
lb6=new JLabel();
lb7=new JLabel();
b1=new JButton("BACK");

f.setVisible(true);
f.setLayout(null);
f.setSize(900,900);
lb1.setBounds(40,40,300,40);
lb2.setBounds(600,40,300,40);
lb3.setBounds(40,140,300,40);
lb4.setBounds(40,200,300,40);
lb5.setBounds(40,240,300,40);
lb6.setBounds(40,300,300,40);
lb7.setBounds(40,340,300,40);

b1.setBounds(40,400,100,40);
//b2.setBounds(240,400,100,40);
f.add(b1);
//f.add(b2);
f.add(lb1);
f.add(lb2);
f.add(lb3);
f.add(lb4);
f.add(lb5);

f.add(lb6);f.add(lb7);









	try
	{
	Class.forName("com.mysql.jdbc.Driver"); // step-1
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJ","root","");
			Statement smt=con.createStatement(); // step-3
String dd="select * from cust where name ='"+nm+"' and bill_no='"+bn+"'";


ResultSet rs=smt.executeQuery(dd);
while(rs.next())
{
flag=1;
bill=rs.getString("bill_no");
dt=rs.getString("date");
name=rs.getString("name");
comp=rs.getString("company");

typ=rs.getString("type");

	qty=rs.getString("quantity");
	total=rs.getString("total");
}



if(flag==1)
{lb1.setText("bill no =="+bill);
lb2.setText("date =="+dt);
lb3.setText("name =="+name);
lb4.setText("company =="+comp);
lb5.setText("type =="+typ);

lb6.setText("quantity is =="+qty);

lb7.setText("amount paid=="+total);

}
else
{JOptionPane.showMessageDialog(f,"record not found, try again!!");}


}
catch(Exception eee)
{
	System.out.println(eee);
	}






	b1.addActionListener(this);






	}


	public void actionPerformed(ActionEvent ae)
	{
	if (ae.getSource()==b1)
	{
	welcome wc=new welcome();
f.setVisible(false);

}}


	}