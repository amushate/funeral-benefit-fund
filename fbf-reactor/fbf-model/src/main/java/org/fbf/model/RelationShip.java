/**
 * 
 */
package org.fbf.model;

import javax.persistence.Entity;

/**
 * @author amushate 29 Sep,2017
 */
@Entity
public class RelationShip {
	
	private String relationShipType;

	public String getRelationShipType() {
		return relationShipType;
	}

	public void setRelationShipType(String relationShipType) {
		this.relationShipType = relationShipType;
	}
}
