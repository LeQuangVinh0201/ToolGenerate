package com.baont8.toolgenerate.repository.toolGenerate.query;

public class FileTemplateParameterQuery {

	public static final String HARD_DELETE_BY_FILE_TEMPLATE_ID_AND_FILE_TEMPLATE_PARAM_ID = 
			    " DELETE F "
			  + " FROM FILE_TEMPLATE_PARAMETER F "
			  + " WHERE "
			  + " ( "
			  + "	:fileTemplateId IS NULL "
			  + "	OR "
			  + "	F.FILE_TEMPLATE_ID = :fileTemplateId "
			  + " )"
			  + " AND "
			  + " ( "
			  + "	:fileTemplateParameterId IS NULL "
			  + "	OR "
			  + "	F.FILE_TEMPLATE_PARAMETER_ID = :fileTemplateParameterId  "
			  + " ) ";
	
}
