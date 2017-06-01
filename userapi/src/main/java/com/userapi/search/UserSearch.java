package com.userapi.search;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.userapi.entity.User;


@Repository
@Transactional
public class UserSearch {
    @Autowired
    private SessionFactory sessionFactory;

    public List<User> search(String text) {

        // get the full text entity manager

        Session session = this.sessionFactory.getCurrentSession();
        FullTextSession fullTextSession =
                org.hibernate.search.Search.getFullTextSession(session);

        // create the query using Hibernate Search query DSL
        QueryBuilder queryBuilder =
                fullTextSession.getSearchFactory()
                        .buildQueryBuilder().forEntity(User.class).get();

        // a very basic query by keywords
        org.apache.lucene.search.Query query =
                queryBuilder
                        .keyword()
                        .onFields("fname", "lname", "address", "contact")
                        .matching(text)
                        .createQuery();

        // wrap Lucene query in an Hibernate Query object
        org.hibernate.Query hibernateQuery =
                fullTextSession.createFullTextQuery(query, User.class);

        // execute search and return results (sorted by relevance as default)
        @SuppressWarnings("unchecked")
        List<User> results = hibernateQuery.list();   
        System.out.println("results is " +results.toString());
        return results;
    } // method search


} // class
