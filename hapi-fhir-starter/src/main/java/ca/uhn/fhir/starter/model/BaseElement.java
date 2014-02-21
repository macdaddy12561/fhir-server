package ca.uhn.fhir.starter.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public abstract class BaseElement {

	private String myCardMax;
	private String myCardMin;
	private List<BaseElement> myChildren;
	private String myComments;
	private String myDefinition;
	private String myElementName;
	private String myElementParentName;
	private String myName;
	private String myRequirement;
	private String myShortName;
	private List<String> myType;
	private String myV2Mapping;

	public List<ResourceBlock> getResourceBlockChildren() {
		ArrayList<ResourceBlock> retVal = new ArrayList<ResourceBlock>();
		for (BaseElement next : getChildren()) {
			if (next instanceof ResourceBlock) {
				retVal.add((ResourceBlock) next);
			}
		}
		return retVal;
	}
	
	public String getCardMax() {
		return myCardMax;
	}

	public String getCardMin() {
		return myCardMin;
	}

	public List<BaseElement> getChildren() {
		if (myChildren == null) {
			myChildren = new ArrayList<BaseElement>();
		}
		return myChildren;
	}

	public String getComments() {
		return myComments;
	}

	public String getDefinition() {
		return myDefinition;
	}

	public String getElementName() {
		return myElementName;
	}

	public String getElementParentName() {
		return myElementParentName;
	}

	public String getName() {
		return myName;
	}

	public String getRequirement() {
		return myRequirement;
	}

	public String getShortName() {
		return myShortName;
	}

	public List<String> getType() {
		if (myType==null) {
			myType=new ArrayList<String>();
		}
		return myType;
	}

	public String getV2Mapping() {
		return myV2Mapping;
	}

	public void setCardMax(String theCardMax) {
		myCardMax = theCardMax;
	}

	public void setCardMin(String theCardMin) {
		myCardMin = theCardMin;
	}

	public void setComments(String theComments) {
		myComments = theComments;
	}

	public void setDefinition(String theDefinition) {
		myDefinition = theDefinition;
	}

	public void setElementName(String theName) {
		myElementName = theName;
	}

	public void setElementParentName(String theElementParentName) {
		myElementParentName = theElementParentName;
	}

	public void setName(String theName) {
		myName = theName;
	}

	public void setRequirement(String theString) {
		myRequirement = theString;
	}

	public void setShortName(String theShortName) {
		myShortName = theShortName;
	}

	public void setV2Mapping(String theV2Mapping) {
		myV2Mapping = theV2Mapping;
	}

	private boolean myResourceRef = false;
	
	public boolean isResourceRef() {
		return myResourceRef;
	}

	public void setTypeFromString(String theType) {
		if (theType==null) {
			return;
		}
		String typeString = theType;
		if (typeString.startsWith("Resource(")) {
			typeString = typeString.substring("Resource(".length(), typeString.length() - 1);
			myResourceRef=true;
		}
		if (StringUtils.isNotBlank(typeString)) {
			String[] types = typeString.replace("=", "").split("\\|");
			for (String string : types) {
				getType().add(string.trim());
			}
		}
		
	}

}
