package demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * this class contains a method for dividing the array into multiple blocks
 * @author SAHIL
 *
 */
public class BlockDivider 
{
	/**
	 * this method divides the array into blocks of required blocksize
	 * @param text
	 * @param blocksize
	 * @return List<byte[]>
	 */
	public List<byte[]> divideArray(byte[] text, int blocksize) {

	    List<byte[]> result = new ArrayList<byte[]>();	//initializes the list of array in which the elements will be copied
	    int start = 0;	//initializes the starting index
	    while (start < text.length)	//loop will start from 0 and run till the last element of text array
	    {
	        result.add(Arrays.copyOfRange(text, start, start + blocksize));	//copying the elements from the array to list of array, from the start index till the blocksize 
	        start += blocksize;	//increments the starting index each time with the blocksize
	    }
	    return result;	//returns the final list of array
	}
}

