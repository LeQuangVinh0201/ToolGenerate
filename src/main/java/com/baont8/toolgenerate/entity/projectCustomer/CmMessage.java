package com.baont8.toolgenerate.entity.projectCustomer;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "CM_MESSAGE")
@IdClass(value = CmMessageId.class)
public class CmMessage {

	@Id
	@Column(name = "MSG_GRP")
	@JsonProperty(value = "MSG_GRP")
    private String msgGrp;

	@Id
	@Column(name = "MSG_CD")
	@JsonProperty(value = "MSG_CD")
    private String msgCd;
    
	@Id
	@Column(name = "LANG_CD")
	@JsonProperty(value = "LANG_CD")
    private String langCd;
    
	@Id
	@Column(name = "COMP_CD")
	@JsonProperty(value = "COMP_CD")
    private String compCd;

	@Column(name = "MSG_TYPE")
	@JsonProperty(value = "MSG_TYPE")
    private String msgType;
    
	@Column(name = "MSG")
	@JsonProperty(value = "MSG")
    private String msg;
    
	@Column(name = "SYS_CD")
	@JsonProperty(value = "SYS_CD")
    private String sysCd;
    
	@Column(name = "CAT_TYPE")
	@JsonProperty(value = "CAT_TYPE")
    private String catType;
    
	@Column(name = "USE_FLAG")
	@JsonProperty(value = "USE_FLAG")
    private String useFlag;
    
	@Column(name = "DATA_TYPE_CD")
	@JsonProperty(value = "DATA_TYPE_CD")
    private String dataTypeCd;
    
	@Column(name = "CRT_ID")
	@JsonProperty(value = "CRT_ID")
    private String crtId;
    
	@Column(name = "CRT_DT")
	@JsonProperty(value = "CRT_DT")
    private String crtDt;
    
	@Column(name = "UPDT_ID")
	@JsonProperty(value = "UPDT_ID")
    private String updtId;
    
	@Column(name = "UPDT_DT")
	@JsonProperty(value = "UPDT_DT")
    private String updtDt;

	@Column(name = "FAC_TYPE")
	@JsonProperty(value = "FAC_TYPE")
    private String facType;

	@Column(name = "ATTR1")
    private String attr1;
    
	@Column(name = "ATTR2")
	@JsonProperty(value = "ATTR2")
    private String attr2;
    
	@Column(name = "ATTR3")
	@JsonProperty(value = "ATTR3")
    private String attr3;
    
	@Column(name = "ATTR4")
	@JsonProperty(value = "ATTR4")
    private String attr4;
    
	@Column(name = "ATTR5")
	@JsonProperty(value = "ATTR5")
    private String attr5;
    
	@Column(name = "ATTR6")
	@JsonProperty(value = "ATTR6")
    private String attr6;
    
	@Column(name = "ATTR7")
	@JsonProperty(value = "ATTR7")
    private String attr7;
    
	@Column(name = "ATTR8")
	@JsonProperty(value = "ATTR8")
    private String attr8;
    
	@Column(name = "ATTR9")
	@JsonProperty(value = "ATTR9")
    private String attr9;
    
	@Column(name = "ATTR10")
	@JsonProperty(value = "ATTR10")
    private String attr10;

	public CmMessage() {
		super();
	}

	public CmMessage(String msgGrp) {
		super();
		this.msgGrp = msgGrp;
	}

	@Override
	public String toString() {
		return "MSG_GRP: " + this.msgGrp + ", MSG_CD: " + this.msgCd + ", LANG_CD: " + this.langCd 
				+ ", COMP_CD: " + this.compCd + ", MSG_TYPE: " + this.msgType + ", MSG: " + this.msg
				+ ", SYS_CD: " + this.sysCd;
	}

	public String getMsgGrp() {
		return msgGrp;
	}

	public void setMsgGrp(String msgGrp) {
		this.msgGrp = msgGrp;
	}

	public String getMsgCd() {
		return msgCd;
	}

	public void setMsgCd(String msgCd) {
		this.msgCd = msgCd;
	}

	public String getLangCd() {
		return langCd;
	}

	public void setLangCd(String langCd) {
		this.langCd = langCd;
	}

	public String getCompCd() {
		return compCd;
	}

	public void setCompCd(String compCd) {
		this.compCd = compCd;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSysCd() {
		return sysCd;
	}

	public void setSysCd(String sysCd) {
		this.sysCd = sysCd;
	}

	public String getCatType() {
		return catType;
	}

	public void setCatType(String catType) {
		this.catType = catType;
	}

	public String getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}

	public String getDataTypeCd() {
		return dataTypeCd;
	}

	public void setDataTypeCd(String dataTypeCd) {
		this.dataTypeCd = dataTypeCd;
	}

	public String getCrtId() {
		return crtId;
	}

	public void setCrtId(String crtId) {
		this.crtId = crtId;
	}

	public String getCrtDt() {
		return crtDt;
	}

	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}

	public String getUpdtId() {
		return updtId;
	}

	public void setUpdtId(String updtId) {
		this.updtId = updtId;
	}

	public String getUpdtDt() {
		return updtDt;
	}

	public void setUpdtDt(String updtDt) {
		this.updtDt = updtDt;
	}

	public String getFacType() {
		return facType;
	}

	public void setFacType(String facType) {
		this.facType = facType;
	}

	public String getAttr1() {
		return attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	public String getAttr3() {
		return attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	public String getAttr4() {
		return attr4;
	}

	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}

	public String getAttr5() {
		return attr5;
	}

	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}

	public String getAttr6() {
		return attr6;
	}

	public void setAttr6(String attr6) {
		this.attr6 = attr6;
	}

	public String getAttr7() {
		return attr7;
	}

	public void setAttr7(String attr7) {
		this.attr7 = attr7;
	}

	public String getAttr8() {
		return attr8;
	}

	public void setAttr8(String attr8) {
		this.attr8 = attr8;
	}

	public String getAttr9() {
		return attr9;
	}

	public void setAttr9(String attr9) {
		this.attr9 = attr9;
	}

	public String getAttr10() {
		return attr10;
	}

	public void setAttr10(String attr10) {
		this.attr10 = attr10;
	}

}
