package cn.com.shxt.base.exception;

public class AppException extends RuntimeException {
	private static final long serialVersionUID = 8086290253750503667L;

	public AppException() {
		super();
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(Throwable cause) {
		super(cause);
	}
}
