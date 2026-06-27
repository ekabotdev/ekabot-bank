package ekabotbank.controller;


import ekabotbank.dto.RegisterRequest;
import ekabotbank.dto.RegisterResponse;
import ekabotbank.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    public final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }
}
