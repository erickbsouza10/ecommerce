package com.ecommerce.ecommerce.domain.user;

import com.ecommerce.ecommerce.domain.user.dto.LoginDTO;
import com.ecommerce.ecommerce.domain.user.dto.RegisterDTO;
import com.ecommerce.ecommerce.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public User criar(RegisterDTO dto) {

        if (repository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email já cadastrado");
        }

        User user = User.builder()
                .nome(dto.nome())
                .username(dto.username())
                .email(dto.email())
                .senha(encoder.encode(dto.senha()))
                .created(LocalDateTime.now())
                .build();

        return repository.save(user);
    }

    public String login(LoginDTO dto) {

        User user = repository.findByEmail(dto.email())
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado"));

        boolean senhaCorreta =
                encoder.matches(dto.senha(), user.getSenha());

        if (!senhaCorreta) {
            throw new RuntimeException("Senha inválida");
        }

        return jwtService.gerarToken(user.getEmail());
    }
}