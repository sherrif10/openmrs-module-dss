<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ taglib prefix="springform" uri="resources/spring-form.tld"%>

<openmrs:require privilege="Manage Symptom" otherwise="/login.htm" redirect="/module/dss/symptom.form" />

<%@ include file="/WEB-INF/template/header.jsp"%>
<%@ include file="localHeader.jsp"%>

<h2><spring:message code="symptom.title" /></h2>

<div><b class="boxHeader"><spring:message code="symptom.title" /></b>
<div class="box">
    <springform:form modelAttribute="symptom">
        <br />
        <table>
            <tr>
                <td align="right"><spring:message code="dss.fever" />:</td>
                <td><springform:input path="fever" /><springform:errors path="Fever" cssClass="error" /></td>
            </tr>
            <tr>
                <td align="right"><spring:message code="dss.Nuesea" />:</td>
                <td><springform:input path="Nuesea" /><springform:errors path="Nuesea" cssClass="error" /></td>
            </tr>
            <tr>
                <td align="right"><spring:message code="dss.vomiting" />:</td>
                <td><springform:input path="vomiting" /><springform:errors path="vomiting" cssClass="error" /></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>
                    <input type="submit" value="<spring:message code='dss.symptom.saveOrUpdate'/>" />
	</springform:form>
                   
                </td>
		    </tr>
	    </table></div>
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>