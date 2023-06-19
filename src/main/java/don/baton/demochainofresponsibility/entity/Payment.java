package don.baton.demochainofresponsibility.entity;

public class Payment {
    public int id;
    public int sum;

    public Payment(int id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }
}
