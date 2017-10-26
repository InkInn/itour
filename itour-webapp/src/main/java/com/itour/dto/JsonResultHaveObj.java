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
	 * ���سɹ���JsonResult
	 * @return �ɹ���JsonResult
	 */
	public static JsonResultHaveObj getSuccessInstance(){
		JsonResultHaveObj jsonResult=new JsonResultHaveObj();
		jsonResult.setErrorCode(0);
		return jsonResult;
	}
	
	/**
	 * ����ʧ�ܵ�JsonResult
	 * @param errorInfo ������Ϣ
	 * @return	ʧ�ܵ�JsonResult
	 */
	public static JsonResultHaveObj getFailedInstance(String errorInfo){
		JsonResultHaveObj jsonResult=new JsonResultHaveObj();
		jsonResult.setErrorCode(-1);
		jsonResult.setErrorInfo(errorInfo);
		return jsonResult;
	}

}
