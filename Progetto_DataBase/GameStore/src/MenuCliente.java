
import java.util.Scanner;


public class MenuCliente 
{
	
	public void gestisci()
	{
		int x;
		try 
		{
			cliente tipo = new cliente();
			
			Scanner in = new Scanner(System.in);
			String sqlcommand = "select * from cliente";
			String risultato="";
			String codice="";

			String Nome="";
			String Cognome="";
			String DatadiNascita="";
			
			do
			{
			System.out.println("Gestione tabella CLIENTE\nSelezionare una Operazione");
			System.out.println("1.Aggiungi, 2.Cancella, 3.Aggiorna, 4.Stampa, 0 Torna al menu precedente");
	        x= in.nextInt();

			switch(x)
			{
			
			case 1: 
			risultato= tipo.Execquery(sqlcommand);
			System.out.println(risultato);
			System.out.println("Immettere Codice, Cognome Nome Data di Nascita ");

			codice=in.next();
			Cognome=in.next();
			Nome=in.next();
			DatadiNascita=in.next();
		
			
			tipo.Aggiungi(codice, Cognome, DatadiNascita, Nome);
			risultato= tipo.Execquery(sqlcommand);
	        System.out.println(risultato);
	        break;
	             
			case 2: 
				risultato= tipo.Execquery(sqlcommand);
				System.out.println(risultato);
				System.out.println("Immettere Codice ");

				codice=in.next();
				tipo.Cancella(codice);
				risultato= tipo.Execquery(sqlcommand);
		        System.out.println(risultato);
		           break;
			
			case 3: 
				risultato= tipo.Execquery(sqlcommand);
				System.out.println(risultato);
				System.out.println("Immettere Codice Cognome  Nome Data di Nascita");

				codice=in.next();
				Cognome=in.next();
				Nome=in.next();
				DatadiNascita=in.next();
                tipo.Aggiorna(codice, Cognome,Nome ,DatadiNascita);
		
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
	      
	      
	      
		

	


