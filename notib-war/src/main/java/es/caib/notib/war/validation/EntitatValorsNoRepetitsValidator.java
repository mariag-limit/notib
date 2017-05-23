/**
 * 
 */
package es.caib.notib.war.validation;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import es.caib.notib.core.api.dto.EntitatDto;
import es.caib.notib.core.api.service.EntitatService;
import es.caib.notib.war.command.EntitatCommand;
import es.caib.notib.war.helper.MessageHelper;
import es.caib.notib.war.helper.MissatgesHelper;

/**
 * Constraint de validació que controla que no es repeteixi
 * el codi d'entitat.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class EntitatValorsNoRepetitsValidator implements ConstraintValidator<EntitatValorsNoRepetits, Object> {

	private HttpServletRequest request;

	@Autowired
	private EntitatService entitatService;



	@Override
	public void initialize(final EntitatValorsNoRepetits constraintAnnotation) {
		ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		request = attr.getRequest();
	}

	@Override
	public boolean isValid(
			final Object value, 
			final ConstraintValidatorContext context) {
		try {
			final EntitatCommand entitatCommand = (EntitatCommand)value;
			
			final Long id = entitatCommand.getId();
			final String codi = entitatCommand.getCodi();
			final String cif = entitatCommand.getCif();
			final String dir3 = entitatCommand.getDir3Codi();
			
			boolean valid = true;
			
			// Comprovar codi no repetit
			EntitatDto entitat = entitatService.findByCodi(codi);
			if (entitat != null) {
				if (id == null) {
					valid = false;
				} else {
					valid = id.equals(entitat.getId().toString());
				}
				if (!valid) {
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate(MessageHelper.getInstance().getMessage("entitat.validation.codi.repetit")).addNode("codi").addConstraintViolation();
				}
			}
			// Comprovar cif no repetit
			entitat = entitatService.findByCif(cif);
			if (entitat != null) {
				if (id == null) {
					valid = false;
				} else {
					valid = id.equals(entitat.getId().toString());
				}
				if (!valid) {
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate(MessageHelper.getInstance().getMessage("entitat.validation.cif.repetit")).addNode("cif").addConstraintViolation();
				}
			}
			// Comprovar cif no repetit
			entitat = entitatService.findByDir3(dir3);
			if (entitat != null) {
				if (id == null) {
					valid = false;
				} else {
					valid = id.equals(entitat.getId().toString());
				}
				if (!valid) {
					context.disableDefaultConstraintViolation();
					context.buildConstraintViolationWithTemplate(MessageHelper.getInstance().getMessage("entitat.validation.dir3.repetit")).addNode("dir3Codi").addConstraintViolation();
				}
			}
			
			return valid;
			
        } catch (final Exception ex) {
        	LOGGER.error("Error al validar si el codi d'entitat és únic", ex);
        	MissatgesHelper.error(request, "Error inesperat en la validació de les dades de l'entitat.");
        }
        return false;
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(EntitatValorsNoRepetitsValidator.class);

}
