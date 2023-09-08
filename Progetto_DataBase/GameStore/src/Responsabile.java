
import java.io.IOException;

public class Responsabile  {
  public Responsabile()  {
 
 }
	public int Aggiungi(String Matricola,String Cognome,String Nome,String DatadiNascita, String DatadiAssunzione,String Stipendio,String Residenza)
	{
		try
		{
			String sqlcommand="insert into responsabile ";
			sqlcommand = sqlcommand + "values(" + Matricola +",'"+Cognome+"','"+Nome+"','"+DatadiNascita+"','"+DatadiAssunzione+"',"+Stipendio+",'"+Residenza+"')";
		
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

	public int Cancella( String cod) 
	{
		try
		{
			String sqlcommand="delete from responsabile5"
					+ " where ID_Responsabile=" + cod;
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
	public int Aggiorna(String codice,String campo, String valore) 
	{
		try
		{

			String sqlcommand="update responsabile ";
			sqlcommand = sqlcommand + "set "+ campo +" ='" +valore+"'";
			sqlcommand =sqlcommand + " where ID_Responsabile="+codice;
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
				Sl.Scrivi("LogDip.txt"," Errore di Aggiornamento. " + pex.getMessage());
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

