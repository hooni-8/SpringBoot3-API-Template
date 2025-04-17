package org.template.template.service.v1.jasypt;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.jasypt.iv.RandomIvGenerator;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JasyptService {

    public String encrypt(String key, String content) {
        StandardPBEStringEncryptor encryptor = createEncryptor(key);
        try {
            return encryptor.encrypt(content);
        } catch (EncryptionOperationNotPossibleException e) {
            throw new IllegalStateException("Encryption failed", e);
        }
    }

    public String decrypt(String key, String content) {
        StandardPBEStringEncryptor encryptor = createEncryptor(key);
        try {
            return encryptor.decrypt(content);
        } catch (EncryptionOperationNotPossibleException e) {
            throw new IllegalStateException("Encryption failed", e);
        }
    }

    private StandardPBEStringEncryptor createEncryptor(String key) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(key);
        config.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        config.setIvGenerator(new RandomIvGenerator());
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setConfig(config);
        return encryptor;
    }

}
