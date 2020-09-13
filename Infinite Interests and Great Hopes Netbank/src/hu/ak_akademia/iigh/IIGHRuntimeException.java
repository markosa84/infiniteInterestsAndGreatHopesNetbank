package hu.ak_akademia.iigh;

public class IIGHRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IIGHRuntimeException() {
	}

	public IIGHRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IIGHRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public IIGHRuntimeException(String message) {
		super(message);
	}

	public IIGHRuntimeException(Throwable cause) {
		super(cause);
	}

}
