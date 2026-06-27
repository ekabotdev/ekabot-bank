package ekabotbank.service;


import ekabotbank.dto.RegisterRequest;
import ekabotbank.dto.RegisterResponse;
import ekabotbank.entity.User;
import ekabotbank.exception.UsernameAlreadyExistsException;
import ekabotbank.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public RegisterResponse register (RegisterRequest registerRequest) {
        if (userRepository.existsByUsername(registerRequest.getUsername())) {


            throw new UsernameAlreadyExistsException("Username already exists"
            );
        }
        User user = new User();

        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setRole("CUSTOMER");

        User savedUser = userRepository.save(user);

        return new RegisterResponse(
                savedUser.getUsername(),
                savedUser.getRole()
        );
    }

}
