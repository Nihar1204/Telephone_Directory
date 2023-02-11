package Logic;
import java.sql.*;
import connector.Connector;
import entity.*;


public class CustomerLogic {
	static Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public boolean addCust(Tele_Exchange te)
	{
		con=Connector.getCon();
		boolean b=false;
		try {
			ps=con.prepareStatement("insert into Customer values(?,?,?,?,?)");
			ps.setInt(1,te.getId());
			ps.setString(2,te.getName());
			ps.setLong(3,te.getPhno());
			ps.setString(4,te.getAddr());
			ps.setInt(5,te.getCode());
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
	
	public boolean updateAddress(int id,String Addr1)
	{
		con=Connector.getCon();
		boolean b=false;
		try 
		{
			ps=con.prepareStatement("update Customer set Addr=? where Id=?");
			ps.setString(1, Addr1);
			ps.setInt(2, id);
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
	public boolean deleteCust(int id)
	{
		con=Connector.getCon();
		boolean b=false;
		try
		{
			ps=con.prepareStatement("delete from Customer where id=?");
			
			ps.setInt(1, id);
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
	public Tele_Exchange showById(int x)
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
}
	

