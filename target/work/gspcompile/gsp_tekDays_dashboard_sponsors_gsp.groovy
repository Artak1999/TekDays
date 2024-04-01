import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tekDays_dashboard_sponsors_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/_sponsors.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( s in (sponsorships) ) {
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
expressionOut.print(s.sponsor.name)
printHtmlPart(3)
})
invokeTag('link','g',15,['controller':("sponsor"),'action':("show"),'id':(s.sponsor.id)],2)
printHtmlPart(4)
expressionOut.print(s.sponsor.website)
printHtmlPart(5)
expressionOut.print(s.sponsor.website)
printHtmlPart(6)
expressionOut.print(s.contributionType)
printHtmlPart(7)
}
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1711365457973L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
