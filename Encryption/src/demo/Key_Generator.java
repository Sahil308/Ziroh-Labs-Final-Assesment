package demo;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/**
 * this class contains one method for generating the symmetric key
 * @author SAHIL
 *
 */
public class Key_Generator
{
	/**
	 * this method generates the symmetric key
	 * @param algorithm
	 * @return SecretKeySpec
	 * @throws NoSuchAlgorithmException
	 */
	public SecretKeySpec generateKey(String algorithm) throws NoSuchAlgorithmException
	{
		KeyGenerator generator=KeyGenerator.getInstance(algorithm);	//creating an object of KeyGenerator class for aes algorithm which will generate the key
		generator.init(128);	//the size of the key in bits
		SecretKey skey=generator.generateKey();	//key is generated
		SecretKeySpec keyspec=new SecretKeySpec(skey.getEncoded(), algorithm);	//key is specified and enocded
		return keyspec;	//returning the key
	}
}


