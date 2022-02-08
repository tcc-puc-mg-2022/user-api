package br.com.pucminas.tcc.ms.user;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
public class UserServiceImpl implements UserService {

    @NonNull
    private UserRepository repository;

    @NonNull
    private ProfileRepository profileRepository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
