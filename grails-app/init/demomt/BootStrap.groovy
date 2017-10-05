package demomt

import org.grails.orm.hibernate.HibernateDatastore

@groovy.transform.CompileStatic
class BootStrap {
    HibernateDatastore hibernateDatastore
IdTenantResolver idTenantResolver
    def init = { servletContext ->
	String id = idTenantResolver.id
	createConnection(id)
	
    }
    
        def destroy = {
    }

    void createConnection(String id) {
	def config = [
	    'hibernate.hbm2ddl.auto': 'create-drop',
	    url: "jdbc:h2:mem:devDb${id};MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
	]
	hibernateDatastore.getConnectionSources().addConnectionSource(id, config as Map<String, Object>)
    }

}
