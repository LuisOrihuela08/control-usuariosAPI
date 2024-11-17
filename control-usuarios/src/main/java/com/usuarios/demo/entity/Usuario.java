package com.usuarios.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usuario_id;
	private String nombres;
	private String apellidos;
	private String correo;
	private String numero_telefonico;
	
	public Usuario(String nombres, String apellidos, String correo, String numero_telefonico) {
		
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.numero_telefonico = numero_telefonico;
	}
	
	
}
