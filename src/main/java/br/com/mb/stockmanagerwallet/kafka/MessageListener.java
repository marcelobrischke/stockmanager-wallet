package br.com.mb.stockmanagerwallet.kafka;

import java.text.SimpleDateFormat;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageListener {
	private static final SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
	
    @KafkaListener(topics = "invoiceAdd", groupId = "group_id")
    public void listenWithHeaders(ConsumerRecord<String, String> payload) throws Exception {
        log.debug("key: {}", payload.key());
        log.debug("Headers: {}", payload.headers());
        log.debug("Partion: {}", payload.partition());
        log.debug("Order: {}", payload.value());
        
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(sdfDate);
        InvoiceMessage message = objectMapper.readValue(payload.value(), InvoiceMessage.class);
        log.debug("Received ADD Message: " + message);
    	log.debug(sdfDate.format(message.getOperationDate()));
    }
    
    @KafkaListener(topics = "invoiceReset", groupId = "group_id")
    public void resetListener(ConsumerRecord<String, String> payload) {
        log.debug("key: {}", payload.key());
        log.debug("Headers: {}", payload.headers());
        log.debug("Partion: {}", payload.partition());
        log.debug("Order: {}", payload.value());
    	log.debug("Received RESET message: " + payload.value());
    }
}