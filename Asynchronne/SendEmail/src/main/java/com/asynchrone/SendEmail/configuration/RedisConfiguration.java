package com.asynchrone.SendEmail.configuration;
import com.asynchrone.SendEmail.service.RedisMessageSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
@Configuration
public class RedisConfiguration {
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter){
        // Redis message listening redisMessageListenerContainer
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        //Set connection redisConnectionFactory
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        // Add message listener
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter,topic());
        //returto the container
        return redisMessageListenerContainer;
    }
    @Bean
    MessageListenerAdapter messageListenerAdapter()
    {
        return new MessageListenerAdapter(new RedisMessageSubscriber(),"onMessage");
    }
    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic("nour");
    }
    @Bean
    RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
    {
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return redisTemplate;
    }



}
