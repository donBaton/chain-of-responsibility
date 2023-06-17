package don.baton.demochainofresponsibility.matcher;

import don.baton.demochainofresponsibility.entity.Booking;
import don.baton.demochainofresponsibility.entity.Payment;

import java.util.List;
import java.util.function.BiPredicate;

public class SumMatcher extends AbstractMatcher {
    public SumMatcher() {
        super(null, List.of((b, p) -> b.sum == p.sum));
    }

    @Override
    public void init(Matchable nextMatcher, List<BiPredicate<Payment, Booking>> rules) {
    }
}
