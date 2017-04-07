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
	 * ���سɹ���JsonResult
	 * @return �ɹ���JsonResult
	 */
	public static JsonResult getSuccessInstance(){
		JsonResult jsonResult=new JsonResult();
		jsonResult.setErrorCode(0);
		return jsonResult;
	}
	
	/**
	 * ����ʧ�ܵ�JsonResult
	 * @param errorInfo ������Ϣ
	 * @return	ʧ�ܵ�JsonResult
	 */
	public static JsonResult getFailedInstance(String errorInfo){
		JsonResult jsonResult=new JsonResult();
		jsonResult.setErrorCode(-1);
		jsonResult.setErrorInfo(errorInfo);
		return jsonResult;
	}
	
}