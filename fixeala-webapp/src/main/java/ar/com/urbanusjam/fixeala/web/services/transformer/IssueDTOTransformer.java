package ar.com.urbanusjam.fixeala.web.services.transformer;

import org.apache.commons.collections.Transformer;

import ar.com.urbanusjam.fixeala.web.domain.api.DataResponse;
import ar.com.urbanusjam.fixeala.service.dto.IssueDTO;

public class IssueDTOTransformer implements Transformer {

	@Override
	public Object transform(Object input) {
		 if (input instanceof IssueDTO) {
	            
			 IssueDTO issue = (IssueDTO) input;            
	         DataResponse dto = new DataResponse();
	     
	         dto.setId(issue.getId());
	         dto.setFecha(issue.getFechaFormateada());
	         dto.setInformante(issue.getUsername());
	         dto.setTitulo(issue.getTitle());
	         dto.setDescripcion(issue.getDescription());
	         dto.setDireccion(issue.getAddress());
	         dto.setBarrio(issue.getNeighborhood() != null ? issue.getNeighborhood() : null);
	         dto.setCiudad(issue.getCity());
	         dto.setProvincia(issue.getProvince());
	         dto.setLatitud(issue.getLatitude());
	         dto.setLongitud(issue.getLongitude());
	         dto.setEstado(issue.getStatus());
	         dto.setComentarios(issue.getTotalComments());
	         dto.setVotos(issue.getTotalVotes());
	         dto.setSeguidores(issue.getTotalFollowers());
	         dto.setLink("http://localhost:8081/fixeala/issues/" + issue.getId()); //CAMBIAR!
	         	            
	         return dto;
	         
	     } else
	            return new DataResponse();
	}

}
