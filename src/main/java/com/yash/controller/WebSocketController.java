package com.yash.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.yash.model.ApiResponse;
import com.yash.model.News;
import com.yash.service.service.MasterService;
import com.yash.support.NewsSupport;

@Controller
public class WebSocketController extends MasterService {

	@MessageMapping("/message")
    @SendTo("/topic/reply")
	public ApiResponse<News> processMessageFromClient(@Payload String message) throws Exception {
		return new ApiResponse<>(HttpStatus.OK.value(), "News Data",newsService.getNewsByCategory(NewsSupport.categories));
	}
	
	@MessageExceptionHandler
    public String handleException(Throwable exception) {
        messagingTemplate.convertAndSend("/errors", exception.getMessage());
	    return exception.getMessage();
    }

}