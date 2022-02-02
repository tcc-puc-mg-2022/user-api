package br.com.pucminas.tcc.ms.user;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsAutenticacaoApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(MsAutenticacaoApplication.class, args);
    }


    @Bean
    public KeycloakSpringBootConfigResolver keycloakSpringBootConfigResolver(){
        return new KeycloakSpringBootConfigResolver();
    }
}
