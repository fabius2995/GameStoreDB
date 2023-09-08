
import java.util.Scanner;


public class MenuTeam
{
	
	public void gestisci()
	{
		int x;
		try 
		{
			team tipog = new team();
			
			Scanner in = new Scanner(System.in);
			String sqlcommand = "select * from team";
			String risultato="";
			String Matricola="";

			String ID_Responsabile="";
			String data="";
			
			
			do
			{
			System.out.println("Gestione tabella team \nSelezionare una Operazione");
			System.out.println("1.Aggiungi, 2.Cancella, 3.Aggiorna, 4.Stampa, 0 Torna al menu precedente");
	        x= in.nextInt();

			switch(x)
			{
			
			case 1: 
			risultato= tipog.Execquery(sqlcommand);
			System.out.println(risultato);
			System.out.println("Immettere Matricola, ID_Responsabile, data");

			Matricola=in.next();
			ID_Responsabile=in.next();
			data=in.next();
			
			
			tipog.Aggiungi(Matricola, ID_Responsabile, data);
			risultato= tipog.Execquery(sqlcommand);
	        System.out.println(risultato);
	        break;
	             
			case 2: 
				risultato= tipog.Execquery(sqlcommand);
				System.out.println(risultato);
				System.out.println("Immettere Matricola ed IDResponsabile ");

			   Matricola=in.next();
			   ID_Responsabile=in.next();
				tipog.Cancella(Matricola, ID_Responsabile);
				risultato= tipog.Execquery(sqlcommand);
		        System.out.println(risultato);
		           break;
			
			case 3: 
				risultato= tipog.Execquery(sqlcommand);
				System.out.println(risultato);
				System.out.println("Immettere Matricola ed IDResponsabile ");

				   Matricola=in.next();
				   ID_Responsabile=in.next();
                 data=in.next();
				tipog.Aggiorna(Matricola,ID_Responsabile,data);
		
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