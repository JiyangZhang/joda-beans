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
package org.joda.beans.gen;

import java.util.Map;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBean;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

/**
 * Mock pair, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition
public class Pair extends DirectBean {

    /**
     * The first value.
     */
    @PropertyDefinition
    private Object first;
    /**
     * The second value.
     */
    @PropertyDefinition
    private Object second;

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code Pair}.
     * @return the meta-bean, not null
     */
    public static Pair.Meta meta() {
        return Pair.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(Pair.Meta.INSTANCE);
    }

    @Override
    public Pair.Meta metaBean() {
        return Pair.Meta.INSTANCE;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the first value.
     * @return the value of the property
     */
    public Object getFirst() {
        return first;
    }

    /**
     * Sets the first value.
     * @param first  the new value of the property
     */
    public void setFirst(Object first) {
        this.first = first;
    }

    /**
     * Gets the the {@code first} property.
     * @return the property, not null
     */
    public final Property<Object> first() {
        return metaBean().first().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the second value.
     * @return the value of the property
     */
    public Object getSecond() {
        return second;
    }

    /**
     * Sets the second value.
     * @param second  the new value of the property
     */
    public void setSecond(Object second) {
        this.second = second;
    }

    /**
     * Gets the the {@code second} property.
     * @return the property, not null
     */
    public final Property<Object> second() {
        return metaBean().second().createProperty(this);
    }

    //-----------------------------------------------------------------------
    @Override
    public Pair clone() {
        BeanBuilder<? extends Pair> builder = Pair.Meta.INSTANCE.builder();
        for (MetaProperty<?> mp : Pair.Meta.INSTANCE.metaPropertyIterable()) {
            if (mp.readWrite().isWritable()) {
                Object value = mp.get(this);
                if (value instanceof Bean) {
                    value = ((Bean) value).clone();
                }
                builder.set(mp.name(), value);
            }
        }
        return builder.build();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            Pair other = (Pair) obj;
            return JodaBeanUtils.equal(getFirst(), other.getFirst()) &&
                    JodaBeanUtils.equal(getSecond(), other.getSecond());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash += hash * 31 + JodaBeanUtils.hashCode(getFirst());
        hash += hash * 31 + JodaBeanUtils.hashCode(getSecond());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(96);
        buf.append(getClass().getSimpleName());
        buf.append('{');
        int len = buf.length();
        toString(buf);
        if (buf.length() > len) {
            buf.setLength(buf.length() - 2);
        }
        buf.append('}');
        return buf.toString();
    }

    protected void toString(StringBuilder buf) {
        buf.append("first").append('=').append(getFirst()).append(',').append(' ');
        buf.append("second").append('=').append(getSecond()).append(',').append(' ');
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code Pair}.
     */
    public static class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code first} property.
         */
        private final MetaProperty<Object> first = DirectMetaProperty.ofReadWrite(
                this, "first", Pair.class, Object.class);
        /**
         * The meta-property for the {@code second} property.
         */
        private final MetaProperty<Object> second = DirectMetaProperty.ofReadWrite(
                this, "second", Pair.class, Object.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "first",
                "second");

        /**
         * Restricted constructor.
         */
        protected Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 97440432:  // first
                    return first;
                case -906279820:  // second
                    return second;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends Pair> builder() {
            return new DirectBeanBuilder<Pair>(new Pair());
        }

        @Override
        public Class<? extends Pair> beanType() {
            return Pair.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code first} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Object> first() {
            return first;
        }

        /**
         * The meta-property for the {@code second} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Object> second() {
            return second;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 97440432:  // first
                    return ((Pair) bean).getFirst();
                case -906279820:  // second
                    return ((Pair) bean).getSecond();
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 97440432:  // first
                    ((Pair) bean).setFirst((Object) newValue);
                    return;
                case -906279820:  // second
                    ((Pair) bean).setSecond((Object) newValue);
                    return;
            }
            super.propertySet(bean, propertyName, newValue, quiet);
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}
