import com.tekdays.Sponsorship
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tekDays_sponsorship_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sponsorship/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: sponsorshipInstance, field: 'event', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("sponsorship.event.label"),'default':("Event")],-1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("event"),'name':("event.id"),'from':(com.tekdays.TekEvent.list()),'optionKey':("id"),'required':(""),'value':(sponsorshipInstance?.event?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sponsorshipInstance, field: 'sponsor', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("sponsorship.sponsor.label"),'default':("Sponsor")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['id':("sponsor"),'name':("sponsor.id"),'from':(com.tekdays.Sponsor.list()),'optionKey':("id"),'required':(""),'value':(sponsorshipInstance?.sponsor?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sponsorshipInstance, field: 'contributionType', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("sponsorship.contributionType.label"),'default':("Contribution Type")],-1)
printHtmlPart(2)
invokeTag('select','g',28,['name':("contributionType"),'from':(sponsorshipInstance.constraints.contributionType.inList),'required':(""),'value':(sponsorshipInstance?.contributionType),'valueMessagePrefix':("sponsorship.contributionType")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sponsorshipInstance, field: 'description', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("sponsorship.description.label"),'default':("Description")],-1)
printHtmlPart(2)
invokeTag('textField','g',37,['name':("description"),'required':(""),'value':(sponsorshipInstance?.description)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: sponsorshipInstance, field: 'notes', 'error'))
printHtmlPart(7)
invokeTag('message','g',43,['code':("sponsorship.notes.label"),'default':("Notes")],-1)
printHtmlPart(8)
invokeTag('textArea','g',46,['name':("notes"),'cols':("40"),'rows':("5"),'maxlength':("5000"),'value':(sponsorshipInstance?.notes)],-1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1710503813844L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
