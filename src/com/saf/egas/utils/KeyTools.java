package com.miraglo.egas.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.logging.Level;

import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KeyTools {
	private static final Logger logger=org.slf4j.LoggerFactory.getLogger(KeyTools.class);
	@Value("#{securityConfig.keypath}")
	public String keyPath;
	
	public static File privatekey=null;
    public static File publickey=null;
   
    @PostConstruct
    public void doPostContruct(){
    	privatekey=new File(keyPath+"private.key");
    	publickey=new File(keyPath+"public.key");
    	logger.debug("######################################\nKey Store Initialized!\nPrivate key:"+keyPath+"private.key"+"\nPublic key:"+keyPath+"public.key"+"\n######################################");
    }
    /**
     * 
     * @param msg The message to be encrypted
     * @return The encrypted string as hex string
     */
    public String encrypt(String msg){
        try {
        	
            return HexUtils.getHexString(rsaEncrypt(msg.getBytes()));
        } catch (UnsupportedEncodingException ex) {
        	 ex.printStackTrace();
            return null;
        }
    }
    /**
     * 
     * @param msg The message to be decrypted 
     * @return The decrypted message
     */
    public String decrypt(String msg){
        return new String(rsaDecrypt(HexUtils.hexStringToByteArray(msg)));
    }
    private byte[] rsaDecrypt(byte[] data) {
        ObjectInputStream oin = null;
        try {

            InputStream in = new FileInputStream(privatekey);
            oin = new ObjectInputStream(new BufferedInputStream(in));
            PrivateKey privKey = null;
            try {
                BigInteger m = (BigInteger) oin.readObject();
                BigInteger e = (BigInteger) oin.readObject();
                RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(m, e);
                KeyFactory fact = KeyFactory.getInstance("RSA");
                privKey = fact.generatePrivate(keySpec);

            } catch (Exception e) {
                throw new RuntimeException("Spurious serialisation error", e);
            } finally {
                oin.close();
            }
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privKey);
            byte[] cipherData = cipher.doFinal(data);
            return cipherData;
        }  catch (IOException ex) {
        	 ex.printStackTrace();
        } catch (IllegalBlockSizeException ex) {
        	 ex.printStackTrace();
        } catch (BadPaddingException ex) {
        	 ex.printStackTrace();
        } catch (InvalidKeyException ex) {
        	 ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
        	 ex.printStackTrace();
        } catch (NoSuchPaddingException ex) {
            ex.printStackTrace();
        } finally {
            try {
                oin.close();
            } catch (IOException ex) {
            	 ex.printStackTrace();
            }
        }
        return null;
    }

    private byte[] rsaEncrypt(byte[] data) {
        {
            PublicKey pubKey = null;
            ObjectInputStream oin = null;
            try {
                InputStream in = new FileInputStream(publickey);
                oin = new ObjectInputStream(new BufferedInputStream(in));

                BigInteger m = (BigInteger) oin.readObject();
                BigInteger e = (BigInteger) oin.readObject();
                RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
                KeyFactory fact = KeyFactory.getInstance("RSA");
                pubKey = fact.generatePublic(keySpec);


                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.ENCRYPT_MODE, pubKey);
                byte[] cipherData = cipher.doFinal(data);
                return cipherData;
            } catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchPaddingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidKeyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvalidKeySpecException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalBlockSizeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BadPaddingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
                try {
                    oin.close();
                } catch (IOException ex) {
                   
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
		KeyTools kt=new KeyTools();
		System.out.println("mesgggggggggggg"+kt.decrypt("77d5c0bf1bfd8453e6066775cb353b36de8cd591e3085712c3c1bfefed5f6b23fde8ea71d129ed61ddc3e80be9ed9c3ca7fffeee5cbd8e51e9971f3e3210e3f01e4dfa5eece98b4088250984dd0e6c6dd4b77799b25869d66438b1f188f0339b9483fdebebe09c462d9c9254d59a93fedb8f29581298dbe6898a24d15f0f12fe7f4e82ebeac826ce444139313d69c7789528ccea351788d05568a70dc9eac7dd9f52e60a6c9476be3790ada5aeefd5c3de1c4c83ca9077e9b0ae1c7ac24491058656830dacc19332c7eb3dd6bc218b9dc2db06866ceb6fc7d1c12f0e7d103b4c2e7643045f0aae9db71cdce3acef0eed88e9b2b22f9346a98ff3921736d6e48a"));

	}
}
