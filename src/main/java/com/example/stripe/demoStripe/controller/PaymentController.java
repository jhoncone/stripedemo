package com.example.stripe.demoStripe.controller;

import com.example.stripe.demoStripe.presentation.request.PaymentRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import com.stripe.param.ChargeCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Value("${stripe.secretKey}")
    private String secretKey;

    @PostMapping
    public String createPayment(@RequestBody PaymentRequest request) {
        Stripe.apiKey = secretKey;

        try {
            ChargeCreateParams chargeParams = new ChargeCreateParams.Builder()
                    .setAmount((long) (request.getAmount() * 100))
                    .setCurrency("usd")
                    .setDescription(request.getDescription())
                    .setSource(request.getToken())
                    .build();

            Charge charge = Charge.create(chargeParams);

            return charge.getId();
        } catch (StripeException e) {
            // Manejo de excepciones
            return "Error al procesar el pago: " + e.getMessage();
        }
    }
}
