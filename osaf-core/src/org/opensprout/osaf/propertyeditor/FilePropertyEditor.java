/**
 * Copyright (c) 2008 OpenSprout Team.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.opensprout.osaf.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.IOException;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.opensprout.osaf.exception.OSAFException;
import org.springframework.web.multipart.MultipartFile;

/**
 * This PropertyEditor maps MulipartFile to File,
 * @author Whiteship
 */
public class FilePropertyEditor extends PropertyEditorSupport {
   
	String uploadDirectory;
    
    protected final Log logger = LogFactory.getLog(getClass());
    
    public FilePropertyEditor(String excelFilePath) {
    	this.uploadDirectory = excelFilePath;
    }

    /** MultipartFile -> File(uploadFolder/filename) */
	public void setValue(Object value) {
		if (value instanceof MultipartFile) {
			MultipartFile multipartFile = (MultipartFile) value;
			
			// if there is no file
			if (multipartFile.isEmpty()) {
			    this.logger.debug("Filename: null");
			    super.setValue(null);
			    return;
			}
			
			String fileName = makeDuplicationSafeFileName(multipartFile.getOriginalFilename());
			this.logger.debug("Filename : " + fileName);			
			String path = uploadDirectory + "/" + fileName;
			
			// transfer file
			try {
			    multipartFile.transferTo(new File(path));
			}
			catch(IOException e) {
			    this.logger.debug("Multipart Error : " + e.getMessage());
			    throw new OSAFException("Check upload folder  : [" + uploadDirectory + "]." +
			    		"Nested exception is : " + e.getMessage());
			}
			super.setValue(path);
		}
		else {
		    super.setValue(null);
		}
    }
    
	private String makeDuplicationSafeFileName(String filename) {
		String originalFilename = filename;
		
		File f = new File(uploadDirectory + filename);		
		int duplicateIdx = 0;
		while (f.exists()) {
			int idx = originalFilename.indexOf(".");
			duplicateIdx++;
			filename = originalFilename.substring(0, idx) + "_" + duplicateIdx + originalFilename.substring(idx);
			f = new File(uploadDirectory + filename);			
		}
		return filename;
	}
}
