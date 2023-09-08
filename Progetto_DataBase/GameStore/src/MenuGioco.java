import java.util.Scanner;


public class MenuGioco 
{
	
	public void gestisci()
	{
		int x;
		try 
		{
			Gioco tipo = new Gioco();
			
			Scanner in = new Scanner(System.in);
			String sqlcommand = "select * from gioco";
			String risultato="";
			String IDGioco="";

			String Titolo="";
			String Prezzo="";
			String Quantità="";
			String Console="";
			
			do
			{
			System.out.println("Gestione tabella GIOCO\nSelezionare una Operazione");
			System.out.println("1.Aggiungi, 2.Cancella, 3.Aggiorna, 4.Stampa, 0 Torna al menu precedente");
	        x= in.nextInt();

			switch(x)
			{
			
			case 1: 
			risultato= tipo.Execquery(sqlcommand);
			System.out.println(risultato);
			System.out.println("Immettere ID, Titolo, Prezzo, Quantità, Console");

			IDGioco=in.next();
			Titolo=in.next();
			Prezzo=in.next();
			Quantità=in.next();
			Console=in.next();
		
			
			tipo.Aggiungi(IDGioco, Titolo, Prezzo, Quantità, Console);
			risultato= tipo.Execquery(sqlcommand);
	        System.out.println(risultato);
	        break;
	             
			case 2: 
				risultato= tipo.Execquery(sqlcommand);
				System.out.println(risultato);
				System.out.println("Immettere IDGioco ");

				IDGioco=in.next();
				tipo.Cancella(IDGioco);
				risultato= tipo.Execquery(sqlcommand);
		        System.out.println(risultato);
		           break;
			
			case 3: 
				risultato= tipo.Execquery(sqlcommand);
				System.out.println(risultato);
				System.out.println("Immettere IDGioco, Titolo, Prezzo, Quantità, Console");

				IDGioco=in.next();
				Titolo=in.next();
				Prezzo=in.next();
				Quantità=in.next();
				Console=in.next();
                tipo.Aggiorna(IDGioco, Titolo, Prezzo, Quantità, Console);
		
				risultato= tipo.Execquery(sqlcommand);
		        System.out.println(risultato);
		           break;
		           
			case 4: 
				risultato= tipo.Execquery(sqlcommand);
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