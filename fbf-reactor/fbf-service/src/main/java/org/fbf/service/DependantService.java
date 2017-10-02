/**
 * 
 */
package org.fbf.service;

import java.util.List;

import org.fbf.model.Dependant;

/**
 * @author amushate 29 Sep,2017
 */
public interface DependantService {

	List<Dependant> findDependantsByIdMember(Long fbfMemberId);

	Dependant addDependant(Long fbfMemberId, Dependant newdependant);

	Dependant removeDependant(Long dependantid);

	Dependant updateDependant(Dependant rawdependant);

	Dependant findDependantById(Long dependantid);

}
