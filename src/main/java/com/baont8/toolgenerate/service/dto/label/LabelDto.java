package com.baont8.toolgenerate.service.dto.label;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("rawtypes")
public class LabelDto<T extends LabelDto> {

	@JsonProperty(value = "LABEL_ID")
	private Integer labelId;

	@JsonProperty(value = "SCREEN_ID")
	private Integer screenId;
	
	@JsonProperty(value = "MSG_GRP")
    private String msgGrp;

	@JsonProperty(value = "MSG_CD")
    private String msgCd;
	
	@JsonProperty(value = "LANG_CD")
    private String langCd;
	
	@JsonProperty(value = "COMP_CD")
    private String compCd;
	
	@JsonProperty(value = "MSG_TYPE")
    private String msgType;

	@JsonProperty(value = "SYS_CD")
    private String sysCd;
	
	@JsonProperty(value = "MSG")
    private String msg;
	
	@JsonProperty(value = "MSG_KOREA")
    private String msgKorea;
	
	@JsonProperty(value = "MSG_ENGLISH")
    private String msgEnglish;

	private List<T> labels;

	public List<T> getLabels() {
		return labels;
	}

	public void setLabels(List<T> labels) {
		this.labels = labels;
	}

	public Integer getLabelId() {
		return labelId;
	}

	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}

	public Integer getScreenId() {
		return screenId;
	}

	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
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

	public String getSysCd() {
		return sysCd;
	}

	public void setSysCd(String sysCd) {
		this.sysCd = sysCd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsgKorea() {
		return msgKorea;
	}

	public void setMsgKorea(String msgKorea) {
		this.msgKorea = msgKorea;
	}

	public String getMsgEnglish() {
		return msgEnglish;
	}

	public void setMsgEnglish(String msgEnglish) {
		this.msgEnglish = msgEnglish;
	}

}
