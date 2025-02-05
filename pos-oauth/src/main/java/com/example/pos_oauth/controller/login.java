package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class Login {

    @GetMapping
    public ResponseEntity<String> login(){
        return ResponseEntity.ok("Hello World");
    }

    //This will initiate the logout
    //TODO THis method needs to be implemented
    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
        return ResponseEntity.ok("Goodbye");
    }

}
