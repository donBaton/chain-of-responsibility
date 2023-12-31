package don.baton.demochainofresponsibility.matcher;

import don.baton.demochainofresponsibility.Matcher;
import don.baton.demochainofresponsibility.entity.Booking;
import don.baton.demochainofresponsibility.entity.Payment;

@Matcher(weight = 10000)
public class SumMatcher extends AbstractMatcher {
    @Override
    public boolean match(Booking booking, Payment payment) {
        boolean result = booking.sum == payment.sum;
        if (result) System.out.println("!!! MATCH BY SUM !!!");
        return result;
    }

    @Override
    public String getName() {
        return "sum";
    }
}
