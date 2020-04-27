package com.miraglo.services;

import com.miraglo.egas.dm.Nonce;

public interface NonceService {
	public Nonce getNonce(String nonce);
	public Nonce addNonce(Nonce nonce);
	// remove all nonce that are not logged for over 5 minutes;
	public Boolean removeAllStaleNonce();
	public Nonce updateNonce(Nonce nonce);
	
	public Boolean nonceCheck(String hotelName,String nonce,String imei);
}
