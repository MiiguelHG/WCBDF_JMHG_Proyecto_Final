package com.upiiz.ProyectoFinal.controllers;

import com.upiiz.ProyectoFinal.entities.CustomResponse;
import com.upiiz.ProyectoFinal.entities.UserEntity;
import com.upiiz.ProyectoFinal.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Users", description = "API para administrar los usuarios")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<CustomResponse<UserEntity>> findUserByUsername(@RequestBody UserEntity user) {
        Link usersLinks = linkTo(UserController.class).withSelfRel();
        List<Link> links = List.of(usersLinks);

        try {
            UserEntity userdb = userService.findByUsername(user.getUsername());

            if (userdb == null) {
                CustomResponse<UserEntity> response = new CustomResponse<>(0, "Usuario no encontrado", null, links);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

            if (!user.getPassword().equals(userdb.getPassword())) {
                CustomResponse<UserEntity> response = new CustomResponse<>(0, "Contraseña incorrecta", null, links);
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            CustomResponse<UserEntity> response = new CustomResponse<>(1, "Usuario encontrado", userdb, links);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            CustomResponse<UserEntity> response = new CustomResponse<>(0, "Error al buscar el usuario " + e, null, links);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
