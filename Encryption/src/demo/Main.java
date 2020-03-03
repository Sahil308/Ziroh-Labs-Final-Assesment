package demo;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Main 
{
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
	{
		BlockDivider blockDivider=new BlockDivider();
		String string="Java was originally developed by James Gosling at Sun Microsystems (which has since been acquired by Oracle) and released in 1995 as a core component of Sun "
				+ "Microsystems' Java platform. The original and reference implementation Java compilers, virtual machines, and class libraries were originally released by Sun "
				+ "under proprietary licenses. As of May 2007, in compliance with the specifications of the Java Community Process, Sun had relicensed most of its Java "
				+ "technologies under the GNU General Public License. Meanwhile, others have developed alternative implementations of these Sun technologies, such as the GNU "
				+ "Compiler for Java (bytecode compiler), GNU Classpath (standard libraries), and IcedTea-Web (browser plugin for applets).";
		List<byte[]> blocks=blockDivider.divideArray(string.getBytes(), 16);
//		for(byte[]t:c)
//		{
//			for(int i=0;i<t.length;i++) {
//				System.out.print(t[i]);
//			}
//			System.out.println();
//		}
		CBC cbc=new CBC();
		Key_Generator key_Generator=new Key_Generator();
		SecretKeySpec key=key_Generator.generateKey("AES");
		IV_Generator iv_Generator=new IV_Generator();
		byte[] iv=iv_Generator.generateIV();
		List<byte[]> ciphertext=cbc.blockChainingEncrypt(c, iv, key);
		for(byte[] temp:ciphertext)
		{
			String str=new String(temp);
			System.out.println(str);
		}
		List<byte[]> plaintext=cbc.blockChainingDecrypt(ciphertext, iv, key);
		for(byte[] temp:plaintext)
		{
			String str=new String(temp);
			System.out.println(str);
		}
	}
}
