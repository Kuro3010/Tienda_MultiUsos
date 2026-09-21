package tienda;

import java.util.*;

public class Store {

		private ArrayList<Game> games;
	    private ArrayList<Customer> customers;
	    private ArrayList<Purchase> purchases;
	    
	    public Store() {
	        games = new ArrayList<>();
	        customers = new ArrayList<>();
	        purchases = new ArrayList<>();

	        games.add(new Game(1, "Mario 64", 25.00, Genre.PLATAFOM, 10));
	        games.add(new Game(2, "Resident Evil 4 (", 60.00, Genre.ACTION, 3));
	        games.add(new Game(3, "Elden Ring", 80.00, Genre.ADVENTURE, 10));
	        games.add(new Game(4, "Minecraft", 15.00, Genre.SANDBOX, 10));
	        		
	        customers.add(new Customer(1, "Manolo Ceballos", 80));
	        customers.add(new Customer(2, "Marta Espinela", 290));
	        customers.add(new Customer(3, "Anais Torpila", 45));
	        customers.add(new Customer(4, "Jorge Hernandez", 130));
	    }
	    
	    public void añadirJuego(Game game) throws ArrayNullException {
	    	
	    	//añadimos las comprobaciones para añadir el juego.
	    	for (Game gameExistente : games) {
	    		
	    		if(game != null) {
		    		
		    		if (gameExistente.getTitulo() != null
		    				&& !gameExistente.getTitulo().trim().isEmpty()) {
		    		}
		    		else
		    			{
		    			throw new ArrayNullException("El array es nulo o vacio en el TItulo");		    			
		    		}
		    		
		    		if (String.valueOf(gameExistente.getPrecio()) != null 
		    				&& !String.valueOf(gameExistente.getPrecio()).trim().isEmpty()) {
	    				
		    		}else {
		    			throw new ArrayNullException("El array es nulo o vacio en el Precio");
		    		}
		    		
		    		if (gameExistente.getGenero() != null 
		    				&& !String.valueOf(gameExistente.getGenero()).trim().isEmpty()) {
		    			
		    		}else{
		    			throw new ArrayNullException("El array es nulo o vacio en el Genero");
		    		}
		    		
		    		if(String.valueOf(gameExistente.getStock()) != null 
		    				&& !String.valueOf(gameExistente.getStock()).trim().isEmpty()) {
		    			
		    		}else {
		    			throw new ArrayNullException("El array es nulo o vacio en el Stock");
		    		}
	    		}
	    	}
	    		
	    	for (Game gameExistente : games) {
	    		
	    		if (gameExistente.equals(game)) {
	    			throw new IllegalArgumentException(
	    					"Ya existe un videojuego con el indicador: " 
	    			+ game.getId()
	    			);
	    		}
	    	}	
	    	games.add(game);
	    }
	    
	    public Game buscarGame(int id) throws GameNoEncontradoException {
	    	
	    	for (Game game : games) {
	    		
	    		if (game.getId() == id) {
	    			return game;
	    		}
	    	}
	    	
	    	throw new GameNoEncontradoException(
	    			"No existe ningún juego con el identificador: " + id
	    	);
	    }
	    
	    
	    public Customer buscarCustomer(int id) throws CustomerNoEncontradoException {
	    	
	    	for (Customer customer : customers) {
	    		
	    		if(customer.getId() == id) {
	    			return customer;
	    		}
	    		
	    	}
	    	
	    	throw new CustomerNoEncontradoException(
	    			"No existe un comprador con esa identificacion: " + id);
	    }
	    
	    public ArrayList<Game> BuscarJuegoPorTexto(String texto){
	    	String UpperCase = texto.toUpperCase();
	    	ArrayList<Game> games = new ArrayList<Game>();
	    	
	    	for (Game game : games) {
	    		
	    		if( game.getTitulo().toUpperCase().contains(UpperCase))games.add(game);
	    	
	    	
	    	}
	    	return games;
	    	
	    }
	    
	    public ArrayList<Game> BuscarJuegoPorGenero(Genre genero) {
	    	ArrayList<Game> games = new ArrayList<Game>();
	    	
	    	for (Game game : games) {
	    		
	    		if( game.getGenero() == genero) games.add(game);{
	    		}
	    	}
	    	return games;

	    }
	    
	    
	    public boolean ComprarVideojuegos(int idCustomer, int idGame, int cantidad) 
	    		throws CustomerNoEncontradoException, GameNoEncontradoException,
	    		SaldoInsuficienteException, StockInsuficienteException, CantidadInvalidaException {
	    	
	    	
	    	Customer customer = buscarCustomer(idCustomer);
	    	Game game = buscarGame(idGame);
	    	
    						
    		if( game.ComprobarStock(cantidad)) {
    							
    			throw new StockInsuficienteException(
    					"No hay Stock duficiente para su compra");
    							
    		}
    								
    		if(customer.tieneCantidad(game, cantidad)) {
    							
    			throw new SaldoInsuficienteException(
    				"No tienes saldo suficiente para hacer la compra"
    					);
  
    		} 
    			
    			game.reducirStock(cantidad);
    			customer.reducirSaldo(cantidad,game);
    			Purchase purchase = new Purchase(customer,game, cantidad);
    		
    			//Reparamos el orden de las operaciones y su funcionalidad.
    			
	    	return true;
	    	
	    }
	    
	}





