import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tekDays_tekMessage_details_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tekMessage/_details.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (tekMessageInstance?.subject)) {
printHtmlPart(1)
invokeTag('message','g',6,['code':("tekMessage.subject.label"),'default':("Subject")],-1)
printHtmlPart(2)
invokeTag('fieldValue','g',8,['bean':(tekMessageInstance),'field':("subject")],-1)
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (tekMessageInstance?.content)) {
printHtmlPart(5)
invokeTag('message','g',14,['code':("tekMessage.content.label"),'default':("Content")],-1)
printHtmlPart(6)
invokeTag('fieldValue','g',16,['bean':(tekMessageInstance),'field':("content")],-1)
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (tekMessageInstance?.author)) {
printHtmlPart(7)
invokeTag('message','g',22,['code':("tekMessage.author.label"),'default':("Author")],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(tekMessageInstance?.author?.encodeAsHTML())
printHtmlPart(10)
})
invokeTag('link','g',27,['controller':("tekUser"),'action':("show"),'id':(tekMessageInstance?.author?.id)],2)
printHtmlPart(3)
}
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',34,['class':("create"),'action':("reply"),'resource':(tekMessageInstance)],2)
printHtmlPart(14)
})
invokeTag('form','g',36,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1710935926729L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
