package demomt
import grails.gorm.MultiTenant

@groovy.transform.CompileStatic
class Plan implements MultiTenant<Plan> {
    String description
}
