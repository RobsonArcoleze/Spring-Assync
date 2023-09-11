package br.com.robson.completablefeatureimplementation.controllers;

import br.com.robson.completablefeatureimplementation.entities.User;
import br.com.robson.completablefeatureimplementation.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@RestController
public class UserController {

    private UserService userService;

    @PostMapping(value = "/users", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
    public ResponseEntity saveUsers(@RequestBody MultipartFile... files) throws Exception {
        for(MultipartFile file: files){
            userService.saveUser(file);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/users", produces = "application/json")
    public CompletableFuture<ResponseEntity> findAllUsers(){
        return userService.findAllUsers().thenApply(ResponseEntity::ok);
    }

    @GetMapping(value = "/getUsersByThread", produces = "application/json")
    public ResponseEntity getUsers(){
        CompletableFuture<List<User>> user1 = userService.findAllUsers();
        CompletableFuture<List<User>> user2 = userService.findAllUsers();
        CompletableFuture<List<User>> user3 = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
