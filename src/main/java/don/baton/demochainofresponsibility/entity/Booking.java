package don.baton.demochainofresponsibility.entity;

public class Booking {
    public int id;
    public int sum;

    public Booking(int id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }
}