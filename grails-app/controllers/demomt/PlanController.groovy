package demomt

import grails.rest.*
import grails.converters.*
@groovy.transform.CompileStatic
class PlanController {
    static responseFormats = ['json', 'xml']
    PlanService planService
    boolean first = true
    def index() {
	if (first) {
	    first = false
	    planService.populate()
	}
	respond planService.list()
    }

}
