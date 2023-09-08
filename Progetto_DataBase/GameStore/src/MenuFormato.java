

import java.util.Scanner;


public class MenuFormato 
{
	
	public void gestisci()
	{
		int x;
		try 
		{
			formato tipog = new formato();
			
			Scanner in = new Scanner(System.in);
			String sqlcommand = "select * from formato";
			String risultato="";
			String tipo="";

			String IDGioco="";
			
			
			do
			{
			System.out.println("Gestione tabella formato \nSelezionare una Operazione");
			System.out.println("1.Aggiungi, 2.Cancella, 3.Aggiorna, 4.Stampa, 0 Torna al menu precedente");
	        x= in.nextInt();

			switch(x)
			{
			
			case 1: 
			risultato= tipog.Execquery(sqlcommand);
			System.out.println(risultato);
			System.out.println("Immettere Tipo, IDGioco");

			tipo=in.next();
			IDGioco=in.next();

			
			tipog.Aggiungi(tipo, IDGioco);
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
				System.out.println("Immettere Tipo e IDGioco");

				tipo=in.next();
				IDGioco=in.next();
				tipog.Aggiorna(tipo, IDGioco);
		
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