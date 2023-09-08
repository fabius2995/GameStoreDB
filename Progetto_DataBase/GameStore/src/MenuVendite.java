
import java.util.Scanner;


public class MenuVendite {
	
	public void gestisci()
	{
		int x;
		try {
			vendite tipo = new vendite();
			
			Scanner in = new Scanner(System.in);
			String sqlcommand = "select * from vendite";
			
			String risultato="";
	
			String Matricola="";
            String IDGioco="";
			String Cod_ID="";
			String quant="";
			String iva="";
			String totvend="";
		
			do
			{
			System.out.println("Gestione tabella Vendite \nSelezionare una Operazione");
			System.out.println("1.Aggiungi, 2.Cancella, 3.Aggiorna, 4.Stampa,0 Torna al menu precedente");
	        x= in.nextInt();

			switch(x){
			
			case 1: 
			risultato= tipo.Execquery(sqlcommand);
			System.out.println(risultato);
			System.out.println("IDGioco,Cod_ID,Matricola,quant,iva, totvend");

			
			IDGioco=in.next();
			Cod_ID=in.next();
			Matricola=in.next();
			quant=in.next();
			iva=in.next();
			totvend=in.next();

			
			tipo.Aggiungi(IDGioco,Cod_ID,Matricola,quant, iva, totvend);
			risultato= tipo.Execquery(sqlcommand);
	        System.out.println(risultato);
	           break;
	             
			case 2: 
				risultato= tipo.Execquery(sqlcommand);
				System.out.println(risultato);
				System.out.println("Immettere IDGioco,Cod_ID,Matricola ");
				IDGioco=in.next();
				Cod_ID=in.next();
				Matricola=in.next();
				tipo.Cancella(IDGioco,Cod_ID,Matricola);
				risultato= tipo.Execquery(sqlcommand);
		        System.out.println(risultato);
		           break;
			
			case 3: 
				risultato= tipo.Execquery(sqlcommand);
				System.out.println(risultato);
				System.out.println("Immettere IDGioco,Cod_ID,Matricola ");
				IDGioco=in.next();
				Cod_ID=in.next();
				Matricola=in.next();
				System.out.println("campo e valore da aggiornare");


                String Campo =in.next();
                String Valore =in.next();
                tipo.Aggiorna(IDGioco,Cod_ID,Matricola,Campo, Valore);
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
	      