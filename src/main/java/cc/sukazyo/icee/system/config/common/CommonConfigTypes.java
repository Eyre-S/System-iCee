package cc.sukazyo.icee.system.config.common;

import cc.sukazyo.icee.iCee;
import cc.sukazyo.icee.system.Log;
import cc.sukazyo.icee.system.config.ConfigManageException;
import cc.sukazyo.icee.system.config.Configure;

public abstract class CommonConfigTypes {
	
	public static final String REQUIRED_TAG = "required";
	public static final String OLD_VERSIONS_TAG = "old_version";
	public static final String OLD_VERSIONS_VER_TAG = "version";
	public static final String OLD_VERSIONS_NODE_TAG = "node";
	
	public static final ConfigTypeInt TYPE_INT_INSTANCE = new ConfigTypeInt();
	public static final ConfigTypeBoolean TYPE_BOOLEAN_INSTANCE = new ConfigTypeBoolean();
	public static final ConfigTypeString TYPE_STRING_INSTANCE = new ConfigTypeString();
	public static final ConfigTypeLong TYPE_LONG_INSTANCE = new ConfigTypeLong();
	public static final ConfigTypeStringList TYPE_STRING_LIST_INSTANCE = new ConfigTypeStringList();
	public static final ConfigTypeLanguage TYPE_LANGUAGE_INSTANCE = new ConfigTypeLanguage();
	
	public static void loadDefaultConfigTypes () {
		Log.logger.debug("Registering core config types");
		try {
			Configure.registerConfigType(TYPE_INT_INSTANCE);
//			Configure.registerConfigType(TYPE_INT_LIST_INSTANCE);
			Configure.registerConfigType(TYPE_LONG_INSTANCE);
//			Configure.registerConfigType(TYPE_LONE_LIST_INSTANCE);
//			Configure.registerConfigType(TYPE_SHORT_INSTANCE);
//			Configure.registerConfigType(TYPE_BYTE_INSTANCE);
//			Configure.registerConfigType(TYPE_CHAR_INSTANCE);
//			Configure.registerConfigType(TYPE_CHAR_LIST_INSTANCE);
			Configure.registerConfigType(TYPE_BOOLEAN_INSTANCE);
//			Configure.registerConfigType(TYPE_BOOLEAN_LIST_INSTANCE);
			Configure.registerConfigType(TYPE_STRING_INSTANCE);
			Configure.registerConfigType(TYPE_STRING_LIST_INSTANCE);
			Configure.registerConfigType(TYPE_LANGUAGE_INSTANCE);
		} catch (ConfigManageException.TypeConflictException e) {
			Log.logger.fatal("Config types in Core meets conflict!", e);
			iCee.exit(17);
		}
	}
	
}
