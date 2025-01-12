package com.scaler.PaymentServiceEcommerce.controllers;

import com.razorpay.RazorpayException;
import com.scaler.PaymentServiceEcommerce.dtos.CreatePaymentLinkRequestDto;
import com.scaler.PaymentServiceEcommerce.services.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String createPaymentLink(@RequestBody CreatePaymentLinkRequestDto request) throws RazorpayException {
        String link = paymentService.createPaymentLink(request.getOrderId());

        return link;
    }

    @PostMapping("/webhook")
    public void handleWebhookEvent(@RequestBody Map<String, String> webhookEvent) {
        System.out.println(webhookEvent);
    }

}
