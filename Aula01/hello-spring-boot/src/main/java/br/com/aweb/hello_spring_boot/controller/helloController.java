package br.com.aweb.hello_spring_boot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class helloController {
    @GetMapping
    public String sayHello(){
        return "Olá Mundo, Spring Boot";
    }
    
    @GetMapping("/ola")
    public String sayHelloCustom() {
        return "Olá endpoint especifico!";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam (required = false, defaultValue = "Visitante") String name) {
        return "Olá, " + name + "! Bem Vindo(a)!";
    }
    
    @GetMapping("/greet2")
    public String greet2(@RequestParam ("name") String userName) {
        return "Olá, " + userName + "! Bem Vindo(a)!";
    }

    @GetMapping("/calcular")
    public String calcular(
        @RequestParam (defaultValue="soma")  String op,
        @RequestParam int num1,
        @RequestParam int num2
        ) {
        int result;
        if (op.equals("sub")){
            result = num1 - num2;
        } else{
            result = num1 + num2;
        }
        return "Resultado da " + op + ": "+ result ;
    }

    @GetMapping("/mensagem")
    public String getMethodName(
        @RequestParam (defaultValue = "Visitante") String user,
        @RequestParam (defaultValue = "pt") String language
        ) {
        if (language.equals("en")){
            return "Hello, " + user + "! Welcome.";
        }
        return "Olá, " + user + "! Bem Vindo.";
    }
    
}
