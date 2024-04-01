import com.tekdays.TekEvent
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tekDays_tekEventshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tekEvent/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'tekEvent.label', default: 'TekEvent'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',9,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',13,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(7)
invokeTag('message','g',19,['code':("default.home.label")],-1)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',20,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',20,['class':("list"),'action':("index")],2)
printHtmlPart(9)
createTagBody(2, {->
invokeTag('message','g',21,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',21,['class':("create"),'action':("create")],2)
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',22,['class':("list"),'controller':("dashboard"),'action':("dashboard"),'id':(tekEventInstance.id)],2)
printHtmlPart(9)
invokeTag('volunteerButton','g',22,['eventId':(tekEventInstance.id)],-1)
printHtmlPart(11)
expressionOut.print(tekEventInstance?.name)
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (tekEventInstance?.name)) {
printHtmlPart(16)
invokeTag('message','g',36,['code':("tekEvent.name.label"),'default':("Name")],-1)
printHtmlPart(17)
invokeTag('fieldValue','g',39,['bean':(tekEventInstance),'field':("name")],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (tekEventInstance?.city)) {
printHtmlPart(20)
invokeTag('fieldValue','g',50,['bean':(tekEventInstance),'field':("venue")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',51,['bean':(tekEventInstance),'field':("city")],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (tekEventInstance?.description)) {
printHtmlPart(22)
invokeTag('message','g',59,['code':("tekEvent.description.label"),'default':("Description")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',62,['bean':(tekEventInstance),'field':("description")],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (tekEventInstance?.organizer)) {
printHtmlPart(24)
invokeTag('message','g',70,['code':("tekEvent.organizer.label"),'default':("Organizer")],-1)
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(tekEventInstance?.organizer?.encodeAsHTML())
})
invokeTag('link','g',74,['controller':("tekUser"),'action':("show"),'id':(tekEventInstance?.organizer?.id)],3)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (tekEventInstance?.venue)) {
printHtmlPart(26)
invokeTag('message','g',81,['code':("tekEvent.venue.label"),'default':("Venue")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',84,['bean':(tekEventInstance),'field':("venue")],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (tekEventInstance?.startDate)) {
printHtmlPart(28)
invokeTag('message','g',92,['code':("tekEvent.startDate.label"),'default':("Start Date")],-1)
printHtmlPart(29)
invokeTag('formatDate','g',96,['format':("MMMM dd, yyyy"),'date':(tekEventInstance?.startDate)],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (tekEventInstance?.endDate)) {
printHtmlPart(30)
invokeTag('message','g',103,['code':("tekEvent.endDate.label"),'default':("End Date")],-1)
printHtmlPart(31)
invokeTag('formatDate','g',106,['format':("MMMM dd, yyyy"),'date':(tekEventInstance?.endDate)],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (tekEventInstance?.volunteers)) {
printHtmlPart(32)
invokeTag('message','g',114,['code':("tekEvent.volunteers.label"),'default':("Volunteers")],-1)
printHtmlPart(33)
for( v in (tekEventInstance.volunteers) ) {
printHtmlPart(34)
createTagBody(4, {->
expressionOut.print(v?.encodeAsHTML())
})
invokeTag('link','g',119,['controller':("tekUser"),'action':("show"),'id':(v.id)],4)
printHtmlPart(35)
}
printHtmlPart(36)
}
printHtmlPart(19)
if(true && (tekEventInstance?.sponsorships)) {
printHtmlPart(37)
invokeTag('message','g',127,['code':("tekEvent.sponsorships.label"),'default':("Sponsorships")],-1)
printHtmlPart(33)
for( s in (tekEventInstance.sponsorships) ) {
printHtmlPart(38)
createTagBody(4, {->
expressionOut.print(s?.sponsor.encodeAsHTML())
})
invokeTag('link','g',132,['controller':("sponsorship"),'action':("show"),'id':(s.id)],4)
printHtmlPart(35)
}
printHtmlPart(36)
}
printHtmlPart(19)
if(true && (tekEventInstance?.tasks)) {
printHtmlPart(39)
invokeTag('message','g',141,['code':("tekEvent.tasks.label"),'default':("Tasks")],-1)
printHtmlPart(33)
for( t in (tekEventInstance.tasks) ) {
printHtmlPart(40)
createTagBody(4, {->
expressionOut.print(t.title)
})
invokeTag('link','g',145,['controller':("task"),'action':("show"),'id':(t.id)],4)
printHtmlPart(35)
}
printHtmlPart(36)
}
printHtmlPart(19)
if(true && (tekEventInstance?.messages)) {
printHtmlPart(41)
invokeTag('message','g',154,['code':("tekEvent.messages.label"),'default':("Messages")],-1)
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',158,['controller':("tekMessage"),'action':("index"),'id':(tekEventInstance.id)],3)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (tekEventInstance?.respondents)) {
printHtmlPart(44)
invokeTag('message','g',167,['code':("tekEvent.respondents.label"),'default':("Respondents")],-1)
printHtmlPart(45)
invokeTag('fieldValue','g',170,['bean':(tekEventInstance),'field':("respondents")],-1)
printHtmlPart(18)
}
printHtmlPart(46)
createTagBody(2, {->
printHtmlPart(47)
createTagBody(3, {->
invokeTag('message','g',179,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',179,['class':("edit"),'action':("edit"),'resource':(tekEventInstance)],3)
printHtmlPart(48)
invokeTag('actionSubmit','g',183,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(49)
})
invokeTag('form','g',183,['url':([resource: tekEventInstance, action: 'delete']),'method':("DELETE")],2)
printHtmlPart(50)
expressionOut.print(g.createLink(action:'volunteer'))
printHtmlPart(51)
expressionOut.print(tekEventInstance.name)
printHtmlPart(52)
createTagBody(2, {->
printHtmlPart(53)
invokeTag('hiddenField','g',219,['name':("id"),'value':(tekEventInstance.id)],-1)
printHtmlPart(54)
})
invokeTag('form','g',220,['name':("volunteerForm"),'action':("volunteer")],2)
printHtmlPart(55)
})
invokeTag('captureBody','sitemesh',221,[:],1)
printHtmlPart(56)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1711612414858L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
