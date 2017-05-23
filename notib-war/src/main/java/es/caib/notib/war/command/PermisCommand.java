/**
 * 
 */
package es.caib.notib.war.command;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import es.caib.notib.core.api.dto.PermisDto;
import es.caib.notib.core.api.dto.PermisosEnumDto;
import es.caib.notib.core.api.dto.TipusEnumDto;
import es.caib.notib.war.helper.ConversioTipusHelper;

/**
 * Command per al manteniment de permisos.
 * 
 * @author Limit Tecnologies <limit@limit.es>
 */
public class PermisCommand {

	private Long id;
	@NotEmpty @Size(max=64)
	private String nom;
	@NotNull
	private TipusEnumDto tipus;
	private PermisosEnumDto permis; 
	private boolean read;
	private boolean write;
	private boolean create;
	private boolean delete;
	private boolean administration;
	private boolean representant;
	private boolean aplicacio;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public TipusEnumDto getTipus() {
		return tipus;
	}
	public void setTipus(TipusEnumDto tipus) {
		this.tipus = tipus;
	}
	public PermisosEnumDto getPermis() {
		return permis;
	}
	public void setPermis(PermisosEnumDto permis) {
		this.permis = permis;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public boolean isWrite() {
		return write;
	}
	public void setWrite(boolean write) {
		this.write = write;
	}
	public boolean isCreate() {
		return create;
	}
	public void setCreate(boolean create) {
		this.create = create;
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public boolean isAdministration() {
		return administration;
	}
	public void setAdministration(boolean administration) {
		this.administration = administration;
	}

	public boolean isRepresentant() {
		return representant;
	}
	public void setRepresentant(boolean representant) {
		this.representant = representant;
	}
	
	public boolean isAplicacio() {
		return aplicacio;
	}
	public void setAplicacio(boolean aplicacio) {
		this.aplicacio = aplicacio;
	}
	
	public static List<PermisCommand> toPermisCommands(
			List<PermisDto> dtos) {
		List<PermisCommand> commands = new ArrayList<PermisCommand>();
		for (PermisDto dto: dtos) {
			commands.add(
					ConversioTipusHelper.convertir(
							dto,
							PermisCommand.class));
		}
		return commands;
	}

	public static PermisCommand asCommand(PermisDto dto) {
		PermisCommand command = ConversioTipusHelper.convertir(
				dto,
				PermisCommand.class);
		if( dto.isRepresentant() ) command.setPermis( PermisosEnumDto.Representant );
		else if( dto.isAplicacio() ) command.setPermis( PermisosEnumDto.Aplicacio );
		
		return command;		
	}
	public static PermisDto asDto(PermisCommand command) {
		PermisDto dto = ConversioTipusHelper.convertir(
				command,
				PermisDto.class);
		dto.setRepresentant( command.getPermis() == PermisosEnumDto.Representant );
		dto.setAplicacio( command.getPermis() == PermisosEnumDto.Aplicacio );
		
		return dto;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
