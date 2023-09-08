import java.io.IOException;

public class TipodiGioco {
  public TipodiGioco()  {
 
 }
	public int Aggiungi(String tipo,String descrizione,String forma,String capacità,String marca)
	{
		try
		{
			String sqlcommand="insert into tipodigioco ";
			sqlcommand = sqlcommand + "values('" + tipo +"','"+descrizione+"','"+ forma +"','"+capacità+"','"+marca+"')";
			
			
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
			String sqlcommand="delete from tipodigioco where tipo='" + tipo+"'";
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
	public int Aggiorna(String tipo,String descrizione,String forma,String capacità,String marca)
	{
		try
		{

			String sqlcommand="update tipodigioco ";
			sqlcommand = sqlcommand + "set Descrizione='" +descrizione+"', Forma='"+forma+"', capacità='"+capacità+"', marca='"+marca+"'";
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