<%@ page import="com.tekdays.Sponsor" %>



<div class="fieldcontain ${hasErrors(bean: sponsorInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="sponsor.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${sponsorInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sponsorInstance, field: 'website', 'error')} required">
	<label for="website">
		<g:message code="sponsor.website.label" default="Website" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="url" name="website" required="" value="${sponsorInstance?.website}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sponsorInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="sponsor.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="5000" value="${sponsorInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sponsorInstance, field: 'logo', 'error')} ">
	<label for="logo">
		<g:message code="sponsor.logo.label" default="Logo" />
		
	</label>
	<input type="file" id="logo" name="logo" />

</div>

<div class="fieldcontain ${hasErrors(bean: sponsorInstance, field: 'sponsorsships', 'error')} ">
	<label for="sponsorsships">
		<g:message code="sponsor.sponsorsships.label" default="Sponsorsships" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${sponsorInstance?.sponsorsships?}" var="s">
    <li><g:link controller="sponsorship" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="sponsorship" action="create" params="['sponsor.id': sponsorInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'sponsorship.label', default: 'Sponsorship')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: sponsorInstance, field: 'events', 'error')} ">
	<label for="events">
		<g:message code="sponsor.events.label" default="Events" />
		
	</label>
	<g:select name="events" from="${com.tekdays.TekEvent.list()}" multiple="multiple" optionKey="id" size="5" value="${sponsorInstance?.events*.id}" class="many-to-many"/>

</div>

