import java.sql.*;
class conc
{
int flag=0;
	conc(String company,String itemtype,Integer item_qty,Integer item_price)
	{
System.out.println("helo..");
		try

		{


//Integer total=item_qty*item_price;

//connect rt=new connect();
Class.forName("com.mysql.jdbc.Driver"); // step-1
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/PROJ","root","");
		Statement smt=con.createStatement(); // step-3
		String br="select * from bag where company='"+company+"' and (itemtype='"+itemtype+"')";
		ResultSet ros=smt.executeQuery(br);
		String qt="";
while(ros.next())
{
	flag=1;
qt=ros.getString("item_qty");

}

Integer xx=Integer.parseInt(qt);
Integer newqty=xx+item_qty;


if (flag==0)
{
String qr="insert into  bag(company,itemtype,item_qty,item_price)values('"+company+"','"+itemtype+"','"+item_qty+"','"+item_price+"')";

		int i=smt.executeUpdate(qr);
if(i>0)
{
	System.out.println("record inserted");
	System.out.println();
	System.out.println();
	System.out.println("-----------");

	}

String dd="select * from bag";

ResultSet rs=smt.executeQuery(dd);

ResultSetMetaData meta = rs.getMetaData();
String col1=meta.getColumnLabel(1);
String col2=meta.getColumnLabel(2);
String col3=meta.getColumnLabel(3);
String col4=meta.getColumnLabel(4);
//String col5=meta.getColumnLabel(5);


//System.out.println(col1+"		 "+col2+"		 "+col3+"		 "+col4+"		 "+col5);
while(rs.next())
{

	System.out.println(rs.getString(1)+"			"+rs
	.getString(2)+"			"+rs.getString(3)+"			"+rs.getString(4));

	}
}
else
{

	String gr=("update bag set item_qty='"+newqty+"' where company='"+company+"' and (itemtype='"+itemtype+"')");
	int i=smt.executeUpdate(gr);

	}
}
catch(Exception ae)
{}


	}


}