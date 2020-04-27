package com.miraglo.services;

import com.miraglo.egas.dm.Suggestion;

public interface SuggestionService {

	public Boolean AddSuggestion(Suggestion suggestion);
	public String getReply(Long suggestionId);
}
