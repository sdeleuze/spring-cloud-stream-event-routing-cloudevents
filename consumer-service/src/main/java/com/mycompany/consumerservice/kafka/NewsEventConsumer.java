package com.mycompany.consumerservice.kafka;

import com.mycompany.consumerservice.event.CNNNewsCreated;
import com.mycompany.consumerservice.event.DWNewsCreated;
import com.mycompany.consumerservice.event.RAINewsCreated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class NewsEventConsumer {

    @Bean
    public Consumer<Message<CNNNewsCreated>> cnn() {
        return message -> log.info(
                LOG_TEMPLATE, "Received news created message from CNN!", message.getHeaders(), message.getPayload());
    }

    @Bean
    public Consumer<Message<DWNewsCreated>> dw() {
        return message -> log.info(
                LOG_TEMPLATE, "Erhaltene Nachrichten erstellte Nachricht von DW!", message.getHeaders(), message.getPayload());
    }

    @Bean
    public Consumer<Message<RAINewsCreated>> rai() {
        return message -> log.info(
                LOG_TEMPLATE, "Ricevuta notizia creata messaggio da RAI!", message.getHeaders(), message.getPayload());
    }

    private static final String LOG_TEMPLATE = "{}!\n---\nHEADERS: {}\n...\nPAYLOAD: {}\n---";
}
