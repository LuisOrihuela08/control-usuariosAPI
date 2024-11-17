package com.usuarios.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private String nombres;
	private String apellidos;
	private String correo;
	private String numero_telefonico;
}
