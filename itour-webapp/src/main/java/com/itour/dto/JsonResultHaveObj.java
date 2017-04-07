package com.itour.dto;


public class JsonResultHaveObj<T> extends JsonResult {
	
	protected T result;

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
	/**
	 * 返回成功的JsonResult
	 * @return 成功的JsonResult
	 */
	public static JsonResultHaveObj getSuccessInstance(){
		JsonResultHaveObj jsonResult=new JsonResultHaveObj();
		jsonResult.setErrorCode(0);
		return jsonResult;
	}
	
	/**
	 * 返回失败的JsonResult
	 * @param errorInfo 错误信息
	 * @return	失败的JsonResult
	 */
	public static JsonResultHaveObj getFailedInstance(String errorInfo){
		JsonResultHaveObj jsonResult=new JsonResultHaveObj();
		jsonResult.setErrorCode(-1);
		jsonResult.setErrorInfo(errorInfo);
		return jsonResult;
	}

}
