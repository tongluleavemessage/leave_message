package com.tonglukuaijian.commerce.out;

public class OutMessage<T> {
	public static final Integer DEFAULT_CODE = 200;
	public static final Integer ERROR_CODE = 400;
	private Integer code = DEFAULT_CODE;
	private String message = "ok";
	private T data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public OutMessage(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public OutMessage(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public OutMessage(T data) {
		this.data = data;
	}

	public OutMessage() {
		super();
	}

	public static <S> OutMessage<S> successMessage() {
		return new OutMessage<S>(DEFAULT_CODE, "ok");
	}

	public static <S> OutMessage<S> successMessage(Integer code, String message) {
		return new OutMessage<S>(code, message);
	}

	public static <S> OutMessage<S> successMessage(S data) {
		return new OutMessage<S>(data);
	}

	public static <E> OutMessage<E> errorMessage(String message) {
		return new OutMessage<E>(ERROR_CODE, message);
	}

	public static <E> OutMessage<E> errorMessage(Integer code, String message) {
		return new OutMessage<E>(code, message);
	}

	public static <E> OutMessage<E> errorMessage(Integer code, String message, E data) {
		return new OutMessage<E>(code, message, data);
	}

}
