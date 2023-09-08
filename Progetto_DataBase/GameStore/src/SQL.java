
import java.sql.*;


public class SQL 
{

	public SQL()
	{
	   }

	public boolean execute(String command) throws PersonException
	{

		try
		{
			//Definisco il tipo di driver da utilizzare
			//In questo caso utilizzo il driver standard della sun
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/gamestore";
			//Utilizzo la classe Connection per connettermi
			Connection connection=DriverManager.getConnection(url,"root","");
			//Utilizzo la classe statement per creare uno statement di esecuzione.
			Statement statement = connection.createStatement();
			//eseguo la query chiamando il metodo executeUpdate di statement
			int n  = statement.executeUpdate(command);
			
			//Chiudo la connessione al database
			statement.close();
			return true;
		}
		catch(SQLException ex)
		{
			throw new PersonException(ex.getMessage());
	
		}
		catch (ClassNotFoundException cnfe) 
		{
			throw new PersonException( cnfe.getMessage() );
		}
	}

	public String execquery(String command)throws PersonException
	{
		try
		{
			//Definisco il tipo di driver da utilizzare
			//In questo caso utilizzo il driver standard della sun
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/gamestore";
			//Utilizzo la classe Connection per connettermi
			Connection connection=DriverManager.getConnection(url,"root","");
			//Utilizzo la classe statement per creare uno statement di esecuzione.

			Statement statement = connection.createStatement();

			//eseguo la query chiamando il metodo executeQuery di statement
		     //System.out.println(command);
			
			ResultSet r = statement.executeQuery(command);
			if (r==null)
			{
				
			}
			StringBuffer s = new StringBuffer();
			ResultSetMetaData rmeta = r.getMetaData();
			int numColumns=rmeta.getColumnCount();
			String p;
			//System.out.println(numColumns);
			for(int i=1;i<=numColumns;++i)
			{
				if(i<numColumns)
				{
					int k=rmeta.getColumnName(i).length();
					p=rmeta.getColumnName(i)+" ";
					for (int j=0;j<30-k;j++)
						  p=p+" ";
					   s.append(p);
					   //s.append(rmeta.getColumnName(i)+"    |    ");
				}
				else
					s.append(rmeta.getColumnName(i));
			}
			s.append("\n");
			for(int j=1;j<30*numColumns;j++)
			   s.append("-");
			s.append("\n");
			while(r.next())
			{
				for(int i=1;i<=numColumns;++i)
				{
					if(i<numColumns){
						int k=r.getString(i).length();
						p=r.getString(i)+" ";
						for (int j=0;j<30-k;j++)
							  p=p+" ";
						   s.append(p);
						//s.append(r.getString(i)+"     |      ");
					}
					else
						s.append(r.getString(i).trim());
				}
				s.append("\n");
			}
			//Chiudo la connessione al database
			connection.close();
			return s.toString();

		}
		catch(SQLException ex)
		{
		    throw new PersonException(ex.getMessage());
			

		}

		catch (ClassNotFoundException cnfe) 
		{
			throw new PersonException( cnfe.getMessage() );
		}
	}
}
