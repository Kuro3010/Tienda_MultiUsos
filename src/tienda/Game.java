package tienda;

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
	
	
	public void aumentarStock(int cantidad) {
	    stock += cantidad;
	}
	
	public void reducirStock(int cantidad) {
	    if (cantidad <= stock) {
	        stock -= cantidad;
	    }
	}
	
	public boolean hayStock() {
	    return stock > 0;
	}
	
	public String toString() {
	    return	"Titulo:" + titulo + "\n" +
	            "Precio:" + precio +  "\n" +
	            "Genero=" + genero + "\n"+
	            "Stock=" + stock +  "\n";
	}

	
}


