package com.miraglo.egas.services.impl;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.miraglo.egas.dao.SuggestionDAO;
import com.miraglo.egas.dm.Suggestion;
import com.miraglo.services.SuggestionService;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class SuggestionServiceImpl implements SuggestionService {

	@Autowired
	SuggestionDAO suggestiondao;
	@Override
	public Boolean AddSuggestion(Suggestion suggestion) {
	
		return suggestiondao.addSuggestion(suggestion);
	}
	@Override
	public String getReply(Long suggestionId) {
		
		return suggestiondao.getReply(suggestionId);
	}

	

}
