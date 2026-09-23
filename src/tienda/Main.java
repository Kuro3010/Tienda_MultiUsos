package tienda;

import java.io.File;
import java.util.*;

import exceptions.*;

public class Main {

	public static void main (String args []) throws GameNoEncontradoException, CustomerNoEncontradoException{
		
		Store store = new Store();
	/*	try {
			store.loadCustomer("customers.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			store.loadGames("games.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		try(Scanner scanner = new Scanner(System.in)){
			
			String input = "";
			while(!input.equals("quit")) {
				
				input = scanner.nextLine();
				
				String[] command = input.split(" ");
				
				switch(command[0]) {
				
				case "games":
					
					System.out.println(store.getGames().toString());
					break;
					
				case "game":
					int id = Integer.parseInt(command[1]);
					System.out.println(store.buscarGame(id));
					break;
					
				case "customers":
					System.out.println(store.getCustomers().toString());
					break;
					
				case "customer":
					 id = Integer.parseInt(command[1]);
					 System.out.println(store.buscarCustomer(id));
					 break;
					 
				case "search":
				String texto = scanner.nextLine();
				System.out.println(store.BuscarJuegoPorTexto(texto));
					break;
					
				case "genre":
					
					 
					}
				}
			}
		
		
		
		
			}	

}
