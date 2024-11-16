package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import use_case.login.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    private final LoginInputBoundary loginInteractor;

    @Autowired
    public LoginController(LoginInputBoundary loginInteractor) {
        this.loginInteractor = loginInteractor;
    }

    @PostMapping
    public LoginOutputData login(@RequestBody LoginInputData inputData) {
        return loginInteractor.login(inputData);
    }
}