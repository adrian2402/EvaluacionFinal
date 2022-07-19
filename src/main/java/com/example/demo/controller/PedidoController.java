/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.entity.Pedido;
import com.example.demo.serviceImpl.PedidoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Victor Rosales
 */
@Controller
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoService productoService;
    
    @GetMapping
    public String indexProducto(Model model){
        model.addAttribute("pedido", productoService.readAll());
        return "pedidos/listarPedido";
    }
    
    @GetMapping("/add")
    public String addProducto(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("pedido", new Pedido());
        return "pedidos/addPedido";
    }
    
    @GetMapping("/save")
    public String saveProducto(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("pedido", new Pedido());
        return "pedidos/addPedido";
    }
    
    @PostMapping("/save")
    public String addEditorial(@Valid @ModelAttribute Pedido editorial, BindingResult result, Model model, RedirectAttributes attributes ) {  
        productoService.create(editorial);
        return "redirect:/pedido";
    }
    
    @GetMapping("/edit/{id}")
    public String editarEditorial(@PathVariable("id") int idpedido, Model model) {  
        Pedido editorial = productoService.read(idpedido);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("pedido", editorial);
        return "pedidos/addPedido";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteEditorial(@PathVariable("id") int idpedido) {  
       productoService.delete(idpedido);
        return "redirect:/pedido";
    }
    
}
