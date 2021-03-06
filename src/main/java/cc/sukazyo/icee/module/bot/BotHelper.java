package cc.sukazyo.icee.module.bot;

import cc.sukazyo.icee.system.config.Configure;
import cc.sukazyo.icee.util.SimpleUtils;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BotHelper {
	
	/**
	 * 检查 Bot 是否被呼叫
	 *
	 * @param messsage Bot 接收的消息
	 * @return 如果被呼叫，则此为呼叫的内容，如果未被呼叫，则为 null
	 */
	public static String isBotCalled (CommonBotMessage messsage) {
		
		String raw = messsage.getMessageRaw();
		String text = messsage.getMessageText();
		
		for (String focus : Objects.requireNonNull(Configure.getStringList(
				Configure.CORE_BOT_ID,
				"module.bot.call.raw"
		))) {
			
			Matcher mat = Pattern.compile("^\\s*" + SimpleUtils.escapeExprSpecialWord(focus) +"\\s*([\\s\\S]*)$").matcher(raw);
			
			if (mat.find()) {
				return mat.group(1);
			}
			
		}
		
		for (String focus : Configure.getStringList(Configure.CORE_BOT_ID, "module.bot.call.text")) {
			
			Matcher mat = Pattern.compile("^\\s*" + SimpleUtils.escapeExprSpecialWord(focus) +"\\s*([\\s\\S]*)$").matcher(text);
			
			if (mat.find()) {
				return mat.group(1);
			}
			
		}
		
		return null;
	}
	
}
