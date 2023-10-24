package co.udea.ssmu.api.utils.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // o puedes restringir a un endpoint específico, por ej. "/api/**"
                .allowedOrigins("*")  // puedes cambiar "*" por dominios específicos, por ej. "http://mi-dominio.com"
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS")
                .allowedHeaders("*")  // si necesitas especificar headers específicos puedes hacerlo
                .allowCredentials(true)
                .maxAge(3600);
    }
}
