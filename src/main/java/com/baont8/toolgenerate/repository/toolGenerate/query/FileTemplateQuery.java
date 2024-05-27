package com.baont8.toolgenerate.repository.toolGenerate.query;

public class FileTemplateQuery {

	public static final String LIST_FILE_TEMPLATE = 
				" SELECT f.* "
		      + " FROM FILE_TEMPLATE f "
			  + " WHERE 1 = 1 "
		      + "   AND f.STATUS = :status ";
}
