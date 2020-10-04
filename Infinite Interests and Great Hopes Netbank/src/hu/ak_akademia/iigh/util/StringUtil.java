package hu.ak_akademia.iigh.util;

public final class StringUtil {

	private StringUtil() {
	}

	public static boolean isBlank(String text) {
		return text == null || text.isBlank();
	}

}