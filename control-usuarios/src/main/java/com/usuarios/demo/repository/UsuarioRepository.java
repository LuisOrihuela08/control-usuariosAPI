package com.usuarios.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarios.demo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
