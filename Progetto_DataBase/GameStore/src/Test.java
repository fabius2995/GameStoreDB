import java.util.*;

public class Test {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int x;
		do{
			System.out.println("Università di Salerno. Esame Basi di Dati. Prof. G. Tortora. A.A 2015-2016");
			System.out.println("PROGETTO di AMENDOLA SALVATORE MATRICOLA n. 0512102643 \nGestione database GameStore\nSelezionare una Tabella");
			System.out.println("------------------------------------------------------------------");
			System.out.println("1.Addetto\n2.Cliente\n3.Formato\n4.Gioco\n5.Responsabile\n6.Team");
			System.out.println("7.tipodigioco\n8.vendite");
            System.out.println("0.ESCI");
            System.out.println("------------------------------------------------------------------");
             x=in.nextInt();
             switch(x){
 			
 			case 0:
 				System.out.println("Arrivederci..!!");
 				break;
 			case 1:	
 				MenuAddetto m1= new MenuAddetto();
  		       m1.gestisci();
  		     break;		
 				
 			case 2:	
 		       MenuCliente m2= new MenuCliente();
 		     m2.gestisci();
 		     break;
 			case 3:	
  		       MenuFormato m3= new MenuFormato();
  		     m3.gestisci();
  		     break;
 			case 4:	
 				   MenuGioco m4= new MenuGioco();
 				     m4.gestisci();
 				     break;
 				     
 			case 5:	
				   MenuResponsabile m5= new MenuResponsabile();
				     m5.gestisci();
				     break;		 
				     
 			case 6:	
				   MenuTeam m6= new MenuTeam();
				     m6.gestisci();
				     break;				     
 			case 7:	
 			  MenuTipodiGioco m7= new MenuTipodiGioco();
 			     m7.gestisci();
 			     break;
 			     
 			case 8:	
 	 			  MenuVendite m8= new MenuVendite();
 	 			     m8.gestisci();
 	 			     break;    
 			default:
 				   break;
 			}
 				}        
 				        
 				 while(x!= 0); }

 	}
