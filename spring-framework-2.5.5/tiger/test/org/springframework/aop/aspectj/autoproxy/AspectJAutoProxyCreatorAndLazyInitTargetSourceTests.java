/*
 * Copyright 2002-2007 the original author or authors.
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

package org.springframework.aop.aspectj.autoproxy;

import org.springframework.beans.ITestBean;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

/**
 * @author Rod Johnson
 * @author Rob Harrop
 */
public class AspectJAutoProxyCreatorAndLazyInitTargetSourceTests extends AbstractDependencyInjectionSpringContextTests {

	public AspectJAutoProxyCreatorAndLazyInitTargetSourceTests() {
		setAutowireMode(AUTOWIRE_BY_NAME);
	}

	@Override
	protected String getConfigPath() {
		return "lazy.xml";
	}

	public void testAdrian() {
		ITestBean adrian = (ITestBean) applicationContext.getBean("adrian");
		assertEquals(0, LazyTestBean.instantiations);
		assertNotNull(adrian);
		adrian.getAge();
		assertEquals(68, adrian.getAge());
		assertEquals(1, LazyTestBean.instantiations);
	}

}
