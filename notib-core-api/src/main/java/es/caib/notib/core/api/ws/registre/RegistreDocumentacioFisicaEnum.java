package es.caib.notib.core.api.ws.registre;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Enumeració amb els possibles valors del tipus de document del registre.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public enum RegistreDocumentacioFisicaEnum {

	ACOMPANYA_DOCUMENTACIO_FISICA_REQUERIDA("01"),
	ACOMPANYA_DOCUMENTACIO_FISICA_COMPLEMENTARIA("02"),
	NO_ACOMPANYA_DOCUMENTACIO("03");

	private final String valor;
	private RegistreDocumentacioFisicaEnum(String valor) {
		this.valor = valor;
	}
	public String getValor() {
		return valor;
	}
	private static final Map<String, RegistreDocumentacioFisicaEnum> lookup;
	static {
		lookup = new HashMap<String, RegistreDocumentacioFisicaEnum>();
		for (RegistreDocumentacioFisicaEnum s: EnumSet.allOf(RegistreDocumentacioFisicaEnum.class))
			lookup.put(s.getValor(), s);
	}
	public static RegistreDocumentacioFisicaEnum valorAsEnum(String valor) {
		if (valor == null)
			return null;
        return lookup.get(valor); 
    }

}
