import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tekDays_dashboard_volunteers_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/_volunteers.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( volunteer in (volunteers) ) {
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
expressionOut.print(volunteer.fullName)
printHtmlPart(3)
})
invokeTag('link','g',15,['controller':("tekUser"),'action':("show"),'id':(volunteer.id)],2)
printHtmlPart(4)
expressionOut.print(volunteer.email)
printHtmlPart(5)
expressionOut.print(volunteer.email)
printHtmlPart(6)
expressionOut.print(volunteer.website)
printHtmlPart(5)
expressionOut.print(volunteer.website)
printHtmlPart(7)
}
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1711365165677L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
