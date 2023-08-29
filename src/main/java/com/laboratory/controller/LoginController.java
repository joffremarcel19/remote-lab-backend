package com.laboratory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laboratory.exception.ModeloNotFoundException;
import com.laboratory.model.ResetToken;
import com.laboratory.model.Users;
import com.laboratory.service.ILoginService;
import com.laboratory.service.IResetTokenService;


@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private ILoginService service;

	@Autowired
	private IResetTokenService tokenService;

	//@Autowired
	//private EmailUtil emailUtil;

	/*@PostMapping(value = "/enviarCorreo", consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<Integer> enviarCorreo(@RequestBody String correo) throws Exception {
		/*int rpta = 0;
		Users us = service.verificarNombreUsuario(correo);
		if (us != null && us.getIdUsuario() > 0) {
			ResetToken token = new ResetToken();
			token.setToken(UUID.randomUUID().toString());
			token.setUser(us);
			token.setExpiracion(10);
			tokenService.registrar(token);

			Mail mail = new Mail();
			mail.setFrom("joffremarcel19@gmail.com");
			mail.setTo(us.getUsername());
			mail.setSubject("RESTABLECER CONTRASEÑA MEDIAPP");

			Map<String, Object> model = new HashMap<>();
			String url = "http://localhost:4200/recuperar/" + token.getToken();
			model.put("user", token.getUser().getUsername());
			model.put("resetUrl", url);
			mail.setModel(model);

			emailUtil.enviarMail(mail);

			rpta = 1;
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}*/

	@GetMapping(value = "/restablecer/verificar/{token}")
	public ResponseEntity<Integer> verificarToken(@PathVariable("token") String token) {
		
		int rpta = 0;
		try {
			if (token != null && !token.isEmpty()) {
				ResetToken rt = tokenService.findByToken(token);
				if (rt != null && rt.getId() > 0) {
					if (!rt.expired()) {
						rpta = 1;
					}
				}

			}
		} catch (Exception ex) {
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}

	@PostMapping(value = "/restablecer/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> restablecerClave(@PathVariable("token") String token, @RequestBody String clave) {
		try {
			ResetToken rt = tokenService.findByToken(token);
			service.CambiarClave(clave, rt.getUser().getUsername());
			tokenService.eliminar(rt.getId());
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping(value = "/obtenerusuario/{login}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> obtenerUsuario(@PathVariable("login") String login) {
	
		Users us = service.verificarNombreUsuario(login);
		if (us == null) {
			throw new ModeloNotFoundException("Usuario no Encontrado" + us);
		}
		return new ResponseEntity<Users>(us, HttpStatus.OK);
	}
}
