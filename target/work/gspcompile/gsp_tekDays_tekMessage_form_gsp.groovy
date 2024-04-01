import com.tekdays.TekMessage
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_tekDays_tekMessage_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tekMessage/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (tekMessageInstance?.parent)) {
printHtmlPart(1)
expressionOut.print(tekMessageInstance?.parent?.id)
printHtmlPart(2)
expressionOut.print(hasErrors(bean: tekMessageInstance, field: 'parent', 'error'))
printHtmlPart(3)
expressionOut.print(tekMessageInstance?.parent?.author)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: tekMessageInstance,
            field: 'parent', 'error'))
printHtmlPart(3)
expressionOut.print(tekMessageInstance?.parent?.author)
printHtmlPart(5)
}
printHtmlPart(6)
expressionOut.print(hasErrors(bean: tekMessageInstance,
        field: 'subject', 'error'))
printHtmlPart(7)
invokeTag('message','g',27,['code':("tekMessage.subject.label"),'default':("Subject")],-1)
printHtmlPart(8)
invokeTag('textField','g',31,['name':("subject"),'class':("messageField"),'required':(""),'value':(tekMessageInstance?.subject)],-1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: tekMessageInstance,
        field: 'content', 'error'))
printHtmlPart(10)
invokeTag('message','g',37,['code':("tekMessage.content.label"),'default':("Content")],-1)
printHtmlPart(8)
invokeTag('textArea','g',41,['name':("content"),'class':("messageField"),'cols':("40"),'rows':("5"),'maxlength':("2000"),'required':(""),'value':(tekMessageInstance?.content)],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: tekMessageInstance, field: 'author', 'error'))
printHtmlPart(12)
invokeTag('message','g',47,['code':("tekMessage.author.label"),'default':("Author")],-1)
printHtmlPart(8)
invokeTag('select','g',51,['id':("author"),'name':("author.id"),'from':(com.tekdays.TekUser.list()),'optionKey':("id"),'required':(""),'value':(tekMessageInstance?.author?.id),'class':("many-to-one")],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',55,['name':("event.id"),'value':(tekMessageInstance?.event?.id)],-1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1710938111842L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
