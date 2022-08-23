package br.com.agence.fleet.vehicles.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

@Getter
@Setter
@NoArgsConstructor
public class BrandDTO {
	
	private Long id;
	private String name;
	private String document;
	private Boolean ativo;
	
	public BrandDTO(Long id, String name, String document, Boolean ativo) throws ParseException {
		
		MaskFormatter mask = new MaskFormatter("###.###.###/####-##");
		mask.setValueContainsLiteralCharacters(false);
		
		this.id = id;
		this.name = name;
		this.document = mask.valueToString(document);
		this.ativo = ativo;
	}
	
}

