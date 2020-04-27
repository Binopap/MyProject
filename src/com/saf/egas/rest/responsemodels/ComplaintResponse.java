package com.miraglo.egas.rest.responsemodels;

public class ComplaintResponse {
private long complaint_id;
private boolean status;
public boolean isStatus() {
	return status;
}
public void setStatus(boolean status) {
	this.status = status;
}
public long getComplaint_id() {
	return complaint_id;
}
public void setComplaint_id(long complaint_id) {
	this.complaint_id = complaint_id;
}

}
