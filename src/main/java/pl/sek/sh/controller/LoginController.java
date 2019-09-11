package pl.sek.sh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping()
    public ResponseEntity<HttpStatus> login(){
        // dummy login to create cookie
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
