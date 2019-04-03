/*
 * Copyright 2019 Mahmoud Romeh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.resilience4j.circuitbreaker.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;


/**
 * the inject Rx java aspect support spring condition check
 */
public class ReactorOnClasspathCondition implements Condition {

	private static final Logger logger = LoggerFactory.getLogger(ReactorOnClasspathCondition.class);
	private static final String CLASS_TO_CHECK = "reactor.core.publisher.Flux";

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return CircuitBreakerAspectUtil.checkClassIfFound(context, CLASS_TO_CHECK, (e) -> logger.info("ReactorCircuitBreakerAspectExt no activated, because Reactor is not on the classpath."));
	}

}
