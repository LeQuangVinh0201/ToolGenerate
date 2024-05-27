package com.baont8.toolgenerate.repository.toolGenerate.query;

public class FileTemplateDocumentStoragerQuery {

	public static final String HARD_DELETE_BY_FILE_TEMPLATE_ID_AND_DOCUMENT_STORAGE_ID = 
			    " DELETE F "
			  + " FROM FILE_TEMPLATE_DOCUMENT_STORAGE F "
			  + " WHERE "
			  + " ( "
			  + "	:fileTemplateId IS NULL "
			  + "	OR "
			  + "	F.FILE_TEMPLATE_ID = :fileTemplateId "
			  + " )"
			  + " AND "
			  + " ( "
			  + "	:documentStorageId IS NULL "
			  + "	OR "
			  + "	F.DOCUMENT_STORAGE_ID = :documentStorageId  "
			  + " ) ";
	
}
