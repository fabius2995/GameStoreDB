import java.util.Scanner;


public class MenuAddetto {
	
	public void gestisci()
	{
		int x;
		try {
			addetto tipo = new addetto();
			
			Scanner in = new Scanner(System.in);
			String sqlcommand = "select * from addetto";
			String risultato="";
			String Matricola="";
            String Cognome="";
			String Nome="";
			String DatadiNascita="";
			String DatadiAssunzione="";
			String Stipendio="";
			String Residenza="";
			do
			{
			System.out.println("Gestione tabella Addetto \nSelezionare una Operazione");
			System.out.println("1.Aggiungi, 2.Cancella, 3.Aggiorna, 4.Stampa,0 Torna al menu precedente");
	        x= in.nextInt();

			switch(x){
			
			case 1: 
			risultato= tipo.Execquery(sqlcommand);
			System.out.println(risultato);
			System.out.println("Immettere Matricola,Cognome, Nome, DatadiNascita, Datadi Assunzione,Stipendio, Residenza");

			Matricola=in.next();
			Cognome=in.next();
			Nome=in.next();
			
			DatadiNascita=in.next();
			DatadiAssunzione=in.next();
			
			Stipendio=in.next();
			Residenza=in.next();
			
			tipo.Aggiungi(Matricola,Cognome, Nome, DatadiNascita, DatadiAssunzione,Stipendio, Residenza);
			risultato= tipo.Execquery(sqlcommand);
	        System.out.println(risultato);
	           break;
	             
			case 2: 
				risultato= tipo.Execquery(sqlcommand);
				System.out.println(risultato);
				System.out.println("Immettere Matricola ");

				Matricola=in.next();
				tipo.Cancella(Matricola);
				risultato= tipo.Execquery(sqlcommand);
		        System.out.println(risultato);
		           break;
			
			case 3: 
				risultato= tipo.Execquery(sqlcommand);
				System.out.println(risultato);
				System.out.println("Immettere Matricola campo e valore da aggiornare");

				Matricola=in.next();
                String Campo =in.next();
                String Valore =in.next();
                tipo.Aggiorna(Matricola,Campo, Valore);
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
	      