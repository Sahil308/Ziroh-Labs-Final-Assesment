package demo;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
/**
 * this class contains two method one for encryption and one for decryption of the array
 * @author SAHIL
 *
 */
public class AES 
{
	SecretKeySpec key;	//symmetric key used for encryption and decryption
	/**
	 * Constructer for initializing the key value
	 * @param key
	 */
	public AES(SecretKeySpec key)
	{
		this.key=key;
	}
	/**
	 * this method encrypts the array
	 * @param block
	 * @param keyspec
	 * @return byte[]
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] encrypt(byte[] block) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException 
	{
		Cipher cipher=Cipher.getInstance("AES");	//creating the object of cipher class for AES encryption algorithm
		cipher.init(Cipher.ENCRYPT_MODE,key);	//initializing the cipher to encrypt mode
		byte[] ciphertext=cipher.doFinal(block); 	//encrypting the array
		return ciphertext;	//returning the encrypted array
	}
	/**
	 * this method decrypts the array
	 * @param ciphertext
	 * @param keyspec
	 * @return byte[]
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] decrypt(byte[] ciphertext) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
	{
		Cipher cipher=Cipher.getInstance("AES");	//creating the object of cipher class for AES encryption algorithm
		cipher.init(Cipher.DECRYPT_MODE,key);	//initializing the cipher to decrypt mode
		byte [] plaintext=cipher.doFinal(ciphertext);	//decrypting the array
		return plaintext;	//returning the decrypted array
	}
}
