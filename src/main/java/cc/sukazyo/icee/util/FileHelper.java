package cc.sukazyo.icee.util;

import cc.sukazyo.icee.iCee;
import cc.sukazyo.icee.system.Conf;
import cc.sukazyo.restools.ResourcesPackage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileHelper {
	
	public static final ResourcesPackage pack = new ResourcesPackage(iCee.class, "assets");
	
	/**
	 * 获取文件的不带后缀名的名称
	 *
	 * @param file 文件
	 * @return 无后缀文件名
	 */
	public static String getNamePured (File file) {
		return file.getName().substring(0, file.getName().lastIndexOf("."));
	}
	
	/**
	 * 获取资源文件文本内容
	 *
	 * @param path 资源文件的路径(以assets目录为根目录)
	 * @return 资源文本内容
	 * @throws IOException 文件读错误
	 */
	public static String getResourcesContent (String path) throws IOException {
		
		BufferedInputStream ins = new BufferedInputStream(Conf.class.getResourceAsStream(path));
		byte[] buffer = new byte[1024];
		int bytesRead;
		StringBuilder chunk = new StringBuilder();
		//从文件中按字节读取内容，到文件尾部时read方法将返回-1
		while ((bytesRead = ins.read(buffer)) != -1) {
			//将读取的字节转为字符串对象
			chunk.append(new String(buffer, 0, bytesRead));
		}
		
		return chunk.toString();
		
	}
	
	/**
	 * 获取数据中文本文件的内容
	 *
	 * @param path 数据路径（以data目录为根目录）
	 * @return 文本内容
	 * @throws IOException 读文件时发生错误
	 */
	public static String getDataContent (String path) throws IOException {
		Scanner in = new Scanner(new File("./data" + path).toPath(), StandardCharsets.UTF_8.name());
		String ret = in.useDelimiter("\\A").next();
		in.close();
		return ret;
	}
	
}