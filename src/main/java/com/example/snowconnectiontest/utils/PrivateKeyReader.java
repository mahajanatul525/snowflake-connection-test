package com.example.snowconnectiontest.utils;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JceOpenSSLPKCS8DecryptorProviderBuilder;
import org.bouncycastle.operator.InputDecryptorProvider;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.security.Security;

@Component
    public  class PrivateKeyReader
    {

        // If you generated an encrypted private key, implement this method to return
        // the passphrase for decrypting your private key.
       /* private static String getPrivateKeyPassphrase() {
            return "qwerty1234";
        }*/

        public static PrivateKey get(String filename, String passphrase)
                throws Exception
        {
            PrivateKeyInfo privateKeyInfo = null;
            Security.addProvider(new BouncyCastleProvider());
            // Read an object from the private key file.
            PEMParser pemParser = new PEMParser(new FileReader(Paths.get(filename).toFile()));
            Object pemObject = pemParser.readObject();
            if (pemObject instanceof PKCS8EncryptedPrivateKeyInfo) {
                // Handle the case where the private key is encrypted.
                PKCS8EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = (PKCS8EncryptedPrivateKeyInfo) pemObject;
                InputDecryptorProvider pkcs8Prov = new JceOpenSSLPKCS8DecryptorProviderBuilder().build(passphrase.toCharArray());
                privateKeyInfo = encryptedPrivateKeyInfo.decryptPrivateKeyInfo(pkcs8Prov);
            } else if (pemObject instanceof PrivateKeyInfo) {
                // Handle the case where the private key is unencrypted.
                privateKeyInfo = (PrivateKeyInfo) pemObject;
            }
            pemParser.close();
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider(BouncyCastleProvider.PROVIDER_NAME);
            return converter.getPrivateKey(privateKeyInfo);
        }
    }





