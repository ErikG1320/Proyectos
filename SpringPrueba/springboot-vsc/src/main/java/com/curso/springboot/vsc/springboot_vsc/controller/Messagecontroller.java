package com.curso.springboot.vsc.springboot_vsc.controller;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.curso.springboot.vsc.springboot_vsc.models.MessageDto;

@RestController
public class Messagecontroller {
	@GetMapping("/api/message")
	public MessageDto messageView(){
		return new MessageDto(LocalDateTime.now(),"Hola mundo spring boot desde visual studio code");
	}
}
