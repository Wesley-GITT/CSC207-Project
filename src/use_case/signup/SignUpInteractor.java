package use_case.signup;

import entity.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/*
Implement the sign-up use case logic
 */
@Service
public abstract class SignUpInteractor implements SignUpInputBoundary {
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private SignUpOutputBoundary signUpOutputBoundary;

    @Autowired
    public SignUpInteractor(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.signUpOutputBoundary = signUpOutputBoundary;
    }

    @Override
    public SignUpOutputData registerUser(SignUpInputData signUpInputData) {

        String hashPassword = passwordEncoder.encode(signUpInputData.getPassword());

        User user = new User(signUpInputData.getUsername(), hashPassword, signUpInputData.getName()
                , signUpInputData.getAddress(), signUpInputData.getContactInfo());
        userRepository.save(user);

        SignUpOutputData signUpOutputData = new SignUpOutputData(true, "User registered successfully");

        signUpOutputBoundary.presentSignUpResult(signUpOutputData);

        return signUpOutputData;
    }
}
