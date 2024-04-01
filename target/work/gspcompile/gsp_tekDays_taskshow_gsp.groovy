import com.tekdays.Task
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tekDays_taskshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/task/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'task.label', default: 'Task'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (taskInstance?.title)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("task.title.label"),'default':("Title")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(taskInstance),'field':("title")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (taskInstance?.notes)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("task.notes.label"),'default':("Notes")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',39,['bean':(taskInstance),'field':("notes")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (taskInstance?.assignedTo)) {
printHtmlPart(20)
invokeTag('message','g',46,['code':("task.assignedTo.label"),'default':("Assigned To")],-1)
printHtmlPart(21)
createTagBody(3, {->
expressionOut.print(taskInstance?.assignedTo?.encodeAsHTML())
})
invokeTag('link','g',48,['controller':("tekUser"),'action':("show"),'id':(taskInstance?.assignedTo?.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (taskInstance?.dueDate)) {
printHtmlPart(22)
invokeTag('message','g',55,['code':("task.dueDate.label"),'default':("Due Date")],-1)
printHtmlPart(23)
invokeTag('formatDate','g',57,['date':(taskInstance?.dueDate)],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (taskInstance?.event)) {
printHtmlPart(24)
invokeTag('message','g',64,['code':("task.event.label"),'default':("Event")],-1)
printHtmlPart(25)
createTagBody(3, {->
expressionOut.print(taskInstance?.event?.encodeAsHTML())
})
invokeTag('link','g',66,['controller':("tekEvent"),'action':("show"),'id':(taskInstance?.event?.id)],3)
printHtmlPart(16)
}
printHtmlPart(26)
if(true && (taskInstance?.completed)) {
printHtmlPart(27)
invokeTag('message','g',74,['code':("task.completed.label"),'default':("Completed")],-1)
printHtmlPart(28)
invokeTag('formatBoolean','g',77,['boolean':(taskInstance?.completed),'true':("Yes"),'false':("No")],-1)
printHtmlPart(29)
}
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
createTagBody(3, {->
invokeTag('message','g',83,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',83,['class':("edit"),'action':("edit"),'resource':(taskInstance)],3)
printHtmlPart(32)
invokeTag('actionSubmit','g',84,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(33)
})
invokeTag('form','g',86,['url':([resource:taskInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',88,[:],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1710843370177L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
