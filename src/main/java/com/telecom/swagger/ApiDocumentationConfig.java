package com.telecom.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Telecom Application to store customer and phone details",
                version = "V1",
                title = "Telecom Application",
                contact = @Contact(
                   name = "Abhishek", 
                   email = "toabhishekshrivastava@gmail.com"
                ),
                license = @License(
                   name = "Apache 2.0", 
                   url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS},
        externalDocs = @ExternalDocs(value = "Instructions...", url = "")
)
public interface ApiDocumentationConfig {

}