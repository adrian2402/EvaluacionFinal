/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.serviceImpl;

import com.example.demo.entity.Pedido;
import java.util.List;

/**
 *
 * @author Victor Rosales
 */
public interface PedidoService {
    Pedido create(Pedido pedido);
    Pedido update(Pedido pedido);
    void delete(int id);
    Pedido read(int id);
    List<Pedido> readAll();
}
