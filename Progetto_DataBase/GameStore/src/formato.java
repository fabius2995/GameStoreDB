import java.io.IOException;

public class formato {
  public formato()  {
 
 }
	public int Aggiungi(String tipo,String IDGioco)
	{
		try
		{
			String sqlcommand="insert into formato ";
			sqlcommand = sqlcommand + "values('" + tipo +"',"+IDGioco+")";
			
			
			System.out.println(sqlcommand);
			SQL sqlexec = new SQL();
			sqlexec.execute(sqlcommand);
			
			return 0;
		}
		catch(PersonException pex)
		{
			try
			{
				System.out.println("Eccezione"+pex.getMessage());
				ScriviLog Sl = new ScriviLog();
				Sl.Scrivi("LogDip.txt","Errore di Inserimento: " + pex.getMessage());
				return 1;
			}
			catch(IOException ex)
			{
				return 1;
			}
		}
	}

	public int Cancella( String tipo) 
	{
		try
		{
			String sqlcommand="delete from formato where tipo='" + tipo+"'";
			System.out.println(sqlcommand);
			SQL sqlexec=new SQL();
			sqlexec.execute(sqlcommand);
			return 0;
		}
		catch(PersonException pex)
		{
			try
			{
				ScriviLog Sl = new ScriviLog();
				Sl.Scrivi("LogDip.txt","Errore di cancellazione :" + pex.getMessage());
				return 1;
			}
			catch(IOException ex)
			{
				return 1;
			}

		}
	}
	public int Aggiorna(String tipo,String IDGioco)
	{
		try
		{

			String sqlcommand="update formato ";
			sqlcommand = sqlcommand + "set IDGioco='" +IDGioco+"'";
			sqlcommand =sqlcommand + " where tipo='"+tipo+"'";
			System.out.println(sqlcommand);
			SQL sqlexec = new SQL();
			sqlexec.execute(sqlcommand);
			return 0;
		}
		catch(PersonException pex)
		{
			try
			{
				ScriviLog Sl = new ScriviLog();
				Sl.Scrivi("LogDip.txt"," Errore di Aggiornamneto. " + pex.getMessage());
				return 1;
			}
			catch(IOException ex)
			{
				return 1;
			}

		}


	}
	
	public String Execquery(String sqlcommand) 
	{
		try
		{
			SQL esegui=new SQL();
			return esegui.execquery(sqlcommand);
		}

		catch(PersonException pex)
		{
			try
			{
				System.out.println("Eccezione "+pex.getMessage());
				ScriviLog Sl = new ScriviLog();
				Sl.Scrivi("LogDip.txt","Errore di Lettura : " +pex.getMessage());
				return "1";
			}
			catch(IOException ex)
			{
				return "1";
			}

		}
	
	}

 
}