package com.travelCheap.travelCheap.Controller;

import com.travelCheap.travelCheap.Domain.Message;
import com.travelCheap.travelCheap.Service.MessageSenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    private MessageSenderServiceImpl senderService;

    @Autowired
    public void setSenderService(MessageSenderServiceImpl senderService) {
        this.senderService = senderService;
    }

    @GetMapping("/travelCheap")
    public String getMainPage(Model model){
        init(model);
        return "mainPage";
    }

    @PostMapping("/travelCheap/send")
    public String sendMessage(@ModelAttribute @Valid Message message, Model model){

        Message msg = new Message();

        message.setClientEmail(message.getClientEmail());
        message.setClientName(message.getClientName());
        message.setClientTelephoneNumber(message.getClientTelephoneNumber());
        message.setQuestion1(message.getQuestion1());
        message.setQuestion2(message.getQuestion2());
        message.setQuestion3(message.getQuestion3());
        message.setComment(message.getComment());

       senderService.sendMessage(message);

       init(model);

       return "redirect:/travelCheap";
    }

    private void init(Model model){
        model.addAttribute("message", new Message());
    }
}
