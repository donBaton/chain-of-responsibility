package don.baton.demochainofresponsibility.matcher;

import don.baton.demochainofresponsibility.entity.Booking;
import don.baton.demochainofresponsibility.entity.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public abstract class AbstractMatcher implements Matchable {
    protected List<BiPredicate<Payment, Booking>> rules = new ArrayList<>();

    public Matchable addRule(BiPredicate<Payment, Booking> rule) {
        rules.add(rule);
        return this;
    }

    public abstract boolean match(Booking booking, Payment payment);

    protected boolean checkRules(Booking booking, Payment payment) {
        return rules.stream()
                .allMatch(x -> x.test(payment, booking));
    }
}
