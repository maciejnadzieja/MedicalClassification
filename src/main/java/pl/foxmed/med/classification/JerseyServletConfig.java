package pl.foxmed.med.classification;

import org.glassfish.jersey.server.ResourceConfig;
import pl.foxmed.med.classification.icd10.resource.ICD10InjectionModule;
import pl.foxmed.med.classification.icd9cm.resource.ICD9CMInjectionModule;

public class JerseyServletConfig extends ResourceConfig {
    public JerseyServletConfig() {
        register(new ICD10InjectionModule());
        register(new ICD9CMInjectionModule());
        packages(true, "pl.foxmed.med.classification");
    }
}
