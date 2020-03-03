package demo;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
/**
 * this class implements the cipher block chaining for encryption and decryption
 * @author SAHIL
 *
 */
public class CBC 
{
	/**
	 * this method encrypts the given array
	 * @param blocks
	 * @param iv
	 * @param key
	 * @return list<byte[]>
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public List<byte[]> blockChainingEncrypt(List<byte[]> blocks, byte[] iv,SecretKeySpec key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
	{
		AES aes=new AES(key);	//creating the object of AES class to call its methods
		List<byte[]> ciphertext=new ArrayList<>();	//initialize the list of array to hold the encrypted text
		for(byte[] temp:blocks)	//loop will iterate for each element in the list
		{
			byte[] block=xor(temp,iv);	//calling the method which calculates the xor of two array
			byte[] cipher=aes.encrypt(block);	//calling method declared in the AES class to encrypt the array
			iv=cipher;	//putting the value of the encrypted array in the iv,which will be needed for the next array
			ciphertext.add(cipher);	//adding the encrypted array to the list
		}
		return ciphertext;	//returns the final list of encrypted array
	}
	/**
	 * this method decrypts the given array
	 * @param ciphertext
	 * @param iv
	 * @param key
	 * @return list<byte[]>
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidAlgorithmParameterException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public List<byte[]> blockChainingDecrypt(List<byte[]> ciphertext, byte[] iv,SecretKeySpec key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
	{
		AES aes=new AES(key);	//creating the object of AES class to call its methods
		List<byte[]> plaintext=new ArrayList<>();	//initialize the list of array to hold the derypted text
		for(byte[] temp:ciphertext)	//loop will iterate for each element in the list
		{
			byte[] block=aes.decrypt(temp);	//calling method declared in the AES class to decrypt the array
			byte[]text=xor(block,iv);	//calling the method which calculates the xor of two array
			iv=temp;	//putting the value of the decrypted array in the iv,which will be needed for the next array
			plaintext.add(text);	////adding the decrypted array to the list
		}
		return plaintext;	//returns the final list of decrypted array
	}
	/**
	 * this method xors the arrays
	 * @param block
	 * @param iv
	 * @return byte[]
	 */
	private byte[] xor(byte[] block,byte[] iv)
	{
		int i=0;	//counter to iterate among the elements in the array
		byte[] temp = new byte[16];	//a temporary array which will hold the result after xor operation
		for(byte b:block)	//loop to iterate for very element in the array
		{
			temp[i]=(byte) (b^iv[i++]);	//actual xor operation takes place
		}
		return temp;	//return the xored array
	}
}
