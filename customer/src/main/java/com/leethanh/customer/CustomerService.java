package com.leethanh.customer;

import com.leethanh.clients.fraud.FraudCheckResponse;
import com.leethanh.clients.fraud.FraudClient;
import com.leethanh.clients.notification.NotificationClient;
import com.leethanh.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate, FraudClient fraudClient,
                              NotificationClient notificationClient) {


    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // todo: check if email is valid
        // todo : check if email not taken
        customerRepository.saveAndFlush(customer);
        // todo : check if fraudster
        FraudCheckResponse fraudCheckResponse =fraudClient.isFrauster(customer.getId());

        if (fraudCheckResponse.isFraudster())
        {
            throw  new IllegalStateException("fraudster");
        }


        // todo: send notification
        notificationClient.sendNotification(
                new NotificationRequest(customer.getId(),customer.getEmail(),
                        String.format("Hi %s, welcome to leethanh microservices",customer.getFirstName())
                                )
        );
    }
}
