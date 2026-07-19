package ekabotbank.service;


import ekabotbank.dto.LoginRequest;
import ekabotbank.dto.LoginResponse;
import ekabotbank.dto.RegisterRequest;
import ekabotbank.dto.RegisterResponse;
import ekabotbank.entity.User;
import ekabotbank.exception.InvalidCredentialsException;
import ekabotbank.exception.UsernameAlreadyExistsException;
import ekabotbank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterResponse register (RegisterRequest registerRequest) {
        if (userRepository.existsByUsername(registerRequest.getUsername())) {


            throw new UsernameAlreadyExistsException("Username already exists"
            );
        }
        User user = new User();

        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole("CUSTOMER");

        User savedUser = userRepository.save(user);

        return new RegisterResponse(
                savedUser.getUsername(),
                savedUser.getRole()
        );
    }
    public LoginResponse login (LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());

        if (user == null) {
            throw new InvalidCredentialsException("Invalid username or password");
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid username or password");
        }
        return new LoginResponse(
                "Login successful"
        );
    }

}
