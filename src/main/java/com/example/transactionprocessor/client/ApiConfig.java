package com.example.transactionprocessor.client;


import Api.CaptureApi;
import Api.PaymentsApi;
import Invokers.ApiClient;
import com.cybersource.authsdk.core.ConfigException;
import com.cybersource.authsdk.core.MerchantConfig;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ApiConfig {

    private final MerchantConfig merchantConfig;

    public ApiConfig(
            @Value("${cyber-source.merchant-id}") String merchantId,
            @Value("${cyber-source.merchant-key-id}") String merchantKeyId,
            @Value("${cyber-source.merchant-key-secret}") String merchantKeySecret,
            @Value("${cyber-source.authentication-type}") String authenticationType,
            @Value("${cyber-source.run-environment}") String runEnvironment,
            @Value("${cyber-source.use-meta-key}") boolean useMetaKey,
            @Value("${cyber-source.enable-log}") boolean enableLog,
            @Value("${cyber-source.log-directory}") String logDirectory,
            @Value("${cyber-source.log-filename}") String logFilename,
            @Value("${cyber-source.log-maximum-size}") String logMaximumSize
    ) throws ConfigException {

        Properties props = new Properties();

        // HTTP_Signature = http_signature and JWT = jwt
        props.setProperty("authenticationType", authenticationType);
        props.setProperty("merchantID", merchantId);
        props.setProperty("runEnvironment", runEnvironment);

        props.setProperty("merchantKeyId", merchantKeyId);
        props.setProperty("merchantsecretKey", merchantKeySecret);
        // Logging to be enabled or not.
        props.setProperty("enableLog", enableLog ? "true" : "false");
        // Log directory Path
        props.setProperty("logDirectory", logDirectory);
        props.setProperty("logFilename", logFilename);

        // Log file size in KB
        props.setProperty("logMaximumSize", logMaximumSize);

        props.setProperty("useMetaKey", useMetaKey ? "true" : "false");

        this.merchantConfig = new MerchantConfig(props);
    }


    @Bean
    public PaymentsApi paymentsApi() {
        return new PaymentsApi(new ApiClient(this.merchantConfig));
    }

    @Bean
    public CaptureApi captureApi() {
        return new CaptureApi(new ApiClient(this.merchantConfig));
    }


}
