// ... other imports
import com.example.demo.model.Role;  // Add this import
import com.example.demo.model.User;
// ...

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    
    // ... other code
    
    @Override
    public User register(UserRegisterDto dto) {
        // ... validation code
        
        User.UserBuilder userBuilder = User.builder()
            .name(dto.getName())
            .email(dto.getEmail())
            .password(passwordEncoder.encode(dto.getPassword()))
            .createdAt(LocalDateTime.now());
        
        // Convert string roles to Role enum
        Set<Role> roles = dto.getRoles().stream()
            .map(roleStr -> {
                try {
                    return Role.valueOf(roleStr.toUpperCase());
                } catch (IllegalArgumentException e) {
                    return Role.ROLE_USER;
                }
            })
            .collect(Collectors.toSet());
        
        if (roles.isEmpty()) {
            roles.add(Role.ROLE_USER);
        }
        
        User user = userBuilder.roles(roles).build();
        
        return userRepository.save(user);
    }
    
    // ... rest of the code
}