package com.ngobackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngobackend.dto.MessageDTO;
import com.ngobackend.entities.Message;
import com.ngobackend.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	public void sendmsg(MessageDTO messageDTO) throws Exception
	{
		try {
			Message msg = this.msgdtotomsg(messageDTO);
			this.messageRepository.save(msg);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public Message getmsgByID(int id) throws Exception
	{
		try {
			Optional<Message> optional=this.messageRepository.findById(id);
			if(optional.isPresent())
			{
				return optional.get();
			}
			else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
	}
	
	public List<Message> findAllMessages() throws Exception
	{
		try {
			List<Message> u = this.messageRepository.findAll();
			if(u.isEmpty())
			{
				return null;
			}
			else {
				return u;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
		
	}
	public int deleteMessage(int id) throws Exception
	{
		try {
			Optional<Message> optional=this.messageRepository.findById(id);
			if(optional.isPresent())
			{
				Message u = optional.get();
				this.messageRepository.delete(u);
				return 1;
			}else {
				return 0;
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception();
		}
	}

	
	private Message msgdtotomsg(MessageDTO m)
	{
		Message msg = new Message();
		msg.setMsg(m.getMsg());
		msg.setNumber(m.getNumber());
		msg.setName(m.getName());
		return msg;
	}
}
