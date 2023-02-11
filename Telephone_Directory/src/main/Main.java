package main;
import Logic.Logic_For_Tele_Exchange;
import entity.Tele_Exchange;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Tele_Exchange te=new Tele_Exchange();
		Logic_For_Tele_Exchange le=new Logic_For_Tele_Exchange();
		while(true)
		{
			System.out.println("1: Are You a Customer!");
			System.out.println("2: Are You a Tele_Exchange Employee!");
			System.out.println("Choose your option!");
			int n=sc.nextInt();
			System.out.println("------------------------------------");
			switch(n)
			{
			case 1:
				System.out.println("1: For Registration!");
				System.out.println("2: Request/Complain!");
				System.out.println("Choose your option!");
				int n1=sc.nextInt();
				System.out.println("------------------------------------");
				switch(n1)
				{
				case 1:
					System.out.println("We are generating a Id for You...");
					int Id=sc.nextInt();
					System.out.println("We are Giving a Code for You...");
					int Code=sc.nextInt();
					System.out.println("We are generating a Phone no. for You...");
					long Phno=sc.nextLong();
					sc.nextLine();
					System.out.println("What is your name!");
					String Name=sc.nextLine();
					System.out.println("What is your Address!");
					String Addr=sc.next();
					
					te.setId(Id);
					te.setName(Name);
					te.setPhno(Phno);
					te.setAddr(Addr);
					te.setCode(Code);
					boolean r=le.addCust(te);
					if(r==true)
						System.out.println("Added Successfully...");
					System.out.println("------------------------------------");
					break;
					
				case 2:
					System.out.println("1: For Update my Address!");
					System.out.println("2: For delete my account!");
					System.out.println("3: Show my data!");
					System.out.println("Choose your option!");
					int n2=sc.nextInt();
					
					System.out.println("------------------------------------");
					switch(n2)
					{
					case 1:
					System.out.println("What is your code!");
					int code=sc.nextInt();
					sc.nextLine();
;					System.out.println("What is your Address!");
					String Addr1=sc.next();
					boolean r1=le.updateAddress(code, Addr1);
					if(r1==true)
						System.out.println("Updated Successfully...");
					System.out.println("------------------------------------");
					break;
					case 2:
						System.out.println("What is your ID!");
						int id=sc.nextInt();
						boolean r2=le.deleteCust(id);
						if(r2==true)
							System.out.println("Deleted Successfully...");
						System.out.println("------------------------------------");
						break;
						
					case 3:
						System.out.println("What is your id!");
						int id1=sc.nextInt();
						Tele_Exchange obj=le.showById(id1);
						System.out.println("Your Id: "+obj.getId());
						System.out.println("Your Name: "+obj.getName());
						System.out.println("Your Phone no: "+obj.getPhno());
						System.out.println("Your Address: "+obj.getAddr());
						System.out.println("Your Code: "+obj.getCode());
						System.out.println("------------------------------------");
						break;
					}
					
				}
				break;
			case 2:
				System.out.println("1: Add Own Data!");
				System.out.println("2: Remove a Customer!");
				System.out.println("3: Show by Id!");
				System.out.println("4: Show All!");
				System.out.println("5: Show TeleExchange!");
				System.out.println("6: Inner Join By Phone Number!");
				//System.out.println("7: Inner Join!");
				
				System.out.println("Choose your option!");
				int n3=sc.nextInt();
				switch(n3)
				{
				case 1:
					System.out.println("Enter Telephone Exchange Id");
					int Teid=sc.nextInt();
					System.out.println("Enter Pass Code");
					int Ecode=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the Address");
					String Addre=sc.nextLine();
					te.setTeid(Teid);
					te.setEcode(Ecode);
					te.setAddre(Addre);
					boolean r=le.addTeleExchange(te);
					if(r==true)
						System.out.println("Data Added Successfully...");
					System.out.println("------------------------------------");
					break;
				case 2:
					System.out.println("Enter The Customer's Id");
					int id=sc.nextInt();
					boolean r1=le.deleteTeleExchange(id);
					if(r1==true)
						System.out.println("Removed Successfully...");
					System.out.println("------------------------------------");
					break;
				case 3:
					System.out.println("Enter Telephone Exchange Id");
					int id1=sc.nextInt();
					Tele_Exchange obj=le.showById(id1);
					System.out.println("Your Id: "+obj.getId());
					System.out.println("Your Name: "+obj.getName());
					System.out.println("Your Phone no: "+obj.getPhno());
					System.out.println("Your Address: "+obj.getAddr());
					System.out.println("Your Code: "+obj.getCode());
					System.out.println("------------------------------------");
					break;
				case 4:
					List<Tele_Exchange> lte=le.showAllCust();
					for(Tele_Exchange lt:lte)
					{
						System.out.println("Your Id: "+lt.getId());
						System.out.println("Your Name: "+lt.getName());
						System.out.println("Your Phone no: "+lt.getPhno());
						System.out.println("Your Address: "+lt.getAddr());
						System.out.println("Your Code: "+lt.getCode());
					}
					System.out.println("------------------------------------");
					break;
				case 5:
					List<Tele_Exchange> lte1=le.showAllTeleExchange();
					for(Tele_Exchange lt:lte1)
					{
						System.out.println("Telecom Id: "+lt.getTeid());
						System.out.println("Telecom PassCode: "+lt.getEcode());
						System.out.println("Telecom Address: "+lt.getAddre());
					}
					System.out.println("------------------------------------");
					break;
				case 6:
					System.out.println("Enter The Phone Number!");
					long lo=sc.nextLong();
					Tele_Exchange tex=le.innerJoinByNo(null);
					if(lo==tex.getPhno())
					{
						System.out.println("Teid: "+tex.getTeid()+" Ecode: "+tex.getEcode()+" Addre: "+tex.getAddre()+" Id:"+tex.getId()+" Name: "+tex.getName()+" Phno: "+tex.getPhno()+" Addr: "+tex.getAddr()+" Code: "+tex.getCode());
					}
					break;
				
				}
			}
		}

	}

}
