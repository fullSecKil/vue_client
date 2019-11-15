package com.luxondata.transferscaffold.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * TransferConfig
 *
 * @author dusk
 * @since 15/11/2019
 */
@Component
@ConfigurationProperties(prefix = "transfer.task-batch")
@Data
@Lazy
public class TransferProperties {
    private Map<String, String> pathMap;
}
