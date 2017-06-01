package com.userapi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SessionFactorySearchIndex implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            Session session = this.sessionFactory.openSession();
            FullTextSession fullTextSession = Search.getFullTextSession(session);
            fullTextSession.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
