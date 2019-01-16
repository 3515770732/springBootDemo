package com.common.api;

import com.common.exception.BusinessException;

public interface IApiResponse {

    public void exception(BusinessException exception);

    public default  String dataField(){
        throw new RuntimeException("no set dataField");
    }

    public void setStatus(int status);

    public void setMsg(String msg);

}
