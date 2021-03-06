package cc.sukazyo.icee.module.http;

import cc.sukazyo.icee.iCee;
import cc.sukazyo.icee.system.config.Configure;
import cc.sukazyo.icee.system.module.IModule;
import cc.sukazyo.icee.system.Log;
import cc.sukazyo.icee.util.Var;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpListener implements IModule {
	
	HttpServer server;
	
	public HttpListener() { }
	
	@Override
	public void initialize() {
		
		try {
			server = HttpServer.create(new InetSocketAddress(Configure.getInt(Configure.CORE_ID, "module.http.port")), 0);
//			server.createContext("/mtppp/", new HttpMtpppReq()); // 暂时无用
			if (Configure.getBoolean(Configure.CORE_ID, "module.http.apply")) {
				server.start();
				Log.logger.info("Start Http Server");
			} else {
				Log.logger.info("Http Server doesn't applied.");
			}
		} catch (IOException e) {
			Log.logger.fatal("Create Http Server Failed", e);
		}
	
	}
	
	@Override
	public String getRegistryName () {
		return "http";
	}
	
	@Override
	public String getVersion () {
		return iCee.VERSION;
	}
	
	@Override
	public String getDisplayVersion () {
		return Var.ICEE_VERSION_DISPLAY.value;
	}
	
}
