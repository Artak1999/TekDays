<%@ page import="com.tekdays.Sponsorship" %>



<div class="fieldcontain ${hasErrors(bean: sponsorshipInstance, field: 'event', 'error')} required">
	<label for="event">
		<g:message code="sponsorship.event.label" default="Event" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="event" name="event.id" from="${com.tekdays.TekEvent.list()}" optionKey="id" required="" value="${sponsorshipInstance?.event?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sponsorshipInstance, field: 'sponsor', 'error')} required">
	<label for="sponsor">
		<g:message code="sponsorship.sponsor.label" default="Sponsor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="sponsor" name="sponsor.id" from="${com.tekdays.Sponsor.list()}" optionKey="id" required="" value="${sponsorshipInstance?.sponsor?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sponsorshipInstance, field: 'contributionType', 'error')} required">
	<label for="contributionType">
		<g:message code="sponsorship.contributionType.label" default="Contribution Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="contributionType" from="${sponsorshipInstance.constraints.contributionType.inList}" required="" value="${sponsorshipInstance?.contributionType}" valueMessagePrefix="sponsorship.contributionType"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sponsorshipInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="sponsorship.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${sponsorshipInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sponsorshipInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="sponsorship.notes.label" default="Notes" />
		
	</label>
	<g:textArea name="notes" cols="40" rows="5" maxlength="5000" value="${sponsorshipInstance?.notes}"/>

</div>

