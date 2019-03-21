/**
 * 
 */
package es.caib.notib.war.command;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;
import es.caib.notib.core.api.dto.DocumentDto;
import es.caib.notib.war.helper.ConversioTipusHelper;

/**
 * Command per al manteniment de documents.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class DocumentCommand {

	private String arxiuNom;
	private byte[] contingutBase64;
	private String hash;
	private String url;
	private List<String> metadades = new ArrayList<String>();
	private boolean normalitzat;
	private boolean generarCsv;
	private String csv;
	private String uuid;
	
	public String getArxiuNom() {
		return arxiuNom;
	}
	public void setArxiuNom(String arxiuNom) {
		this.arxiuNom = arxiuNom;
	}
	public byte[] getContingutBase64() {
		return contingutBase64;
	}
	public void setContingutBase64(byte[] contingutBase64) {
		this.contingutBase64 = contingutBase64;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getMetadades() {
		return metadades;
	}
	public void setMetadades(List<String> metadades) {
		this.metadades = metadades;
	}
	public boolean isNormalitzat() {
		return normalitzat;
	}
	public void setNormalitzat(boolean normalitzat) {
		this.normalitzat = normalitzat;
	}
	public boolean isGenerarCsv() {
		return generarCsv;
	}
	public void setGenerarCsv(boolean generarCsv) {
		this.generarCsv = generarCsv;
	}
	public String getCsv() {
		return csv;
	}
	public void setCsv(String csv) {
		this.csv = csv;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public static DocumentCommand asCommand(DocumentDto dto) {
		if (dto == null) {
			return null;
		}
		DocumentCommand command = ConversioTipusHelper.convertir(
				dto,
				DocumentCommand.class );
		return command;
	}
	public static DocumentDto asDto(DocumentCommand command) {
		if (command == null) {
			return null;
		}
		DocumentDto dto = ConversioTipusHelper.convertir(
				command,
				DocumentDto.class);
		return dto;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
