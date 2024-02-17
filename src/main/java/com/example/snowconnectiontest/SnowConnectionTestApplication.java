package com.example.snowconnectiontest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8DecryptorProviderBuilder;
import org.bouncycastle.operator.InputDecryptorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.bouncycastle.pkcs.PKCSException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.Security;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.Properties;


@SpringBootApplication
public class SnowConnectionTestApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SnowConnectionTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
