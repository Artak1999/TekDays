import com.tekdays.Sponsor
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tekDays_sponsor_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sponsor/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: sponsorInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("sponsor.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("name"),'required':(""),'value':(sponsorInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sponsorInstance, field: 'website', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("sponsor.website.label"),'default':("Website")],-1)
printHtmlPart(2)
invokeTag('field','g',19,['type':("url"),'name':("website"),'required':(""),'value':(sponsorInstance?.website)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sponsorInstance, field: 'description', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("sponsor.description.label"),'default':("Description")],-1)
printHtmlPart(6)
invokeTag('textArea','g',28,['name':("description"),'cols':("40"),'rows':("5"),'maxlength':("5000"),'value':(sponsorInstance?.description)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sponsorInstance, field: 'logo', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("sponsor.logo.label"),'default':("Logo")],-1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: sponsorInstance, field: 'sponsorsships', 'error'))
printHtmlPart(9)
invokeTag('message','g',43,['code':("sponsor.sponsorsships.label"),'default':("Sponsorsships")],-1)
printHtmlPart(10)
for( s in (sponsorInstance?.sponsorsships) ) {
printHtmlPart(11)
createTagBody(2, {->
expressionOut.print(s?.encodeAsHTML())
})
invokeTag('link','g',49,['controller':("sponsorship"),'action':("show"),'id':(s.id)],2)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'sponsorship.label', default: 'Sponsorship')]))
})
invokeTag('link','g',52,['controller':("sponsorship"),'action':("create"),'params':(['sponsor.id': sponsorInstance?.id])],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: sponsorInstance, field: 'events', 'error'))
printHtmlPart(15)
invokeTag('message','g',61,['code':("sponsor.events.label"),'default':("Events")],-1)
printHtmlPart(6)
invokeTag('select','g',64,['name':("events"),'from':(com.tekdays.TekEvent.list()),'multiple':("multiple"),'optionKey':("id"),'size':("5"),'value':(sponsorInstance?.events*.id),'class':("many-to-many")],-1)
printHtmlPart(16)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1710503866639L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
