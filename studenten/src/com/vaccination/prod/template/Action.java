package com.vaccination.prod.template;

/**
 * Action
 * <p>
 *     creates an Action-object
 *     Abstract class
 *     Object creation needs to be done through subclasses Step1Action ...Step2Action
 * </p>
 */
public abstract class Action {

    protected String name;
    protected String description;
    protected Action(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
