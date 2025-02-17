/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.streaming.api.transformations;

import org.apache.flink.annotation.Internal;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.dag.Transformation;
import org.apache.flink.streaming.api.operators.StreamOperatorFactory;

/**
 * {@link KeyedMultipleInputTransformation} extend for keyed streams join.
 *
 * @author Quentin Qiu
 */
@Internal
public class MultipleInputJoinTransformation<OUT> extends KeyedMultipleInputTransformation<OUT> {
    public MultipleInputJoinTransformation(
            String name,
            StreamOperatorFactory<OUT> operatorFactory,
            TypeInformation<OUT> outputType,
            int parallelism,
            TypeInformation<?> stateKeyType) {
        super(name, operatorFactory, outputType, parallelism, stateKeyType);
    }

    public MultipleInputJoinTransformation(
            String name,
            StreamOperatorFactory<OUT> operatorFactory,
            TypeInformation<OUT> outputType,
            int parallelism,
            boolean parallelismConfigured,
            TypeInformation<?> stateKeyType) {
        super(name, operatorFactory, outputType, parallelism, parallelismConfigured, stateKeyType);
    }

    public MultipleInputJoinTransformation<OUT> addInput(Transformation<?> input) {
        inputs.add(input);
        return this;
    }
}
