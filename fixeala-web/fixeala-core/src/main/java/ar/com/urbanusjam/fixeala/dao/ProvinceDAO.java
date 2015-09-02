package ar.com.urbanusjam.fixeala.dao;

import java.util.List;

public interface ProvinceDAO {
	
	public List<String> findAllProvinces();
	public List<String> findLocalitiesByProvince (String province);

}
