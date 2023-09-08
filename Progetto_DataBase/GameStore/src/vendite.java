
import java.io.IOException;

public class vendite  {
  public vendite()  {
 
 }
	public int Aggiungi(String IDGioco,String Cod_ID,String Matricola, String quant,String iva,String totvend)
	{
		try
		{
			String sqlcommand="insert into vendite ";
			sqlcommand = sqlcommand + "values(" + IDGioco +","+Cod_ID+","+Matricola+","+quant+","+iva+","+totvend+ ")";
		
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

	public int Cancella( String IDGioco,String Cod_ID,String Matricola) 
	{
		try
		{
			String sqlcommand="delete from vendite where IDGioco=" + IDGioco +" and Cod_ID="+Cod_ID+" and Matricola="+Matricola;
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
	public int Aggiorna( String IDGioco,String Cod_ID,String Matricola,String campo, String valore) 
	{
		try
		{

			String sqlcommand="update vendite ";
			sqlcommand = sqlcommand + "set "+ campo +" ='" +valore+"'";
			sqlcommand = sqlcommand + " where IDGioco=" + IDGioco +" and Cod_ID="+Cod_ID+" and Matricola="+Matricola;
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

