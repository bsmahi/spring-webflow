/*
 * Copyright 2004-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.webflow.engine.model;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * Model support for exception handlers.
 * <p>
 * Handles exceptions that occur during flow execution. Exception handlers may be attached at the state or flow level.
 * 
 * @author Scott Andrews
 */
public class ExceptionHandlerModel extends AbstractModel {
	private String beanName;

	/**
	 * Create an exception handler model
	 * @param beanName the name of the bean to handle exceptions
	 */
	public ExceptionHandlerModel(String beanName) {
		setBeanName(beanName);
	}

	/**
	 * Exception handlers are not mergeable
	 */
	public void merge(Model model) {
		// not mergable
	}

	public boolean isMergeableWith(Model model) {
		return false;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof ExceptionHandlerModel)) {
			return false;
		}
		ExceptionHandlerModel exceptionHandler = (ExceptionHandlerModel) obj;
		if (exceptionHandler == null) {
			return false;
		} else if (!ObjectUtils.nullSafeEquals(getBeanName(), exceptionHandler.getBeanName())) {
			return false;
		} else {
			return true;
		}
	}

	public int hashCode() {
		return ObjectUtils.nullSafeHashCode(getBeanName()) * 27;
	}

	/**
	 * @return the bean name
	 */
	public String getBeanName() {
		return beanName;
	}

	/**
	 * @param beanName the bean name to set
	 */
	public void setBeanName(String beanName) {
		if (StringUtils.hasText(beanName)) {
			this.beanName = beanName;
		} else {
			this.beanName = null;
		}
	}
}