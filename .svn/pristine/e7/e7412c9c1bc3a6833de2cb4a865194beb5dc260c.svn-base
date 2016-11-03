package com.cqut.tool.treeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
	private String id;
	private String text;
	private String state;
	private String level0;
	private List<Node> children;
	private boolean createID = true;
	
	private Map<String,Object> attributes = new HashMap<String, Object>();
	
	/**因为树节点常要存储一些ID，当点击时根据ID进行处理，所以这里提供存储ID为nodeCode的参数*/
	public Node(String id,String text,String nodeCode, boolean isOpen,String level0) {
		this.id = id;
		this.text = text;
		attributes.put("nodeCode",nodeCode);
		
		if(isOpen){
			this.state = "open";
		} else {
			this.state = "closed";
		}
		children = new ArrayList<Node>();
		this.setLevel0(level0);
	}
	
	public Node(String text,String nodeCode, boolean isOpen) {
		this(null,text, nodeCode,isOpen,null);
	}
	
	public Node(String id, String text,String nodeCode) {
		this(id, text,nodeCode, true,null);
	}
	
	public Node(String text,String nodeCode) {
		this(null, text,nodeCode, true,null);
	}
	
	public Node(String text,String nodeCode,String level0,boolean isNeedLevel) {
		this(null, text,nodeCode, true,level0);
	}

	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(boolean isOpen) {
		if(isOpen){
			this.state = "open";
		} else {
			this.state = "closed";
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	

	public void addChildren(Node node,boolean isOpen) {
		this.setState(isOpen);
		
		if(createID)
			node.setId(getNextID());
		
		this.children.add(node);
	}
	
	public void addAttr(String key, Object val){
		attributes.put(key, val);
	}
	
	private String getNextID(){
		if(children.size() < 9) {
			return this.id + "0" + String.valueOf(children.size()+1);
		} else {
			return this.id + String.valueOf(children.size()+1);
		}
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setLevel0(String level0) {
		this.level0 = level0;
	}

	public String getLevel0() {
		return level0;
	}

	public boolean isCreateID() {
		return createID;
	}

	public void setCreateID(boolean createID) {
		this.createID = createID;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", text=" + text + ", state=" + state
				+ ", level0=" + level0 + ", children=" + children
				+ ", createID=" + createID + ", attributes=" + attributes + "]";
	}

}


