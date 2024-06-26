import com.tekdays.Task
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tekDays_task_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/task/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: taskInstance, field: 'title', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("task.title.label"),'default':("Title")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("title"),'required':(""),'value':(taskInstance?.title)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: taskInstance, field: 'notes', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("task.notes.label"),'default':("Notes")],-1)
printHtmlPart(5)
invokeTag('textArea','g',19,['name':("notes"),'cols':("40"),'rows':("5"),'maxlength':("5000"),'value':(taskInstance?.notes)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: taskInstance, field: 'assignedTo', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("task.assignedTo.label"),'default':("Assigned To")],-1)
printHtmlPart(5)
invokeTag('select','g',28,['id':("assignedTo"),'name':("assignedTo.id"),'from':(com.tekdays.TekUser.list()),'optionKey':("id"),'value':(taskInstance?.assignedTo?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: taskInstance, field: 'dueDate', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("task.dueDate.label"),'default':("Due Date")],-1)
printHtmlPart(5)
invokeTag('datePicker','g',37,['name':("dueDate"),'precision':("day"),'value':(taskInstance?.dueDate),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: taskInstance, field: 'event', 'error'))
printHtmlPart(8)
invokeTag('message','g',43,['code':("task.event.label"),'default':("Event")],-1)
printHtmlPart(2)
invokeTag('select','g',46,['id':("event"),'name':("event.id"),'from':(com.tekdays.TekEvent.list()),'optionKey':("id"),'required':(""),'value':(taskInstance?.event?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: taskInstance, field: 'completed', 'error'))
printHtmlPart(9)
invokeTag('message','g',52,['code':("task.completed.label"),'default':("Completed")],-1)
printHtmlPart(10)
invokeTag('checkBox','g',54,['name':("completed"),'value':(taskInstance?.completed)],-1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1710843704844L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
