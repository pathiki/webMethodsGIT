package RACE_API;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
// --- <<IS-END-IMPORTS>> ---

public final class util

{
	// ---( internal utility methods )---

	final static util _instance = new util();

	static util _newInstance() { return new util(); }

	static util _cast(Object o) { return (util)o; }

	// ---( server methods )---




	public static final void EpochTimeConverter (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(EpochTimeConverter)>> ---
		// @sigtype java 3.5
		// [i] field:0:required EpochTime
		// [o] field:0:required LocalTime
		IDataCursor pipelineCursor = pipeline.getCursor();
		String	EpochTime = IDataUtil.getString( pipelineCursor, "EpochTime" );
		pipelineCursor.destroy();
		
		Long EpochTimeLong= Long.parseLong(EpochTime);
		LocalDateTime date=LocalDateTime.ofInstant(Instant.ofEpochMilli(EpochTimeLong), ZoneId.systemDefault());
		
		String localTime= date.format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"));
			
		// pipeline
		IDataCursor pipelineCursor_1 = pipeline.getCursor();
		IDataUtil.put( pipelineCursor_1, "LocalTime", localTime );
		pipelineCursor_1.destroy();
		// --- <<IS-END>> ---

                
	}
}

