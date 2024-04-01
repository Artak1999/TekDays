import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tekDays_dashboard_event_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/_event.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(event)
printHtmlPart(1)
invokeTag('formatDate','g',7,['format':("MMM/dd/yyyy"),'date':(event.startDate)],-1)
printHtmlPart(2)
if(true && (event.endDate)) {
printHtmlPart(3)
invokeTag('formatDate','g',11,['format':("MMM/dd/yyyy"),'date':(event.endDate)],-1)
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(event.venue)
printHtmlPart(6)
expressionOut.print(event.respondents.size())
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1711365006293L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
