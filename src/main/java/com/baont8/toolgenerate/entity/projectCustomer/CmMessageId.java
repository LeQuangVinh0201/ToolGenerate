package com.baont8.toolgenerate.entity.projectCustomer;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CmMessageId implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "MSG_GRP")
    private String msgGrp;

	@JsonProperty(value = "MSG_CD")
    private String msgCd;
    
	@JsonProperty(value = "LANG_CD")
    private String langCd;
    
	@JsonProperty(value = "COMP_CD")
    private String compCd;

}
