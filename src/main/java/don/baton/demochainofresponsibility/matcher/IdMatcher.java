package don.baton.demochainofresponsibility.matcher;

import don.baton.demochainofresponsibility.Matcher;
import don.baton.demochainofresponsibility.entity.Booking;
import don.baton.demochainofresponsibility.entity.Payment;

@Matcher(weight = 100)
public class IdMatcher extends AbstractMatcher {
    @Override
    public boolean match(Booking booking, Payment payment) {
        boolean result = booking.id == payment.id;
        if (result) {
            System.out.println("!!! MATCH BY ID !!!");
        }
        return result;
    }

    @Override
    public String getName() {
        return "ID";
    }
}
