package com.usuarios.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.usuarios.demo.entity.Usuario;
import com.usuarios.demo.repository.UsuarioRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.util.List;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Esta inyección me permite utilizar el servicio de email
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> listUsuarios(){
		return usuarioRepository.findAll();
	}
	
	//Este método me permite enviar un correo eléctronico con un cuerpo html
	public void sendHtmlEmail(String to, String subject, String body) throws MailException, MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true); //true para indicar que es multipart
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true); //true para indicar que el contenido es HTML
		javaMailSender.send(message);
	}
}




