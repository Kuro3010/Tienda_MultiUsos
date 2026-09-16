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

    public void añadirSaldo(double cantidad) {
        balance += cantidad;
    }

    public void reducirSaldo(double cantidad) throws SaldoInsuficienteException {
        if (cantidad > balance) {
            throw new SaldoInsuficienteException(
                "No hay saldo suficiente para realizar la operación."
            );
        }

        balance -= cantidad;
    }

    public boolean tieneCantidad(double cantidad) {
        return balance >= cantidad;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
               "Nombre: " + name + "\n" +
               "Balance: " + balance + "\n";
    }
}
