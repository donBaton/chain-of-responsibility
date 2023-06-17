package don.baton.demochainofresponsibility.matcher;

import don.baton.demochainofresponsibility.entity.Booking;
import don.baton.demochainofresponsibility.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.BiPredicate;

@Component
public class DefaultMatcher extends AbstractMatcher {
    @Autowired
    SumMatcher sumMatcher;

    @PostConstruct
    public void init(Matchable nextMatcher, List<BiPredicate<Payment, Booking>> rules) {
        this.nextMatcher = sumMatcher;
        this.rules = rules;
    }
}
