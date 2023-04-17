<body data-spy="scroll" data-target="#menu">

     <ui-view class="ng-scope">
           <h1>Decision Support System Based on COAST</h1><br/>
   
           <c:url var="action value="/create"></c:url>
           <form:form method="POST" action="&{action}" moduleAttribute="symptom">
              <table>
                 <tr>
                    <td><form:label path="fever">Fever</form:label></td>
                    <td><form:input path="fever" /></td>
                 </tr>
                 <tr>
                    <td><form:label path="occupation">Occupation</form:label></td>
                    <td><form:input path="occupation" /></td>
                 </tr>
                    <tr>
                    <td colspan="2"><input type="submit" value="Predict" /></td>
                   </tr>
               </table>
               </form:form>
       </ui-view>
   </body>