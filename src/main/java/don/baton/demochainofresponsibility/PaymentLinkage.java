package don.baton.demochainofresponsibility;

import don.baton.demochainofresponsibility.entity.Booking;
import don.baton.demochainofresponsibility.entity.Payment;
import don.baton.demochainofresponsibility.matcher.Matchable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;

@Component
public class PaymentLinkage {

    @Autowired
    private List<Matchable> chain;

    @PostConstruct
    public void init() {
        chain.sort(Comparator.comparing(matcher ->
                (int) AnnotationUtils.getValue(
                        AnnotationUtils.findAnnotation(
                                matcher.getClass(), Matcher.class), "weight")));
        System.out.println("Chain:");
        chain.stream().forEach(matcher -> System.out.print("[" + matcher.getName() + "] -> "));
        System.out.println("\n");
    }

    public void match(Payment payment, List<Booking> bookings) {
        System.out.println("Start matching for payment:" + payment);

        for (Booking booking : bookings) {
            System.out.println("checked for booking: " + booking.toString());
            boolean result = false;
            for (Matchable matcher : chain) {
                System.out.println("try to find match using: " + matcher.getName());
                result = matcher.match(booking, payment);
                if (result) break;
            }
            if (result) break;
            System.out.println( booking + " doesn't match payment: " + payment);
        }
    }
}
