package com.myretail.exceptionhandling;

public class Error {

    private int status;
    private String message;
    private long timestamp;
    private String error;
    private String exception;
    private String path;

    public Error() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
    
    

}