package com.usuarios.demo.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usuarios.demo.dto.UsuarioDTO;
import com.usuarios.demo.entity.Usuario;
import com.usuarios.demo.service.UsuarioService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.POST, RequestMethod.OPTIONS})
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private List<Usuario> usuarios = new ArrayList<>();
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addUsuario (@RequestBody UsuarioDTO usuarioDTO){
		Usuario usuario = new Usuario(usuarioDTO.getNombres(),
									  usuarioDTO.getApellidos(),
									  usuarioDTO.getCorreo(),
									  usuarioDTO.getNumero_telefonico());
		usuarios.add(usuario);
		
		//Y aca enviamos el correo electronico del nuevo registro de usuario
		String email = "orihuelao.luis@gmail.com";
		String subject = "Se registro un nuevo usuario";
		
		//Ahora implementamos la estructura HTML
		String message = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" +
	            "<html xmlns=\"http://www.w3.org/1999/xhtml\">" +
	            "<head>" +
	            "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />" +
	            "<meta name=\"x-apple-disable-message-reformatting\" />" +
	            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />" +
	            "<meta name=\"color-scheme\" content=\"light dark\" />" +
	            "<meta name=\"supported-color-schemes\" content=\"light dark\" />" +
	            "<title></title>" +
	            "<style type=\"text/css\" rel=\"stylesheet\" media=\"all\">" +
	            "@import url(\"https://fonts.googleapis.com/css?family=Nunito+Sans:400,700&display=swap\");" +
	            "body { width: 100% !important; height: 100%; margin: 0; -webkit-text-size-adjust: none; }" +
	            "a { color: #3869D4; }" +
	            "td { word-break: break-word; }" +
	            "body, td, th { font-family: \"Nunito Sans\", Helvetica, Arial, sans-serif; }" +
	            "h1 { margin-top: 0; color: #333333; font-size: 22px; font-weight: bold; text-align: left; }" +
	            "p, ul, ol, blockquote { margin: .4em 0 1.1875em; font-size: 16px; line-height: 1.625; }" +
	            "body { background-color: #F2F4F6; color: #51545E; }" +
	            ".email-wrapper { width: 100%; margin: 0; padding: 0; background-color: #F2F4F6; }" +
	            ".email-body { width: 100%; margin: 0; padding: 0; }" +
	            ".email-body_inner { width: 570px; margin: 0 auto; padding: 0; background-color: #FFFFFF; }" +
	            ".content-cell { padding: 45px; }" +
	            "</style>" +
	            "</head>" +
	            "<body>" +
	            "<table class=\"email-wrapper\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">" +
	            "<tr><td align=\"center\">" +
	            "<table class=\"email-content\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">" +
	            "<tr><td class=\"email-body\" width=\"570\" cellpadding=\"0\" cellspacing=\"0\">" +
	            "<table class=\"email-body_inner\" align=\"center\" width=\"570\" cellpadding=\"0\" cellspacing=\"0\">" +
	            "<tr><td class=\"content-cell\">" +
	            "<div class=\"f-fallback\">" +
	            "<h1>Datos del usuario: </h1>" +
	            "<p>Nombres: " + usuarioDTO.getNombres() +"</p>" +
	            "<p>Apellidos: " + usuarioDTO.getApellidos()+ "</p>" +
	            "<p>Correo: " + usuarioDTO.getCorreo()+ " </p>" +
	            "<p>Número Telefónico: " + usuarioDTO.getNumero_telefonico()+ " </p>" +
	            "</div></td></tr></table></td></tr></table></td></tr></table>" +
	            "</body></html>";
		
		try {
			usuarioService.sendHtmlEmail(email, subject, message);
			
			
		} catch (Exception e) {
			return new ResponseEntity<>("Error al enviar el correo electrónico" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("------------------------------------");
		log.info("El usuario se registró correctamente");
		log.info("Nombre: {}", usuarioDTO.getNombres());
		log.info("Apellido: {}", usuarioDTO.getApellidos());
		log.info("Correo: {}", usuarioDTO.getCorreo());
		log.info("Número telefónico: {}", usuarioDTO.getNumero_telefonico());
		return new ResponseEntity<>(usuario, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Usuario>> listUsuarios (){
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
}
