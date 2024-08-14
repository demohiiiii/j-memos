package top.demohiiiii.memos.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "memos")
@Data
public class Profile {
    private String mode = "demo";
    @Value("${memos.public:false}")
    private boolean pub = false;
    private boolean passwordAuth = false;
    private String version = "0.0.1";
}
