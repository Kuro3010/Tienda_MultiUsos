package tienda;


public class Purchase {

	private Customer comprador;
    private Game juego;
    private int cantidad;

    public Purchase(Customer comprador, Game juego, int cantidad) {
        this.comprador = comprador;
        this.juego = juego;
        this.cantidad = cantidad;
    }

 
    public Customer getComprador() {
        return comprador;
    }

    public Game getJuegosACOmprar() {
        return juego;
    }

    public double getTotal() {
        double total = 0;
        
            total += juego.getPrecio() * cantidad;

        return total;
    }
	
}
