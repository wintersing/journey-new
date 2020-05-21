package com.lt.journey.constant;

import com.lt.journey.config.RabbitMQConfig;

/**
 * Title: <br>
 * Description: <br>
 * Company: winter.com <br>
 *
 * @author 刘汀
 * @version 1.0
 */
public class ChannelConst {

    /**
     * RedisMQ
     */
    public static final String CHANNEL_HOTEL = "CHANNEL_HOTEL";
    public static final String EXPIRE_CHANNEL_HOTEL = "EXPIRE_CHANNEL_HOTEL";
    public static final String CHANNEL_JOURNEY = "CHANNEL_JOURNEY";

    /**
     * 交换机
     */
    public static final String EXCHANGE = "EXCHANGE";

    /**
     * 路由key
     */
    public static final String ROUTING_HOTEL = "routing.hotel";
    public static final String ROUTING_PLACES = "routing.places";


    /**
     * 队列
     */
    public static final String QUEUE_HOTEL = "QUEUE_HOTEL";
    public static final String QUEUE_PLACES = "QUEUE_PLACES";

}
