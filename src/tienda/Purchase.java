package tienda;

import java.util.ArrayList;
import java.util.List;

public class Purchase {

	private Customer comprador;
    private List<Game> juegos;
    private List<Integer> cantidades;

    public Purchase(Customer comprador) {
        this.comprador = comprador;
        this.juegos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
    }

    public void añadirAticulo(Game juego, int cantidad) {
        juegos.add(juego);
        cantidades.add(cantidad);
    }

    public Customer getComprador() {
        return comprador;
    }

    public List<Game> getJuegosACOmprar() {
        return juegos;
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < juegos.size(); i++) {
            total += juegos.get(i).getPrecio() * cantidades.get(i);
        }

        return total;
    }
	
}
