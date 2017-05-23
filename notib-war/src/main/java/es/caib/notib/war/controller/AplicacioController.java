/**
 * 
 */
package es.caib.notib.war.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.caib.notib.core.api.dto.AplicacioDto;
import es.caib.notib.core.api.dto.PaginaDto;
import es.caib.notib.core.api.service.UsuariAplicacioService;
import es.caib.notib.war.command.AplicacioCommand;
import es.caib.notib.war.helper.DatatablesHelper;
import es.caib.notib.war.helper.DatatablesHelper.DatatablesResponse;
import es.caib.notib.war.helper.SessioHelper;

/**
 * Controlador per al manteniment d'entitats.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
@Controller
@RequestMapping("/aplicacions")
public class AplicacioController extends BaseController {
	
	@Autowired
	private UsuariAplicacioService usuariAplicacioService;
	

	@RequestMapping(value="", method = RequestMethod.GET)
	public String get(
			HttpServletRequest request,
			Model model) {
		
		SessioHelper.setEnEntitat( request );
		
		return "aplicacioList";
		
	}
	
	@RequestMapping(value = "/datatable", method = RequestMethod.GET)
	@ResponseBody
	public DatatablesResponse datatable(
			HttpServletRequest request) {
		
		PaginaDto<AplicacioDto> aplicacions = usuariAplicacioService.findPaginat(
										DatatablesHelper.getPaginacioDtoFromRequest(request)
										);
		
		return DatatablesHelper.getDatatableResponse(request, aplicacions);
		
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String create(
			HttpServletRequest request,
			Model model) {
		
		model.addAttribute(new AplicacioCommand());
		
		return "aplicacioForm";
	}
	
	@RequestMapping(value = "/{aplicacioId}", method = RequestMethod.GET)
	public String update(
			HttpServletRequest request,
			Model model,
			@PathVariable Long aplicacioId) {
		
		AplicacioCommand command = AplicacioCommand.asCommand(
				usuariAplicacioService.findById(aplicacioId)
				);
		
		model.addAttribute(command);
		
		return "aplicacioForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(
			HttpServletRequest request,
			Model model,
			@Valid AplicacioCommand command,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) return "aplicacioForm";
		
		if (command.getId() == null) {
			usuariAplicacioService.create(
					AplicacioCommand.asDto(command)
					);
			return getModalControllerReturnValueSuccess(
					request,
					"redirect:aplicacions",
					"aplicacio.controller.creada.ok");
			
		} else {
			usuariAplicacioService.update(
					AplicacioCommand.asDto(command)
					);
			return getModalControllerReturnValueSuccess(
					request,
					"redirect:aplicacions",
					"aplicacio.controller.modificada.ok");
			
		}
	}
	
	@RequestMapping(value = "/{aplicacioId}/delete", method = RequestMethod.GET)
	public String delete(
			HttpServletRequest request,
			Model model,
			@PathVariable Long aplicacioId) {
		
		usuariAplicacioService.delete(aplicacioId);
		
		return getAjaxControllerReturnValueSuccess(
				request,
				"redirect:aplicacions",
				"aplicacio.controller.esborrada.ok");
		
	}
	
	
}
