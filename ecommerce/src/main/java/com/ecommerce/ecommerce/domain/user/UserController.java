package com.ecommerce.ecommerce.domain.user;

import com.ecommerce.ecommerce.domain.user.dto.LoginDTO;
import com.ecommerce.ecommerce.domain.user.dto.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/register")
    public String register(@RequestBody RegisterDTO dto){
        service.criar(dto);
        return "Usuário criado com sucesso";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto){
        return service.login(dto);
    }
}