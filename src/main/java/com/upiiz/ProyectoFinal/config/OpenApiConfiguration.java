package com.upiiz.ProyectoFinal.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de facturas",
                version = "1.0.0",
                description = "API para la gestión de facturas",
                contact = @Contact(
                        name = "Jesus Miguel Hernandez Garcia",
                        email = "jhernandezg1710@alumno.ipn.mx"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        servers = {
                @Server(
                        description = "Servidor local de pruebas",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Servidor de producción",
                        url = "https://wcbdf-jmhg-proyecto-final.onrender.com"
                )
        }
)
public class OpenApiConfiguration {
}
