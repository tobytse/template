package com.example.jpatranmgt.service;

import java.util.UUID;


import com.example.jpatranmgt.dto.FlightBookingAcknowledgement;
import com.example.jpatranmgt.dto.FlightBookingRequest;
import com.example.jpatranmgt.entity.PassengerInfo;
import com.example.jpatranmgt.entity.PaymentInfo;
import com.example.jpatranmgt.repository.PassengerInfoRepository;
import com.example.jpatranmgt.repository.PaymentInfoRespository;
import com.example.jpatranmgt.utils.PaymentUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlightBookingService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    @Autowired
    private PaymentInfoRespository paymentInfoRespository;

    @Transactional //(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){
        
        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());

        paymentInfoRespository.save(paymentInfo);

        return new FlightBookingAcknowledgement("Success", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }
    
}
