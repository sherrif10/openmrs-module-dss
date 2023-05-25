// package org.openmrs.module.dss.web.controller;

// import java.util.List;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpSession;
// import javax.validation.Valid;

// import org.openmrs.Cohort;
// import org.openmrs.Patient;
// import org.openmrs.api.context.Context;
// import org.openmrs.messagesource.MessageSourceService;
// import org.openmrs.module.dss.api.SymptomService;
// import org.openmrs.module.dss.api.model.Symptom;
// import org.openmrs.ui.framework.WebConstants;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.ModelMap;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.ServletRequestBindingException;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.SessionAttributes;
// import org.springframework.web.bind.support.SessionStatus;
// import org.springframework.web.servlet.ModelAndView;

// @Controller
// @RequestMapping("/module/dss/Symptom.form")
// @SessionAttributes("symptom")
// public class SymptomController {

// 	/**
// 	 * Generci Constructor
// 	 */
// 	public SymptomController() {

// 	}

// 	@RequestMapping(method = RequestMethod.POST)
// 	public String showSymptomForm(HttpServletRequest request, HttpSession httpSession, ModelMap model,
// 	        @RequestParam(required = false, value = "action") String action,
// 	        @ModelAttribute("symptom") @Valid Symptom symptom, BindingResult errors) throws ServletRequestBindingException {

// 		MessageSourceService mss = Context.getMessageSourceService();
// 		SymptomService service = Context.getService(SymptomService.class);
// 		symptom = service.getSymptomById(symptom.getId());
// 		Cohort allPatients = new Cohort();
// 		List<Patient> patients = Context.getPatientService().getAllPatients();
// 		for (Patient i : patients) {
// 			allPatients.addMember(i.getPatientId());
// 		}
// 		//add new model
// 		model = new ModelMap();
// 		model.addAttribute("Symptom", symptom);
// 		model.addAttribute("allPatients", allPatients);
// 		if (!Context.isAuthenticated()) {
// 			errors.reject("symptom.auth.required");
// 		} else if (mss.getMessage("symptom.purgeDepartment").equals(action)) {
// 			service.purgeSymptoms(symptom);
// 			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "symptom.delete.success");
// 			return "redirect:symptom.list";
// 		}
// 		return "redirect:symptomForm.form?symptomId=" + request.getParameter("symptomId");
// 	}

// 	/**
// 	 * Processes the form to
// 	 * 
// 	 * @param flag
// 	 * @param result
// 	 * @param status
// 	 * @return new ModelAndView
// 	 * @throws Exception
// 	 */
// 	@RequestMapping(method = RequestMethod.POST)
// 	public ModelAndView processSubmit(@ModelAttribute("symptom") Symptom symptom, BindingResult result, SessionStatus status)
// 	        throws Exception {

// 		// add the new tag
// 		Context.getService(SymptomService.class).saveOrUpdate(symptom);

// 		// clears the command object from the session
// 		status.setComplete();

// 		// just display the edit page again
// 		return new ModelAndView("redirect:/module/dss/symptom");
// 	}

// }
