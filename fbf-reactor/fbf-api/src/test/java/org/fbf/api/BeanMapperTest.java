/**
 * 
 */
package org.fbf.api;

import static org.junit.Assert.*;

import org.dozer.DozerBeanMapper;
import org.fbf.api.ui.model.UIFBFMember;
import org.fbf.enums.Gender;
import org.fbf.model.FBFMember;
import org.junit.Before;
import org.junit.Test;

/**
 * @author amushate 03 Oct,2017
 */
public class BeanMapperTest {

	
	DozerBeanMapper mapper;
	 
	@Before
	public void before() throws Exception {
	    mapper = new DozerBeanMapper();
	}
	
	@Test
	public void convertUIFBFMemberToFBFMember() {
	    UIFBFMember source = new UIFBFMember();
	    source.setFirstName("ANESU");
	    source.setGender(Gender.MALE);
	    FBFMember dest = mapper.map(source, FBFMember.class);
	 
	    assertEquals(dest.getFirstName(), "ANESU");
	    assertEquals(dest.getGender(), Gender.MALE);
	}

}
