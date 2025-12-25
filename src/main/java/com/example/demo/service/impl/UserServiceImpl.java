@Service
public class UserServiceImpl implements UserService {

    @Override
    public User register(UserRegisterDto dto) {
        return User.builder().email(dto.getEmail()).build();
    }

    @Override
    public AuthResponse login(AuthRequest req) {
        return new AuthResponse("token");
    }

    @Override
    public User getByEmail(String email) {
        return new User();
    }
}
