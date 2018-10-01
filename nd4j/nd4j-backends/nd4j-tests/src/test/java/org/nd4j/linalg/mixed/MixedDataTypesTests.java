/*******************************************************************************
 * Copyright (c) 2015-2018 Skymind, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

package org.nd4j.linalg.mixed;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Test;
import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.shape.options.ArrayOptionsHelper;
import org.nd4j.linalg.factory.Nd4j;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Basic tests for mixed data types
 * @author raver119@gmail.com
 */
@Slf4j
public class MixedDataTypesTests {

    @Test
    public void testBasicCreation_1() throws Exception {
        val array = Nd4j.create(DataBuffer.Type.LONG, 3, 3);

        assertNotNull(array);
        assertEquals(9, array.length());
        assertEquals(DataBuffer.Type.LONG, array.dataType());
        assertEquals(DataBuffer.Type.LONG, ArrayOptionsHelper.dataType(array.shapeInfoJava()));
    }

    @Test
    public void testBasicCreation_2() throws Exception {
        val array = Nd4j.create(DataBuffer.Type.SHORT, 3, 3);

        assertNotNull(array);
        assertEquals(9, array.length());
        assertEquals(DataBuffer.Type.SHORT, array.dataType());
        assertEquals(DataBuffer.Type.SHORT, ArrayOptionsHelper.dataType(array.shapeInfoJava()));
    }

    @Test
    public void testBasicCreation_3() throws Exception {
        val array = Nd4j.create(DataBuffer.Type.HALF, 3, 3);

        assertNotNull(array);
        assertEquals(9, array.length());
        assertEquals(DataBuffer.Type.HALF, array.dataType());
        assertEquals(DataBuffer.Type.HALF, ArrayOptionsHelper.dataType(array.shapeInfoJava()));
    }

    @Test
    public void testBasicCreation_4() throws Exception {
        val scalar = Nd4j.trueScalar(1.0);
        assertNotNull(scalar);
        assertEquals(0, scalar.rank());
        assertEquals(1, scalar.length());
        assertEquals(DataBuffer.Type.DOUBLE, scalar.dataType());
        assertEquals(1.0, scalar.getDouble(0), 1e-5);
    }

    @Test
    public void testBasicCreation_5() throws Exception {
        val scalar = Nd4j.trueScalar(new Integer(1));
        assertNotNull(scalar);
        assertEquals(0, scalar.rank());
        assertEquals(1, scalar.length());
        assertEquals(DataBuffer.Type.INT, scalar.dataType());
        assertEquals(1.0, scalar.getInt(0), 1e-5);
    }

    @Test
    public void testBasicOps_1() throws Exception {
        val exp = new long[]{1,1,1,1,1,1,1,1,1};
        val array = Nd4j.create(DataBuffer.Type.INT, 3, 3);
        array.assign(1);

        val vector = array.toLongVector();
        assertArrayEquals(exp, vector);
    }
}