package mt

import grails.gorm.transactions.Transactional
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.multitenancy.Tenants 

import grails.gorm.services.Join
import grails.gorm.services.Service
import groovy.transform.CompileStatic

@Transactional
@CurrentTenant
class T1Service {

    def list() {
def l = Tenants.withId('lama2') {
Plan.findAll({ id > 0 })
}
return l
    }
}
