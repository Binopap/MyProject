package com.miraglo.egas.dao;

import com.miraglo.egas.dm.Suggestion;

public interface SuggestionDAO {

	public Boolean addSuggestion(Suggestion suggestion);
	public String getReply(Long suggestionId);
}
