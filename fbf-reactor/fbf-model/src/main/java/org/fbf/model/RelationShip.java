/**
 * 
 */
package org.fbf.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author amushate 29 Sep,2017
 */
@Entity
public class RelationShip {
	
	@Id
	private String relationShipType;

	public String getRelationShipType() {
		return relationShipType;
	}

	public void setRelationShipType(String relationShipType) {
		this.relationShipType = relationShipType;
	}
}
