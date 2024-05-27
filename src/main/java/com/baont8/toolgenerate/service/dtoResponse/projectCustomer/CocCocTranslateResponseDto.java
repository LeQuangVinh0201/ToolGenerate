package com.baont8.toolgenerate.service.dtoResponse.projectCustomer;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CocCocTranslateResponseDto {

	@JsonProperty(value = "proxyapi")
	private List<Proxyapi> proxyApi = new ArrayList<>();

	@JsonProperty(value = "reqid")
	private String reqid;

	public static class Proxyapi {

		@JsonProperty(value = "translations")
		private List<Translations> translations = new ArrayList<>();

		public static class Translations {

			@JsonProperty(value = "num_used_tokens")
			private String numUsedTokens;

			@JsonProperty(value = "text")
			private String text;

			@JsonProperty(value = "to")
			private String to;

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}

			public String getTo() {
				return to;
			}

			public void setTo(String to) {
				this.to = to;
			}

			public String getNumUsedTokens() {
				return numUsedTokens;
			}

			public void setNumUsedTokens(String numUsedTokens) {
				this.numUsedTokens = numUsedTokens;
			}

		}

		public List<Translations> getTranslations() {
			return translations;
		}

		public void setTranslations(List<Translations> translations) {
			this.translations = translations;
		}
	}

	public List<Proxyapi> getProxyApi() {
		return proxyApi;
	}

	public void setProxyApi(List<Proxyapi> proxyApi) {
		this.proxyApi = proxyApi;
	}

	public String getReqid() {
		return reqid;
	}

	public void setReqid(String reqid) {
		this.reqid = reqid;
	}

}
