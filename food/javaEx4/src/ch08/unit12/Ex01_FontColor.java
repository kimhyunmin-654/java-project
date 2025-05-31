package ch08.unit12;

public class Ex01_FontColor {

	public static void main(String[] args) {
		// 콘솔 화면 글자색 변경
		
		System.out.println(FontColor.RED + "Hello..." + FontColor.RESET);
		System.out.println(FontColor.GREEN + "Hello..." + FontColor.RESET);
	}
}

class FontColor {
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CTAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	public static final String RESET = "\u001B[0m";
}
