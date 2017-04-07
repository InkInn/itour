package com.itour.dto;



public class JsonResult {

	
	protected int errorCode;
	

	protected String errorInfo;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	/**
	 * 返回成功的JsonResult
	 * @return 成功的JsonResult
	 */
	public static JsonResult getSuccessInstance(){
		JsonResult jsonResult=new JsonResult();
		jsonResult.setErrorCode(0);
		return jsonResult;
	}
	
	/**
	 * 返回失败的JsonResult
	 * @param errorInfo 错误信息
	 * @return	失败的JsonResult
	 */
	public static JsonResult getFailedInstance(String errorInfo){
		JsonResult jsonResult=new JsonResult();
		jsonResult.setErrorCode(-1);
		jsonResult.setErrorInfo(errorInfo);
		return jsonResult;
	}
	
}