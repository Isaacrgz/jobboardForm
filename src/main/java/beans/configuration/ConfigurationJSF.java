package beans.configuration;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;
import static jakarta.faces.annotation.FacesConfig.Version.JSF_2_3;

@FacesConfig(
        version = JSF_2_3
)
@ApplicationScoped
public class ConfigurationJSF {
    
}
