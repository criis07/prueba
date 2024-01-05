package com.pruebatecnica.prueba.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @RequestMapping(value = "/prueba")
    public response prueba(){
        response response = new response();
        response.name = "Objeto";
        response.description = "Nuevo";

        return response;
    }
    public class response{
        public void setName(String name) {
            this.name = name;
        }

        private String name;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        private String description;

        public String getName() {
            return name;
        }

        public response() {
        }
    }
}
