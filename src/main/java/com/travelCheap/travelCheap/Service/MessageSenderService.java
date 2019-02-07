package com.travelCheap.travelCheap.Service;

import com.travelCheap.travelCheap.Domain.Message;

public interface MessageSenderService {
    void sendMessage(Message message);
}
