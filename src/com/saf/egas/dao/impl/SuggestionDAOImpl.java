package com.miraglo.egas.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miraglo.egas.dao.SuggestionDAO;
import com.miraglo.egas.dm.Bar;
import com.miraglo.egas.dm.Suggestion;

@Repository
public class SuggestionDAOImpl implements SuggestionDAO{

	@Autowired
	SessionFactory fact;
	
	@Override
	public Boolean addSuggestion(Suggestion suggestion) {
		Session se = fact.getCurrentSession();
		se.save(suggestion);
		return true;
	}

	@Override
	public String getReply(Long suggestionid) {
		Session session = fact.getCurrentSession();
		Query query = session.createQuery("from Suggestion where suggestionId=:suggestionid");
		query.setLong("suggestionid", suggestionid);
		List<Suggestion> ingr=query.list();
		if(ingr.size()>0){
			return ingr.get(0).getReply();
		}else{
			return "";
			
		}
	}


}
