package com.miraglo.egas.rest.responsemodels;

public class TokenResponse {
private String challenge;
private String status;
private String response;
private float version_no;
public String getChallenge() {
	return challenge;
}
public void setChallenge(String challenge) {
	this.challenge = challenge;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getResponse() {
	return response;
}
public void setResponse(String response) {
	this.response = response;
}
public float getVersion_no() {
	return version_no;
}
public void setVersion_no(float version_no) {
	this.version_no = version_no;
}

}
