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
	    }
	    
	    public void añadirJuego(Game game) {
	    	
	    	for (Game gameExistente : games) {
	    		
	    		if (gameExistente.getId() == game.getId()) {
	    			throw new IllegalArgumentException(
	    					"Ya existe un videojuego con el indicador: " 
	    			+ game.getId()
	    			);
	    		}
	    	}	
	    	games.add(game);
	    }
	    
	    public Game buscarGame(int id) throws GameNoEncontradoException{
	    	
	    	for (Game game : games) {
	    		
	    		if (game.getId() == id) {
	    			return game;
	    		}
	    	}
	    	
	    	throw new GameNoEncontradoException(
	    			"No existe ningún juego con el identificador: " + id
	    	);
	    }
		
	}