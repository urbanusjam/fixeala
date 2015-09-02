package ar.com.urbanusjam.fixeala.web.service;

import java.io.IOException;

import net.sf.jasperreports.engine.JRException;
import ar.com.urbanusjam.fixeala.service.dto.ReportDTO;

public interface ExportService {

	public void exportDataset(ReportDTO report) throws IOException, JRException, Exception;		
	
}
