<% ui.decorateWith("appui", "standardEmrPage") %>
 
    <script type="text/javascript">
    var breadcrumbs = [
        { icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
    ];
</script>
  <body data-spy="scroll" data-target="#menu">
 
  <ui-view class="ng-scope">
        <h1>Decision Support System Based on COAST</h1><br/>
 
        <form id="symptom">
           <table>
              <tr>
                 <td valign="top">
                 <input id="symptom" type="checkbox">fever</td>
              </tr>
              <tr>
                 <td valign="top">
                 <input id="symptom" type="checkbox">occupation</td>
              </tr>
               <tr>
                 <td valign="top">
                 <input id="symptom" type="checkbox">nuesea</td>
              </tr>
               <tr>
                 <td valign="top">
                 <input id="symptom" type="checkbox">soreThroat</td>
              </tr>
               <tr>
                 <td valign="top">
                 <input id="symptom" type="checkbox">muscleAches</td>
              </tr>
                   <tr>
                 <td valign="top">
                 <input id="symptom" type="checkbox">lossOfSmell</td>
              </tr>
                   <tr>
                 <td valign="top">
                 <input id="symptom" type="checkbox">lossOfTaste</td>
              </tr>
                   <tr>
                 <td valign="top">
                 <input id="symptom" type="checkbox">shortnessOfBreath</td>
              </tr>
                   <tr>
                 <td valign="top">
                 <input id="symptom" type="checkbox">jointAches</td>
              </tr>
                   <tr>
                 <td valign="top">
                 <input id="symptom" type="checkbox">runnyNose</td>
              </tr>
                   <tr>
                 <td valign="top">
                 <input id="symptom" type="checkbox">vomiting</td>
              </tr>
                   <tr>
                 <td valign="top">
                 <input id="symptom" type="checkbox">relationshipWithContactPerson</td>
              </tr> 
               <tr>
               <td>
            <input type="submit"  name="Predict" value=saveOrUpdate/>

	</springform:form>
                    <a href="/coreapps/clinicianfacing/patient.page?patientId=c61195ff-0e93-4799-bd49-3c1738d9c34f">
                        <input type="button" name="Predict" value=saveOrUpdate/>
                    </a>
                </td>
                </tr>
            </table>
            </form:form>
    </ui-view>
</body>