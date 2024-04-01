import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tekDays_dashboard_messages_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/_messages.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( msg in (messages) ) {
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
expressionOut.print(msg.author)
printHtmlPart(3)
})
invokeTag('link','g',15,['controller':("tekUser"),'action':("show"),'id':(msg.author.id)],2)
printHtmlPart(4)
expressionOut.print(msg.subject)
printHtmlPart(4)
expressionOut.print(msg.content[0..Math.min(msg.content.size() - 1, 24)])
printHtmlPart(3)
expressionOut.print(msg.content.size() > 25 ? '...' : '')
printHtmlPart(5)
}
printHtmlPart(6)
createClosureForHtmlPart(7, 1)
invokeTag('link','g',1,['controller':("tekMessage"),'action':("index"),'id':(event.id)],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1711365258373L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
