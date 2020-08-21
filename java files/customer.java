import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class customer implements ActionListener
{
 static JFrame f;
JButton b1,b2,b3;
JTextField t1,t2,t4,t3;
JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
Double sum=0.0;
Integer q=0;
JComboBox <String> combo;
JComboBox <String> combo1;
//JComboBox <String> combo2;
String qty="";
String price="";
String  str,ctr;
customer()
{
f=new JFrame();
	f.setVisible(true);
				f.setSize(700,800);
		f.setLayout(null);
String company[] = {"--choose company --","VIP","SAFARI","ARISTOCRAT","HARMONY"};
String type[] = {"--choose bag type --","laptop bag","school/college bag","travelling bag","suitcase","trolly"};

		f.setTitle("Event Demo");
		//f.setBackground(Color.blue);

		lb5= new JLabel("Customer name== ");
lb6= new JLabel("");
lb7= new JLabel("");

		lb1= new JLabel("Company== ");
		lb2= new JLabel("Type== ");
		lb3= new JLabel("Number== ");
		lb4= new JLabel("");


		t1= new JTextField();
		//t2= new JTextField();
		t3= new JTextField();
		t4= new JTextField();
	b1= new JButton("SUBMIT");
		b2= new JButton("BILL");
		b3= new JButton("BACK");

//JPanel panel = new JPanel();
		combo = new JComboBox<String>(company);
		combo1= new JComboBox<String>(type);
//combo2= new JComboBox<String>(no);


    lb5.setBounds(30,10,300,40);
     t1.setBounds(210,10,120,40);
	lb1.setBounds(30,60,150,40);
	combo.setBounds(210,60,220,40);
	lb6.setBounds(500,60,300,40);
	//combo.setBounds(340,50,220,40);

	lb2.setBounds(30,110,150,40);
	combo1.setBounds(210,110,220,40);


//t2.setBounds(210,300,120,40);
	lb3.setBounds(30,170,150,40);
	t3.setBounds(210,170,120,40);
	lb4.setBounds(30,230,150,40);
	t4.setBounds(210,230,120,40);
		lb7.setBounds(400,230,300,40);
//combo2.setBounds(210,500,220,40);
	b1.setBounds(100,300,120,40);
		b2.setBounds(200,300,120,40);
		b3.setBounds(350,300,120,40);

//f.add(combo2);
	f.add(lb1);
f.add(combo);
f.add(lb6);
	f.add(t1);
	f.add(lb2);
	f.add(combo1);
//f.add(t2);
	f.add(lb5);
f.add(lb3);
	f.add(t3);
f.add(lb4);
	//f.add(t4);
f.add(lb7);
f.add(b2);
	f.add(b1);
		f.add(b3);

	combo.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent ie){
					 str = (String)combo.getSelectedItem();
					t3.setText("");
					lb4.setText("total price==");
					//combo1.getSelectedIndexItem();
 combo1.setSelectedIndex(0);



				}
		});
		combo1.addItemListener(new ItemListener(){
						public void itemStateChanged(ItemEvent i){
							 ctr = (String)combo1.getSelectedItem();


	try
	{
	Class.forName("com.mysql.jdbc.Driver"); // step-1
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJ","root","");
			Statement smt=con.createStatement(); // step-3
String dd="select * from bag where company ='"+str+"' and itemtype='"+ctr+"'";


ResultSet rs=smt.executeQuery(dd);
while(rs.next())
{

	qty=rs.getString("item_qty");
	price=rs.getString("item_price");
}
lb6.setText("quantity is =="+qty);

lb7.setText("price of each "+ctr+" is=="+price);
int num=Integer.parseInt(qty);

/*for(int j=1;j<=num;j++)
{
	no.addItem("helo");
}*/


}
catch(Exception eee)
{
	System.out.println(eee);
	}



							//t2.setText(ctr);




						}
		});
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);

	}



public void actionPerformed(ActionEvent ae)
{if(ae.getActionCommand()=="BACK")
{

	welcome re=new welcome();
	f.setVisible(false);}


if(ae.getActionCommand()=="SUBMIT")
	{

		//System.out.println("ok");
		Integer i=Integer.parseInt(t3.getText());
		Integer a=Integer.parseInt(price);
Integer qnt=Integer.parseInt(qty);

Integer p=i*a;
if(i>qnt)
{
	JOptionPane.showMessageDialog(f,"Number of goods not available in stock");
}
else
{
lb4.setText("total price=="+p.toString());
sum=sum+p;
q=q+i;
}

}
if(ae.getActionCommand()=="BILL")
{
String nm=t1.getText();
//Integer i=Integer.parseInt(t3.getText());

	rd r=new rd(nm,str,ctr,q,sum);
	f.setVisible(false);





	}
}

public static void main(String a[])
{
	customer cus=new customer();
	}
}