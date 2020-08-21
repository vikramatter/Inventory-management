import java.sql.*;
class connect
{

	connect(String cid,String name,String city)
	{
		try
		{




//connect rt=new connect();
Class.forName("com.mysql.jdbc.Driver"); // step-1
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myjava","root","");
		Statement smt=con.createStatement(); // step-3
String qr="insert into  student(id,name,city)values('"+cid+"','"+name+"','"+city+"')";

		int i=smt.executeUpdate(qr);
if(i>0)
{
	System.out.println("record inserted");
	System.out.println();
	System.out.println();
	System.out.println("-----------");

	}

String dd="select * from student";


ResultSet rs=smt.executeQuery(dd);

ResultSetMetaData meta = rs.getMetaData();
String col1=meta.getColumnLabel(1);
String col2=meta.getColumnLabel(2);
String col3=meta.getColumnLabel(3);


System.out.println(col1+"\t"+col2+"\t"+col3);
while(rs.next())
{

	System.out.println(rs.getString("id")+"\t"+rs
	.getString("name")+"\t"+rs.getString(3));

	}

}
catch(Exception ae)
{}


	}


}















