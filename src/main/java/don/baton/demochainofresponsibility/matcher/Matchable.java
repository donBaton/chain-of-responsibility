package don.baton.demochainofresponsibility.matcher;

import don.baton.demochainofresponsibility.entity.Booking;
import don.baton.demochainofresponsibility.entity.Payment;

public interface Matchable {
    void match(Booking booking, Payment payment);
}
