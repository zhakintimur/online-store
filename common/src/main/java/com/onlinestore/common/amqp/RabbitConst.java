package com.onlinestore.common.amqp;

public interface RabbitConst {

    String CORE_EXCHANGE = "core_message_exchange";
    String MAIL_EXCHANGE = "mail_message_exchange";

    String ORDER_QUEUE = "order_message_queue";
    String PAYMENT_QUEUE = "payment_message_queue";
    String MAIL_QUEUE = "mail_message_queue";
    String ORDER_ROUTING_KEY = "order_message_routingKey";
    String PAYMENT_ROUTING_KEY = "payment_message_routingKey";
    String MAIL_ROUTING_KEY = "mail_message_routingKey";
}
