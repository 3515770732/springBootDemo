package com.common.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.common.exception.BusincessExceptionCode;
import com.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.common.collect.Lists;

@RestControllerAdvice
public class ApiExceptionsHandler implements ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(ApiExceptionsHandler.class);

    @Autowired
    private HttpServletRequest request;

    private List<IApiResponseProvider> apiResponseProviders;

    /**
     * 拦截所有Exception
     *
     * @param Exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public IApiResponse ExceptionsHandler(Exception e) {
        BusinessException exception = null;
        if (e instanceof BusinessException) { /* ApiException特别处理 */
            exception = (BusinessException) e;
            LOG.error("业务异常：URL：{}，status：{}，msg：{}", request.getRequestURI(), //
                    exception.getStatus(), exception.getMessage());
        } else {
            exception = new BusinessException(BusincessExceptionCode.EXP_XT, "系统异常，请联系管理员", e);
            StringBuilder buf = new StringBuilder();
            buf.append("程序异常,URL:").append(request.getRequestURL());
            String queryString = request.getQueryString();
            if (StringUtils.isNotBlank(queryString)) {
                buf.append("?").append(queryString);
            }
            LOG.error(buf.toString(), e);
        }
        return apiResponse(exception);
    }

    private IApiResponse apiResponse(BusinessException apiException) {
        IApiResponse apiResponse = providerApiResponse(apiException);
        return Optional.ofNullable(apiResponse).orElse(defaultExceptionResponse(apiException));
    }

    private IApiResponse providerApiResponse(BusinessException apiException) {
        return Optional.ofNullable(apiResponseProviders).map(list -> {
            for (IApiResponseProvider provider : apiResponseProviders) {
                if (provider.support(request)) {
                    try {
                        IApiResponse apiResponse = provider.apiResponseType()//
                                .getConstructor().newInstance();
                        apiResponse.exception(apiException);
                        return apiResponse;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return null;
        }).orElse(null);
    }

    private IApiResponse defaultExceptionResponse(BusinessException exception) {
        ApiResponse<Object> resp = new ApiResponse<>();
        resp.exception(exception);
        return resp;
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        Map<String, IApiResponseProvider> beansMap = ctx.getBeansOfType(IApiResponseProvider.class);
        ArrayList<IApiResponseProvider> apiResponseProviders = Optional.ofNullable(beansMap)
                .map(m -> Lists.newArrayList(m.values())).orElse(null);
        setApiResponseProviders(apiResponseProviders);
    }

    public void setApiResponseProviders(List<IApiResponseProvider> apiResponseProviders) {
        this.apiResponseProviders = apiResponseProviders;
    }

}
