package demo;

import java.security.SecureRandom;
/**
 * this class contains one method for generating the initialization vector
 * @author SAHIL
 *
 */
public class IV_Generator
{
	/**
	 * this methods generates the initialization vector
	 * @return byte[]
	 */
	public byte[] generateIV()
	{
		byte[] iv=new byte[16];	//creating a array of 16 bytes to store the initialization vector
		SecureRandom random=new SecureRandom();	//creating an object of SecureRandom class to generate a random initialization vector
		random.nextBytes(iv);	//it will randomly generate 16 bytes
		return iv;	//returning the initialization vector
	}
}

