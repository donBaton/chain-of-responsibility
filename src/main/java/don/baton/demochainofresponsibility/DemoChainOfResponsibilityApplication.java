package don.baton.demochainofresponsibility;

import don.baton.demochainofresponsibility.entity.Booking;
import don.baton.demochainofresponsibility.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoChainOfResponsibilityApplication implements CommandLineRunner {

    @Autowired
    PaymentLinkage paymentLinkage;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoChainOfResponsibilityApplication.class, args);
        //Arrays.stream(context.getBeanFactory().getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Override
    public void run(String... args) {
        List<Booking> bookings = List.of(new Booking(2, 2200), new Booking(11, 123), new Booking(1, 100));
        List<Payment> payments = List.of(new Payment(1, 100), new Payment(3, 100), new Payment(4, 323));
        paymentLinkage.match(payments.get(0), bookings);
    }
}
