package pl.sek.sh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "auth")
public class Authentication {
    private String login;
    private String password;
}
