/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.serviceImpl;

import com.example.demo.entity.Rol;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Victor Rosales
 */
@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        
        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }
        
        List<GrantedAuthority> roles = new ArrayList<>();
        
        for(Rol rol: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}
