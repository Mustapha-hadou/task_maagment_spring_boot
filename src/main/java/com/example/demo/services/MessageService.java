package com.example.demo.services;

import com.example.demo.sherd.dto.MessageDto;

public interface MessageService {

	
	void createMessage(MessageDto userDto);
    void sendEmail(MessageDto mail);

		
}
