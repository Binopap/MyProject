package com.miraglo.egas.dao;

import com.miraglo.egas.dm.Nonce;

public interface NonceDAO {
	public Nonce getByNonce(String nonce);

	public Nonce addNonce(Nonce nonce);
	
	public Nonce updateNonce(Nonce nonce);
}
