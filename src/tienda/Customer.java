package tienda;

public class Customer {

    private int id;
    private String name;
    private double balance;

    public Customer(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void añadirSaldo(double cantidad) throws CantidadInvalidaException{
    	if(cantidad < 0) throw new CantidadInvalidaException("La Cantidad es negativa y no se permite");{
        balance += cantidad;
    	}
    }

    public void reducirSaldo(double cantidad, Game game) throws SaldoInsuficienteException {
        if (cantidad > balance) {
            throw new SaldoInsuficienteException(
                "No hay saldo suficiente para realizar la operación."
            );
        }

        balance -= game.getPrecio() * cantidad;
    }
    
    //Cmabiamos el metodo para que sea acertado con la Store.
    public boolean tieneCantidad(Game game, int cantidad) {
        return balance >= game.getPrecio() * cantidad;
    }
    
    

   //Remplazamos el ToString a uno de mayor calidad.
    public String toString() {
        return String.format(""" 
        		ID: %d
        		Name: %s
        		Balance: %f
        		""",id, name, balance);
    }
}
