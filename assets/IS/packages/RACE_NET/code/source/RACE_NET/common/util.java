package RACE_NET.common;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.util.*;
import java.math.BigInteger;
import java.security.KeyStore;
import java.security.Security;
import java.security.Signature;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
// --- <<IS-END-IMPORTS>> ---

public final class util

{
	// ---( internal utility methods )---

	final static util _instance = new util();

	static util _newInstance() { return new util(); }

	static util _cast(Object o) { return (util)o; }

	// ---( server methods )---




	public static final void calcSHA256 (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(calcSHA256)>> ---
		// @sigtype java 3.5
		// [i] field:0:required input
		// [o] field:0:required statusMsg
		// [o] field:0:required hexaString
		IDataCursor pipelineCursor = pipeline.getCursor();
		String input = IDataUtil.getString(pipelineCursor, "input");
		pipelineCursor.destroy();
		
		String statusMsg="";
		String hexaString="";	
		try{
			
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
			
			StringBuilder hexStr = new StringBuilder(2 * encodedhash.length);
			//Debug.log(4,"*****encodedhash length :::"+encodedhash.length);
		    
			for (int i = 0; i < encodedhash.length; i++) {
		        String hex = Integer.toHexString(0xff & encodedhash[i]);
		        
		        //Debug.log(4,"*****hex length :::"+hex.length());
		        
		        if(hex.length() == 1) {
		        	hexStr.append('0');
		        }
		        hexStr.append(hex);
		        hexaString=hexStr.toString();
		    }		
		   		    
		    statusMsg="Success";
		    
		    //Debug.log(4,"*****hexa String11: :::"+hexaString);		    
		   
		}catch(java.security.NoSuchAlgorithmException nse){
			statusMsg="Exception while hash SHA256:::"+nse.toString();
		      //pipelineCursor.insertAfter("status", "Exception while hash SHA512:::"+nse.toString());
		}catch (Exception e) {
			statusMsg="Exception while hash SHA256:::"+e.toString();
		       //pipelineCursor.insertAfter("status", "Exception while hash SHA512:::"+e.toString());        	
		}
		IDataCursor pipelineCursorOut = pipeline.getCursor();
		pipelineCursorOut.insertAfter("statusMsg", statusMsg);
		pipelineCursorOut.insertAfter("hexaString", hexaString.toString().toUpperCase());
		pipelineCursorOut.destroy();
		// --- <<IS-END>> ---

                
	}
}

