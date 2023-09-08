
import java.util.Scanner;


public class MenuTipodiGioco 
{
	
	public void gestisci()
	{
		int x;
		try 
		{
			TipodiGioco tipog = new TipodiGioco();
			
			Scanner in = new Scanner(System.in);
			String sqlcommand = "select * from tipodigioco";
			String risultato="";
			String tipo="";

			String descrizione="";
			String forma="";
			String capacità="";
			String marca="";
			
			do
			{
			System.out.println("Gestione tabella TIPODIGIOCO\nSelezionare una Operazione");
			System.out.println("1.Aggiungi, 2.Cancella, 3.Aggiorna, 4.Stampa, 0 Torna al menu precedente");
	        x= in.nextInt();

			switch(x)
			{
			
			case 1: 
			risultato= tipog.Execquery(sqlcommand);
			System.out.println(risultato);
			System.out.println("Immettere Tipo, Descrizione, Forma, Capacità, Marca");

			tipo=in.next();
			descrizione=in.next();
			forma=in.next();
			capacità=in.next();
			marca=in.next();
			
			tipog.Aggiungi(tipo, descrizione, forma, capacità, marca);
			risultato= tipog.Execquery(sqlcommand);
	        System.out.println(risultato);
	        break;
	             
			case 2: 
				risultato= tipog.Execquery(sqlcommand);
				System.out.println(risultato);
				System.out.println("Immettere Tipo ");

				tipo=in.next();
				tipog.Cancella(tipo);
				risultato= tipog.Execquery(sqlcommand);
		        System.out.println(risultato);
		           break;
			
			case 3: 
				risultato= tipog.Execquery(sqlcommand);
				System.out.println(risultato);
				System.out.println("Immettere Tipo Descrizione Forma Capacità Marca");

				tipo=in.next();
				descrizione=in.next();
				forma=in.next();
				capacità=in.next();
                marca=in.next();
				tipog.Aggiorna(tipo, descrizione, forma, capacità,marca);
		
				risultato= tipog.Execquery(sqlcommand);
		        System.out.println(risultato);
		           break;
		           
			case 4: 
				risultato= tipog.Execquery(sqlcommand);
				System.out.println(risultato);
				

				
		           break;
		           
			default:
				   break;
			}
				        
			}       
				 while(x!= 0); 
	    
			}
			
		
	      catch(Exception e){
	    	  System.out.println("sono andato in eccezione");
	    	  System.out.println(e.getMessage());
		
	       }
}
}