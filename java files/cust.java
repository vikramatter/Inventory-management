import java.sql.*;
class cust
{
int flag=0;
	cust(String bill,String date,String name,String company,String type,String qty,String tot)
	{

		try

		{


//Integer total=item_qty*item_price;

//connect rt=new connect();
Class.forName("com.mysql.jdbc.Driver"); // step-1
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJ","root","");
		Statement smt=con.createStatement(); // step-3

String qr="insert into  cust(bill_no,date,name,company,type,quantity,total)values('"+bill+"','"+date+"','"+name+"','"+company+"','"+type+"','"+qty+"','"+tot+"')";

		int i=smt.executeUpdate(qr);
if(i>0)
{
	System.out.println("record inserted");
	System.out.println();
	System.out.println();
	System.out.println("-----------");

	}


}
catch(Exception ae)
{}


	}


}