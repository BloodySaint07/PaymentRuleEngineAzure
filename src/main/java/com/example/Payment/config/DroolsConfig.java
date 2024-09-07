package com.example.Payment.config;



import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DroolsConfig {

    private static final KieServices kieServices = KieServices.Factory.get();
    private static final String drl_file_path = "rules/Discount_rules.drl";

    @Bean
    public KieContainer getKieContainer() {
        // Setup Kie File System from Kei Service
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(drl_file_path));

        // Setup Kie Builder from Kei Service
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();

        // Setup Kie Module from kieBuilder
        KieModule kieModule = kieBuilder.getKieModule();

        // Setup Kie Container from Kei Service
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());

        return kieContainer;
    }

}
