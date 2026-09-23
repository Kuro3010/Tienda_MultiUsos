package tienda;

import exceptions.CantidadInvalidaException;
import exceptions.StockInsuficienteException;

public class Game {
	
	
	private int id;
	private String titulo;
	private double precio;
	private Genre genero;
	private int stock;
	
	public Game(int id, String titulo, double precio, Genre genero, int stock) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.genero = genero;
		this.stock = stock;
	}
	
	public int getId() {
	    return id;
	}

	public String getTitulo() {
	    return titulo;
	}

	public Genre getGenero() {
	    return genero;
	}

	public double getPrecio() {
	    return precio;
	}

	public int getStock() {
	    return stock;
	}
	
	
	public void aumentarStock(int cantidad) throws CantidadInvalidaException {
	  
		if(cantidad < 0) throw new CantidadInvalidaException("Cantidad no permitida");
		stock += cantidad;
		
		 // Nos faltaba una comprobación y una Excepcion.
		
	}
	
	public void reducirStock(int cantidad) throws CantidadInvalidaException, StockInsuficienteException {

		if(cantidad < 0) throw new CantidadInvalidaException("Cantidad no permitida");
		if(cantidad > stock) throw new StockInsuficienteException("Stock menor que la cantidad");
	        stock -= cantidad;
	    
	  
	  // Nos falta la comprobacion de una cantidad negativa.
	  
	}
	
	public boolean hayStock() {
		
	    return stock > 0;
	    
	}
	
	//Añadimos metodo para comprobar si hay stock para vender a X cantidad.
	public boolean ComprobarStock(int cantidad) {
		
		return stock >= cantidad;
		
	}
	
	public String toString() {
		return String.format("""
				ID: %d
				Title: %s
				Price: %f
				Genre: %s
				Stock: %d
				""", id, titulo, precio, genero, stock);
		//Remplazamos el anterior ToString por uno ams ordenado y bonito.
		
	}

	
}


