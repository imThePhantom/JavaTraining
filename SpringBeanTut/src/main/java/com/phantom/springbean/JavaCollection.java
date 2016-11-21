package com.phantom.springbean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JavaCollection {
	List<String> addressList;
	Set<String>	addressSet;
	Map<Integer, String> addressMap;
	Properties addressProperties;
	
	public List<String> getAddressList() {
		System.out.println("List Elements :"  + addressList);
		return addressList;
	}
	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
	public Set<String> getAddressSet() {
		System.out.println("Set Elements :"  + addressSet);
		return addressSet;
	}
	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}
	public Map<Integer, String> getAddressMap() {
		System.out.println("Map Elements :"  + addressMap);
		return addressMap;
	}
	public void setAddressMap(Map<Integer, String> addressMap) {
		this.addressMap = addressMap;
	}
	public Properties getAddressProperties() {
		System.out.println("Properties Elements :"  + addressProperties);
		return addressProperties;
	}
	public void setAddressProperties(Properties addressProperties) {
		this.addressProperties = addressProperties;
	}
	
}
