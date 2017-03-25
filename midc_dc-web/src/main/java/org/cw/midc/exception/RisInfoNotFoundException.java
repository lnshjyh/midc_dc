package org.cw.midc.exception;

public class RisInfoNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3586470048439973866L;
	
	public RisInfoNotFoundException()
	{
		super("No Ris Infomation found");
	}
	
	public RisInfoNotFoundException(String studyInfoId)
	{
		super("No Ris Infomation found" + studyInfoId);
	}

}
