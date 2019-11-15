package com.luxondata.transferscaffold.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * WinBatchConfig
 *
 * @author dusk
 * @since 05/11/2019
 */
@Configuration
public class WinBatchConfig {

    @Bean
    public ProcessBuilder getProcess() {
        return new ProcessBuilder();
    }
}
