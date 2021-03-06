package ${basePackage}.configuration;

import ${baseCommonPackage}.model.dubbo.*;
import ${basePackage}.properties.DubboProperties;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig {

    @Autowired
    DubboProperties dubboProperties;

    @Bean
    public ApplicationConfig applicationConfig() {

        DubboApplicationProperties applicationProperties = dubboProperties.getApplication();

        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setId(applicationProperties.getId());
        applicationConfig.setName(applicationProperties.getName());
        return applicationConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig() {

        DubboProtocolProperties protocolProperties = dubboProperties.getProtocol();

        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName(protocolProperties.getName());
        protocolConfig.setPort(protocolProperties.getPort());
        return protocolConfig;
    }

    @Bean
    public ProviderConfig providerConfig() {

        DubboProviderProperties providerProperties = dubboProperties.getProvider();

        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setTimeout(providerProperties.getTimeout());
        return providerConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {

        DubboRegistryProperties registryProperties = dubboProperties.getRegistry();

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setId(registryProperties.getId());
        registryConfig.setProtocol(registryProperties.getProtocol());
        registryConfig.setAddress(registryProperties.getAddress());
        registryConfig.setClient(registryProperties.getClient());
        return registryConfig;
    }
}
