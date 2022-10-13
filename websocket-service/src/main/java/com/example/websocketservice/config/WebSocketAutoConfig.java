package com.example.websocketservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.util.Map;

/**
 * @description:
 * @date: 2021/5/10 17:20:51
 * @author: liuchunchi
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketAutoConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/toAll");
//        registry.setPreservePublishOrder(true);
    }


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/mq") //符合这个路径的请求
                .setAllowedOrigins("*")
//                .setAllowedOriginPatterns("*")
//                .addInterceptors(new HandshakeInterceptor() {
//                    /**
//                     * websocket握手之前
//                     */
//                    @Override
//                    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map <String, Object> attributes) throws Exception {
//                        ServletServerHttpRequest req = (ServletServerHttpRequest) request;
//                        /*//获取token认证
//                        String token = req.getServletRequest().getParameter("token");
//                        //解析token获取用户信息
//                        Principal user = "";  //鉴权，我的方法是，前端把token传过来，解析token，判断正确与否，return true表示通过，false请求不通过。
//                        if (user == null) {   //如果token认证失败user为null，返回false拒绝握手
//                            return false;
//                        }
//                        //保存认证用户
//                        attributes.put("user", user);*/
//                        return true;
//                    }
//
//                    @Override
//                    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
//
//                    }
//                })
//                //握手之后
//                .setHandshakeHandler(new DefaultHandshakeHandler() {
//
//                })
//                .setAllowedOriginPatterns("*")         //这里设置跨域，允许哪个地址访问，*号是所有
                .withSockJS();                                  //使用sockJS
    }

//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        //topic用来广播，user单独发送
//        registry.enableSimpleBroker("/topic", "/user");
//    }

    /**
     * 消息传输参数配置
     */
//    @Override
//    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
//        registry.setMessageSizeLimit(8192) //设置消息字节数大小
//                .setSendBufferSizeLimit(8192)//设置消息缓存大小
//                .setSendTimeLimit(10000); //设置消息发送时间限制毫秒
//    }


}
