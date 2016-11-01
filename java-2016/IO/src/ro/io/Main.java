package ro.io;

import java.io.IOException;

/**
 * 
 *    This application, can read an external TXT file with employees and compute their salary and also the bonus.
 *    The format must be like this: 
 *    
 *        Name|Job Position|Worked hours|Days Off|Nr of prepaid sales|Nr of postpaid sales
 *        
 *        e.g. Kurt Douglas|Sales Officer|160|2|5|5
 *        
 *        
 * @author Ovidiu
 * 
 * 
 * 
 */


public class Main {

	public static void main(String[] args) throws IOException {

		Compute compute = new Compute();

		compute.readAndCompute();
		compute.listManagers();

	}
}
