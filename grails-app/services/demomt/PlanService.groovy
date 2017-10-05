package demomt

import grails.gorm.transactions.Transactional
import grails.gorm.multitenancy.Tenants 
@groovy.transform.CompileStatic
@grails.gorm.multitenancy.CurrentTenant
@Transactional
class PlanService {

    def list() {
	Plan p1 = Plan.findAll()[0]
	Plan p2 = Plan.findAll({ id > 0 })[0]

	return [
	    'find': p1?.description,
	    'find with selection': p2?.description,
	]
    }

    void populate() {
	Tenants.withoutId {
	    new Plan(description: "Database = DEFAULT").save(failOnError: true)
	}
	String id = Tenants.currentId()
	new Plan(description: "Database = $id").save(failOnError: true)
    }
}
