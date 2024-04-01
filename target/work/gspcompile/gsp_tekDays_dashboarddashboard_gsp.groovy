import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tekDays_dashboarddashboard_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/dashboard.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',16,['class':("create"),'controller':("task"),'action':("create")],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',21,['class':("create"),'controller':("sponsorship"),'action':("create")],2)
printHtmlPart(8)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',26,['class':("list"),'controller':("sponsor"),'action':("index")],2)
printHtmlPart(11)
invokeTag('render','g',32,['template':("event"),'model':(['event': event])],-1)
printHtmlPart(12)
invokeTag('render','g',36,['template':("tasks"),'model':(['tasks': tasks])],-1)
printHtmlPart(13)
invokeTag('render','g',40,['template':("volunteers"),'model':(['volunteers': volunteers])],-1)
printHtmlPart(14)
invokeTag('render','g',44,['template':("messages"),'model':([messages: messages])],-1)
printHtmlPart(15)
invokeTag('render','g',48,['template':("sponsors"),'model':([sponsorships: sponsorships])],-1)
printHtmlPart(16)
invokeTag('render','g',52,['template':("twitter"),'model':([event:event])],-1)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',54,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1711539173604L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
