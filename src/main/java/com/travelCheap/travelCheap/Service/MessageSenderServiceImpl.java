package com.travelCheap.travelCheap.Service;

import com.travelCheap.travelCheap.Domain.Message;
import com.travelCheap.travelCheap.Service.SenderManager.MessageSenderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderServiceImpl implements MessageSenderService {

    MessageSenderImpl senderManager;

    @Autowired
    public void setSenderManager(MessageSenderImpl senderManager) {
        this.senderManager = senderManager;
    }

    @Override
    public void sendMessage(Message message) {
        senderManager.sendMessage(message);
    }
}
