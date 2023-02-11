package Logic;
import entity.Tele_Exchange;
import java.sql.*;
import java.util.*;
import connector.Connector;



public class Logic_For_Tele_Exchange extends CustomerLogic { 
	static Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public boolean addTeleExchange(Tele_Exchange te)
	{
		con=Connector.getCon();
		boolean b=false;
		try {
			ps=con.prepareStatement("insert into Tele_Exchange values(?,?,?)");
			ps.setInt(1,te.getTeid());
			ps.setInt(2,te.getEcode());
			
			ps.setString(3,te.getAddre());
			
			int r=ps.executeUpdate();
			if(r==1)
				b=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(ps!=null)
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			try
			{
			if(con!=null)
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return b;
	}
	
	public boolean deleteTeleExchange(int x)
	{
		con=Connector.getCon();
		boolean b=false;
		try
		{
			ps=con.prepareStatement("delete from Tele_Exchange where Teid=?");
			ps.setInt(1, x);
			int r=ps.executeUpdate();
			if(r==1)
				b=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(ps!=null)
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			try
			{
			if(con!=null)
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return b;
	}
	public Tele_Exchange showCustById(int x)
	{
		con=Connector.getCon();
		Tele_Exchange obj=new Tele_Exchange();
		try
		{
			ps=con.prepareStatement("select * from Customer where id=?");
			ps.setInt(1,x);
			rs=ps.executeQuery();
			while(rs.next())
				
			{
				obj.setId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setPhno(rs.getLong(3));
				obj.setAddr(rs.getString(4));
				obj.setCode(rs.getInt(5));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
			if(rs!=null)
				rs.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			try
			{
			if(ps!=null)
				ps.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			try
			{
			if(con!=null)
				con.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return obj;
	}
	public List<Tele_Exchange> showAllCust()
	{
		List<Tele_Exchange> lte =new ArrayList<Tele_Exchange>();
		Tele_Exchange te=null;
		con=Connector.getCon();
		try {
			ps=con.prepareStatement("select * from Customer");
			rs=ps.executeQuery();
			while(rs.next())
			{
				te=new Tele_Exchange();
				te.setId(rs.getInt(1));
				te.setName(rs.getString(2));
				te.setPhno(rs.getLong(3));
				te.setAddr(rs.getString(4));
				te.setCode(rs.getInt(5));
				lte.add(te);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
			if(rs!=null)
				rs.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			try
			{
			if(ps!=null)
				ps.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			try
			{
			if(con!=null)
				con.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return lte;
	}
	
	public List<Tele_Exchange> showAllTeleExchange()
	{
		List<Tele_Exchange> lte =new ArrayList<Tele_Exchange>();
		Tele_Exchange te=null;
		con=Connector.getCon();
		try {
			ps=con.prepareStatement("select * from Tele_Exchange");
			rs=ps.executeQuery();
			while(rs.next())
			{
				te=new Tele_Exchange();
				te.setTeid(rs.getInt(1));
				te.setEcode(rs.getInt(2));
				te.setAddr(rs.getString(3));
				
				lte.add(te);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
			if(rs!=null)
				rs.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			try
			{
			if(ps!=null)
				ps.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			try
			{
			if(con!=null)
				con.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return lte;
	}
	
	public Tele_Exchange innerJoinByNo(Long Phno)
	{
		Tele_Exchange te=new Tele_Exchange();
		con=Connector.getCon();
		try
		{
			ps=con.prepareStatement("select * from Tele_Exchange inner join Customer on Tele_Exchange.Ecode=Customer.Code where Phno=?");
			ps.setLong(1,Phno);
			rs=ps.executeQuery();
			while(rs.next())
			{
				te.setTeid(rs.getInt(1));
				te.setEcode(rs.getInt(2));
				te.setAddre(rs.getString(3));
				te.setId(rs.getInt(4));
				te.setName(rs.getString(5));
				te.setAddr(rs.getString(6));
				te.setPhno(rs.getLong(7));
				te.setCode(rs.getInt(8));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
			if(rs!=null)
				rs.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			try
			{ 
			if(ps!=null)
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			try
			{
			if(con!=null)
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return te;
	}
}
