package don.baton.demochainofresponsibility.matcher;

import don.baton.demochainofresponsibility.entity.Booking;
import don.baton.demochainofresponsibility.entity.Payment;

import java.util.List;
import java.util.function.BiPredicate;

public abstract class AbstractMatcher implements Matchable {
    protected Matchable nextMatcher;

    protected List<BiPredicate<Payment, Booking>> rules;

    public AbstractMatcher() {
    }

    protected AbstractMatcher(Matchable nextMatcher, List<BiPredicate<Payment, Booking>> rules) {
        this.nextMatcher = nextMatcher;
        this.rules = rules;
    }

    public abstract void init(Matchable nextMatcher, List<BiPredicate<Payment, Booking>> rules);

    public void match(Booking booking, Payment payment) {
        if(checkRules(booking, payment)){

        }

    }

    private boolean checkRules(Booking booking, Payment payment) {
        return rules.stream()
                .allMatch(x -> x.test(payment, booking));
    }
}
