package com.common.api;

import javax.servlet.http.HttpServletRequest;

public interface IApiResponseProvider {

	public default boolean support(HttpServletRequest request) {
		return true;
	}

	public Class<? extends IApiResponse> apiResponseType();

}
