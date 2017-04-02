package org.cw.midc.exception;

public class DicomFileDuplicatedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8886158562452752906L;
	
	
	public DicomFileDuplicatedException()
	{
		super("Dicom file duplicated.");
	}
	
}
