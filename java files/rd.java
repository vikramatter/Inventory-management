import javax.swing.*;
import java.awt.event.*;
import java.util.*;
//import java.text.*;*/
import java.sql.*;
class rd implements ActionListener
{
JFrame f;
int flag=0;
JButton b1,b2;
JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
String ii,pp,dt,no,name,typ,comp;Integer jj;
rd(String nm,String str,String ctr,Integer j,Double sum)
{
	 ii=j.toString();
	 pp=sum.toString();

Random r= new Random();
Integer i=r.nextInt(100);
System.out.println("random number  is =="+i*10+20);
 long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
/*DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
Date date = new Date();
System.out.println(dateFormat.format(date));*/
 dt=date.toString();
 no=i.toString();
f=new JFrame("billdemo");
lb1=new JLabel("Date==="+dt);
lb2=new JLabel("Bill no=="+no);
lb3=new JLabel("custome name=="+nm);
lb4=new JLabel("company name=="+str);
lb5=new JLabel("type=="+ctr);
lb6=new JLabel("quantity=="+ii);
lb7=new JLabel("grand total=="+pp);
b1=new JButton("BACK");
b2=new JButton("DONE");
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
b2.setBounds(240,400,100,40);
f.add(b1);
f.add(b2);
f.add(lb1);
f.add(lb2);
f.add(lb3);
f.add(lb4);
f.add(lb5);

f.add(lb6);f.add(lb7);
b1.addActionListener(this);
b2.addActionListener(this);
name=nm;
comp=str;
typ=ctr;
jj=j;
}
public void actionPerformed(ActionEvent ae)
{
if (ae.getSource()==b1)
{
customer cc=new customer();
f.setVisible(false);


}
if (ae.getSource()==b2)
{
cust c=new cust(no,dt,name,comp,typ,ii,pp);
try
{
Class.forName("com.mysql.jdbc.Driver"); // step-1
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJ","root","");
		Statement smt=con.createStatement(); // step-3
		String br="select * from bag where company='"+comp+"' and (itemtype='"+typ+"')";
		ResultSet ros=smt.executeQuery(br);
		String qt="";
while(ros.next())
{
	flag=1;
qt=ros.getString("item_qty");

}

Integer xx=Integer.parseInt(qt);
Integer newqty=xx-jj;

if(flag==1)
{

	String gr=("update bag set item_qty='"+newqty+"' where company='"+comp+"' and (itemtype='"+typ+"')");
	int i=smt.executeUpdate(gr);

	}
}//end of try
catch(Exception ee)
{}


	JOptionPane.showMessageDialog(f,"receipt printed");
	welcome we=new welcome();
f.setVisible(false);

}//end of if buttonb2



}//end of actionlistner




}