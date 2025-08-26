package com.sprinngcore.standalone.collections;
import java.util.*;

public class Person {

    private List<String> friends;
    private Map<String, Integer> feeStructure;  // ✅ Fixed typo
    private Properties properties;
    
    public Map<String, Integer> getFeeStructure() {  // ✅ Updated method name
        return feeStructure;
    }

    public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public void setFeeStructure(Map<String, Integer> feeStructure) {  // ✅ Updated method name
        this.feeStructure = feeStructure;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Person [friends=" + friends + ", feeStructure=" + feeStructure + "]";
    }
}
