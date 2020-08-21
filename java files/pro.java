import java.awt.event.*;
import javax.swing.*;
class pro implements ActionListener
{
 static JFrame f;
JButton b1,b2;
JTextField t1,t2,t3,t4;
JLabel lb1,lb2,lb3,lb4;
JComboBox <String> combo;
JComboBox <String> combo1;

String  str,ctr;
pro()
{f=new JFrame();


	f.setVisible(true);
				f.setSize(700,800);
		f.setLayout(null);
String company[] = {"--choose company --","VIP","SAFARI","ARISTOCRAT","HARMONY"};
String type[] = {"--choose bag type --","laptop bag","school/college bag","travelling bag","suitcase","trolly"};

		f.setTitle("Event Demo");
		//f.setBackground(Color.blue);


		lb1= new JLabel("Company== ");
		lb2= new JLabel("Type== ");
		lb3= new JLabel("Price== ");
		lb4= new JLabel("Number== ");


	//	t1= new JTextField();
	//	t2= new JTextField();
		t3= new JTextField();
		t4= new JTextField();
	b1= new JButton("SUBMIT");
	b2= new JButton("BACK");
//JPanel panel = new JPanel();
		combo = new JComboBox<String>(company);
		combo1= new JComboBox<String>(type);

	lb1.setBounds(30,50,150,40);
	combo.setBounds(210,50,220,40);
	//combo.setBounds(340,50,220,40);

	lb2.setBounds(30,110,150,40);
	combo1.setBounds(210,110,220,40);

//	t2.setBounds(210,110,120,40);
	lb3.setBounds(30,170,150,40);
	t3.setBounds(210,170,120,40);
	lb4.setBounds(30,230,150,40);
	t4.setBounds(210,230,120,40);

	b1.setBounds(100,300,120,40);
	b2.setBounds(400,300,120,40);
f.add(b2);
	f.add(lb1);
f.add(combo);

	//f.add(t1);
	f.add(lb2);
	f.add(combo1);

	//f.add(t2);
f.add(lb3);
	f.add(t3);
f.add(lb4);
	f.add(t4);

	f.add(b1);
	combo.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent ie){
					 str = (String)combo.getSelectedItem();

					//t1.setText(str);
				}
		});
		combo1.addItemListener(new ItemListener(){
						public void itemStateChanged(ItemEvent i){
							 ctr = (String)combo1.getSelectedItem();
							//t1.setText(str);
						}
		});
	b1.addActionListener(this);
	b2.addActionListener(this);

	}



public void actionPerformed(ActionEvent ae)
{
if(ae.getActionCommand()=="BACK")
{

	welcome jh=new welcome();
	f.setVisible(false);
}

if(ae.getActionCommand()=="SUBMIT")
	{
		Integer item_qty=Integer.parseInt(t4.getText());
	Integer item_price=Integer.parseInt(t3.getText());


//str = (String)combo.getSelectedItem();
		String company=str;
			String itemtype=ctr;


	conc cc=new conc(company,itemtype,item_qty,item_price);

}

}

public static void main(String ar[])
{

	new pro();

}
}