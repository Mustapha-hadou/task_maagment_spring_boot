package com.example.demo.services.Imp;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entities.MessageEntity;
import com.example.demo.entities.ProjetEntity;
import com.example.demo.repository.MessageRepository;
import com.example.demo.services.MessageService;
import com.example.demo.sherd.dto.MessageDto;
import com.example.demo.sherd.dto.ProjetDto;


@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
    MessageRepository messageRepository;
	
	@Override
	public void createMessage(MessageDto messageDto) {

        		
		Type listeType = new TypeToken<MessageEntity>() {}.getType();
		MessageEntity message= new ModelMapper().map(messageDto,listeType);
		
		messageRepository.save(message);
		
	}

	@Autowired
	JavaMailSender javaMailSender;
	
	@Override
	public void sendEmail(MessageDto mail) {


	       SimpleMailMessage simpleMailSender=new SimpleMailMessage();
	       
	       simpleMailSender.setFrom(mail.getAdmin().getEmail());
	       
	       simpleMailSender.setTo(mail.getManager().getEmail());
	       
	       simpleMailSender.setSubject(mail.getObjet());

	       simpleMailSender.setText(mail.getContenu());
	       
	       javaMailSender.send(simpleMailSender);
		
		
	}
	
	
	

}
