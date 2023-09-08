
import java.io.IOException;

public class Gioco  {
  public Gioco()  {
 
 }
	public int Aggiungi(String IDGioco,String Titolo,String Prezzo,String Quantità,String Console)
	{
		try
		{
			String sqlcommand="insert into gioco ";
			sqlcommand = sqlcommand + "values(" + IDGioco +",'"+Titolo+"','"+ Prezzo +"','"+Quantità+"','"+Console+"')";
			
			
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
			String sqlcommand="delete from gioco where IDGioco=" + cod;
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
	public int Aggiorna(String IDGioco,String Titolo,String Prezzo,String Quantità,String Console) 
	{
		try
		{

			String sqlcommand="update gioco ";
			sqlcommand = sqlcommand + "set Titolo='" +Titolo+"', Prezzo='"+Prezzo+"', Quantità='"+Quantità+"', Console='"+Console+"'";
			sqlcommand =sqlcommand + " where IDGioco="+IDGioco;
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
