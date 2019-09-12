package pl.sek.sh.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public LoginResponse login(){
        // dummy login to create cookie
        log.info("User logged in");
        return new LoginResponse(200,"Logged in");
    }

    @AllArgsConstructor
    @Data
    static class LoginResponse {
        Integer status;
        String message;
    }
}
