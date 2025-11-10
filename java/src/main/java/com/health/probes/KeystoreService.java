package com.health.probes;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class KeystoreService implements ApplicationRunner {
    
    private static final Logger logger = LoggerFactory.getLogger(KeystoreService.class);
            
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Application started. Executing keytool command...");
        executeKeytoolCommandForPKCS12();
    }
    public void executeKeytoolCommandForPKCS12() {
        try {
            String pkcs12Path = "/usr/src/app/certs/probecert.p12";
            String pkcs12Alias = "probecert";
            String pkcs12Password = "password";
            
            File keystoreFile = new File(pkcs12Path);
            if (!keystoreFile.exists()) {
                logger.warn("PKCS12 keystore file not found at: {}", pkcs12Path);
                return;
            }
            
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("keytool", "-list", "-v", 
                "-keystore", pkcs12Path, 
                "-storetype", "PKCS12",
                "-alias", pkcs12Alias,
                "-storepass", pkcs12Password);
            
            processBuilder.directory(new File(System.getProperty("user.dir")));
            
            logger.info("Executing PKCS12 keytool command: {}", String.join(" ", processBuilder.command()));
            
            Process process = processBuilder.start();
            
            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            
            StringBuilder output = new StringBuilder();
            StringBuilder errorOutput = new StringBuilder();
            
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            
            while ((line = errorReader.readLine()) != null) {
                errorOutput.append(line).append("\n");
            }
            
            boolean finished = process.waitFor(30, TimeUnit.SECONDS);
            
            if (finished) {
                int exitCode = process.exitValue();
                logger.info("PKCS12 Keytool command completed with exit code: {}", exitCode);
                
                if (exitCode == 0) {
                    logger.info("PKCS12 Keytool output:\n{}", output.toString());
                } else {
                    logger.error("PKCS12 Keytool error output:\n{}", errorOutput.toString());
                }
            } else {
                logger.error("PKCS12 Keytool command timed out");
                process.destroyForcibly();
            }
            
        } catch (Exception e) {
            logger.error("Error executing PKCS12 keytool command: {}", e.getMessage(), e);
        }
    }
}