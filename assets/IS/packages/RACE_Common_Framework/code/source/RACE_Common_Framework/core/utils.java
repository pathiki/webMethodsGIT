package RACE_Common_Framework.core;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2012-09-06 17:07:13 SGT
// -----( ON-HOST: AMBG2K207DEV.SEC.ahb.com

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.b2b.server.ServerAPI;
import com.wm.lang.ns.NSName;
import com.wm.lang.ns.NSService;
import com.wm.app.b2b.server.InvokeState;
import java.io.File;
import java.util.Stack;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void getInterfaceConfFilePath (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(getInterfaceConfFilePath)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required packageName
		// [o] field:0:required configFilePath
		IDataCursor pipelineCursor = null;
		try {
			pipelineCursor = pipeline.getCursor();
			String packageName = IDataUtil.getString (pipelineCursor, "packageName");
			if (packageName == null)
				throw new IllegalArgumentException("Interface packageName is null");
		
		//	String configFilePath = System.getProperty(CONFIG_FILE_PROPERTY_NAME);
		//	if (configFilePath == null) {
				File configDir = ServerAPI.getPackageConfigDir(packageName);
				String configDirStr = configDir.getCanonicalPath();
				String configFilePath = configDirStr + "/" + CONFIG_FILE_NAME;
		//	}
		
			IDataUtil.put(pipelineCursor, "configFilePath", configFilePath);
		} catch (Exception ex) {
			throw new ServiceException(ex);
		} finally {
			if (pipelineCursor != null)
				pipelineCursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	
	//private static final String PACKAGE_NAME = "xxxx";
	private static final String CONFIG_FILE_NAME = "InterfaceConfig.xml";
	//private static final String CONFIG_FILE_PROPERTY_NAME = "watt.xxx.configFile";
	
	
	// --- <<IS-END-SHARED>> ---
}

