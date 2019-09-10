package pl.sek.sh.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class MyBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
 
    @Override
    public void commence (HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) throws IOException, ServletException {
        response.addHeader("WWW-Authenticate", "Basic realm = " + getRealmName() + "");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        log.info("Unauthorized login attempt");
    }
 
    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("SoftwareHouse");
        super.afterPropertiesSet();
    }
}
