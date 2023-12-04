package com.alkemy.wallet.controller;
     /*En el contexto de la arquitectura de software Modelo-Vista-Controlador (MVC), el controlador
     actúa como un intermediario entre el modelo (que representa los datos) y la vista (que es la
     representación visual de los datos). . Los controladores toman las entradas del usuario,
     llaman a los métodos apropiados en los servicios para procesar estas entradas, y luego devuelven
     una respuesta al usuario.*/

import com.alkemy.wallet.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alkemy.wallet.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

}
