package com.sapient.model;

public class DemoDependency {

	public DemoDependency() {
		System.out.println("In constructor of DemoDependency");
	}
	private DemoBean demoBean;
	public DemoBean getDemoBean() {
		return demoBean;
	}
	public void setDemoBean(DemoBean demoBean) {
		System.out.println("Setting demo bean as dependency of class DemoDependency");
		this.demoBean = demoBean;
	}
	public void show() {
		System.out.println("In DemoDependency");
	}

	
	
}
