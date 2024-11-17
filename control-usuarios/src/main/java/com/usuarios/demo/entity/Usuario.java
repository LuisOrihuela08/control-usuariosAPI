package com.usuarios.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "usuario")
public class Usuario {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private int usuario_id;
	private String nombres;
	private String apellidos;
	private String correo;
	private String numero_telefonico;
	
	
	
	
}
