/*
 *  Copyright 2001-2013 Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.beans;

import static org.testng.Assert.assertEquals;

import org.joda.beans.impl.map.MapBean;
import org.testng.annotations.Test;

/**
 * Test MapBean.
 */
@Test
public class TestMapBean {

    public void test_clone() {
        MapBean a = new MapBean();
        a.put("A", "AA");
        a.put("B", "BB");
        MapBean b = a.clone();
        
        assertEquals(a.get("A"), "AA");
        assertEquals(a.get("B"), "BB");
        assertEquals(b.get("A"), "AA");
        assertEquals(b.get("B"), "BB");
        
        a.clear();
        
        assertEquals(a.get("A"), null);
        assertEquals(a.get("B"), null);
        assertEquals(b.get("A"), "AA");
        assertEquals(b.get("B"), "BB");
    }

    public void test_equalsHashCode() {
        MapBean a1 = new MapBean();
        MapBean a2 = new MapBean();
        MapBean b = new MapBean();
        
        a1.put("first", "A");
        a2.put("first", "A");
        b.put("first", "B");
        
        assertEquals(a1.equals(a1), true);
        assertEquals(a1.equals(a2), true);
        assertEquals(a2.equals(a1), true);
        assertEquals(a2.equals(a2), true);
        assertEquals(a1.hashCode(), a2.hashCode());
        
        assertEquals(a1.equals(b), false);
        assertEquals(b.equals(a1), false);
        
        assertEquals(b.equals("Weird type"), false);
        assertEquals(b.equals(null), false);
    }

}
