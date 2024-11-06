package RACE_API.atomic;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.util.Debug;
// --- <<IS-END-IMPORTS>> ---

public final class javaServices

{
	// ---( internal utility methods )---

	final static javaServices _instance = new javaServices();

	static javaServices _newInstance() { return new javaServices(); }

	static javaServices _cast(Object o) { return (javaServices)o; }

	// ---( server methods )---




	public static final void concateStringToken (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(concateStringToken)>> ---
		// @sigtype java 3.5
		// [i] record:0:required input
		// [o] field:0:required output
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		String output = "";
		StringBuilder sb = new StringBuilder();
			// input
			IData	input = IDataUtil.getIData( pipelineCursor, "input" );
			if ( input != null)
			{
				
				IDataCursor inputDocumentCursor = input.getCursor();
				
				while (inputDocumentCursor.next())
				{
				String key = inputDocumentCursor.getKey();
				String value = inputDocumentCursor.getValue().toString();
				
				sb = sb.append(value);
				
				Debug.log(4,"Key:::"+key);
				Debug.log(4,"Value:::"+value);
				//Object value = pipelineCursor.getValue();
				// do whatever you need
				}
				
				output = sb.toString();
				
			}
		pipelineCursor.destroy();
		
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "output", output );
		pipelineCursor_1.destroy();
		
			
		// --- <<IS-END>> ---

                
	}
}

