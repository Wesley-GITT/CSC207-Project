package use_case.login;

import entity.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public abstract class LoginInteractor implements LoginInputBoundary{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final LoginOutputBoundary loginOutputBoundary;

    @Autowired
    protected LoginInteractor(UserRepository userRepository, LoginOutputBoundary outputBoundary) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.loginOutputBoundary = outputBoundary;
    }

    @Override
    public LoginOutputData login(LoginInputData loginInputData) {
        User user = userRepository.findByUsername(loginInputData.getUsername());
        if (user == null) {
            LoginOutputData outputData = new LoginOutputData(false, "User Not Found");
            loginOutputBoundary.presentLoginResult(outputData);
            return outputData;
        }
        if (!passwordEncoder.matches(loginInputData.getPassword(), user.getPassword())) {
            LoginOutputData outputData = new LoginOutputData(false, "Wrong Password");
            loginOutputBoundary.presentLoginResult(outputData);
            return outputData;
        }
        LoginOutputData outputData = new LoginOutputData(true, "Success");
        loginOutputBoundary.presentLoginResult(outputData);
        return outputData;
    }
}
