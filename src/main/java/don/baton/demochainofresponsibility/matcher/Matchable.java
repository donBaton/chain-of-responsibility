package don.baton.demochainofresponsibility.matcher;

import don.baton.demochainofresponsibility.entity.Booking;
import don.baton.demochainofresponsibility.entity.Payment;

import java.util.function.BiPredicate;

public interface Matchable {
    boolean match(Booking booking, Payment payment);

    Matchable addRule(BiPredicate<Payment, Booking> rule);

    String getName();
}
