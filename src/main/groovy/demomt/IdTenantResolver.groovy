package demomt

import groovy.transform.CompileStatic
import org.grails.datastore.mapping.multitenancy.TenantResolver
import org.grails.datastore.mapping.multitenancy.exceptions.TenantNotFoundException

@CompileStatic
class IdTenantResolver implements TenantResolver {

    final Serializable id = 'fixed-id'
    @Override
    Serializable resolveTenantIdentifier() throws TenantNotFoundException {
	return id
    }
    
}
