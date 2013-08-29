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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.BasicImmutableBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * Mock immutable person JavaBean, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition
public final class ImmPerson implements ImmutableBean {

    /** The forename. */
    @PropertyDefinition
    private final String forename;
    /** The surname. */
    @PropertyDefinition
    private final String surname;
    /** The number of cars. */
    @PropertyDefinition
    private transient final int numberOfCars;
    /** The date of birth. */
    @PropertyDefinition
    private transient final Date dateOfBirth;
    /** The middle names. */
    @PropertyDefinition
    private transient final String[] middleNames;
    @PropertyDefinition
    private final ImmutableList<Address> addressList;
    @PropertyDefinition
    private final Map<String, Address> otherAddressMap;
    @PropertyDefinition
    private final List<List<Address>> addressesList;
    @PropertyDefinition
    private final ImmAddress mainAddress;
//    @PropertyDefinition
//    @XmlID
//    private final FlexiBean extensions;

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code ImmPerson}.
     * @return the meta-bean, not null
     */
    public static ImmPerson.Meta meta() {
        return ImmPerson.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(ImmPerson.Meta.INSTANCE);
    }

    /**
     * Returns a builder used tp create an instance of the bean.
     *
     * @return the builder, not null
     */
    public static ImmPerson.Builder builder() {
        return new ImmPerson.Builder();
    }

    private ImmPerson(
            ImmPerson.Builder builder,
            String forename,
            String surname,
            int numberOfCars,
            Date dateOfBirth,
            String[] middleNames,
            List<Address> addressList,
            Map<String, Address> otherAddressMap,
            List<List<Address>> addressesList,
            ImmAddress mainAddress) {
        this.forename = forename;
        this.surname = surname;
        this.numberOfCars = numberOfCars;
        this.dateOfBirth = (dateOfBirth != null ? (Date) dateOfBirth.clone() : null);
        this.middleNames = (middleNames != null ? middleNames.clone() : null);
        this.addressList = ImmutableList.copyOf(addressList);
        this.otherAddressMap = ImmutableMap.copyOf(otherAddressMap);
        this.addressesList = ImmutableList.copyOf(addressesList);
        this.mainAddress = mainAddress;
    }

    @Override
    public ImmPerson.Meta metaBean() {
        return ImmPerson.Meta.INSTANCE;
    }

    @Override
    public <R> Property<R> property(String propertyName) {
        return metaBean().<R>metaProperty(propertyName).createProperty(this);
    }

    @Override
    public Set<String> propertyNames() {
        return metaBean().metaPropertyMap().keySet();
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the forename.
     * @return the value of the property
     */
    public String getForename() {
        return forename;
    }

    /**
     * Gets the the {@code forename} property.
     * @return the property, not null
     */
    public final Property<String> forename() {
        return metaBean().forename().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the surname.
     * @return the value of the property
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Gets the the {@code surname} property.
     * @return the property, not null
     */
    public final Property<String> surname() {
        return metaBean().surname().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the number of cars.
     * @return the value of the property
     */
    public int getNumberOfCars() {
        return numberOfCars;
    }

    /**
     * Gets the the {@code numberOfCars} property.
     * @return the property, not null
     */
    public final Property<Integer> numberOfCars() {
        return metaBean().numberOfCars().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the date of birth.
     * @return the value of the property
     */
    public Date getDateOfBirth() {
        return (dateOfBirth != null ? (Date) dateOfBirth.clone() : null);
    }

    /**
     * Gets the the {@code dateOfBirth} property.
     * @return the property, not null
     */
    public final Property<Date> dateOfBirth() {
        return metaBean().dateOfBirth().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the middle names.
     * @return the value of the property
     */
    public String[] getMiddleNames() {
        return (middleNames != null ? middleNames.clone() : null);
    }

    /**
     * Gets the the {@code middleNames} property.
     * @return the property, not null
     */
    public final Property<String[]> middleNames() {
        return metaBean().middleNames().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the addressList.
     * @return the value of the property
     */
    public ImmutableList<Address> getAddressList() {
        return addressList;
    }

    /**
     * Gets the the {@code addressList} property.
     * @return the property, not null
     */
    public final Property<ImmutableList<Address>> addressList() {
        return metaBean().addressList().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the otherAddressMap.
     * @return the value of the property
     */
    public Map<String, Address> getOtherAddressMap() {
        return otherAddressMap;
    }

    /**
     * Gets the the {@code otherAddressMap} property.
     * @return the property, not null
     */
    public final Property<Map<String, Address>> otherAddressMap() {
        return metaBean().otherAddressMap().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the addressesList.
     * @return the value of the property
     */
    public List<List<Address>> getAddressesList() {
        return addressesList;
    }

    /**
     * Gets the the {@code addressesList} property.
     * @return the property, not null
     */
    public final Property<List<List<Address>>> addressesList() {
        return metaBean().addressesList().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the mainAddress.
     * @return the value of the property
     */
    public ImmAddress getMainAddress() {
        return mainAddress;
    }

    /**
     * Gets the the {@code mainAddress} property.
     * @return the property, not null
     */
    public final Property<ImmAddress> mainAddress() {
        return metaBean().mainAddress().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Returns a builder that allows this bean to be mutated.
     * @return the mutable builder, not null
     */
    public Builder with() {
        return new Builder(this);
    }

    @Override
    public ImmPerson clone() {
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            ImmPerson other = (ImmPerson) obj;
            return JodaBeanUtils.equal(getForename(), other.getForename()) &&
                    JodaBeanUtils.equal(getSurname(), other.getSurname()) &&
                    (getNumberOfCars() == other.getNumberOfCars()) &&
                    JodaBeanUtils.equal(getDateOfBirth(), other.getDateOfBirth()) &&
                    JodaBeanUtils.equal(getMiddleNames(), other.getMiddleNames()) &&
                    JodaBeanUtils.equal(getAddressList(), other.getAddressList()) &&
                    JodaBeanUtils.equal(getOtherAddressMap(), other.getOtherAddressMap()) &&
                    JodaBeanUtils.equal(getAddressesList(), other.getAddressesList()) &&
                    JodaBeanUtils.equal(getMainAddress(), other.getMainAddress());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash += hash * 31 + JodaBeanUtils.hashCode(getForename());
        hash += hash * 31 + JodaBeanUtils.hashCode(getSurname());
        hash += hash * 31 + JodaBeanUtils.hashCode(getNumberOfCars());
        hash += hash * 31 + JodaBeanUtils.hashCode(getDateOfBirth());
        hash += hash * 31 + JodaBeanUtils.hashCode(getMiddleNames());
        hash += hash * 31 + JodaBeanUtils.hashCode(getAddressList());
        hash += hash * 31 + JodaBeanUtils.hashCode(getOtherAddressMap());
        hash += hash * 31 + JodaBeanUtils.hashCode(getAddressesList());
        hash += hash * 31 + JodaBeanUtils.hashCode(getMainAddress());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(320);
        buf.append(getClass().getSimpleName());
        buf.append('{');
        buf.append("forename").append('=').append(getForename()).append(',').append(' ');
        buf.append("surname").append('=').append(getSurname()).append(',').append(' ');
        buf.append("numberOfCars").append('=').append(getNumberOfCars()).append(',').append(' ');
        buf.append("dateOfBirth").append('=').append(getDateOfBirth()).append(',').append(' ');
        buf.append("middleNames").append('=').append(getMiddleNames()).append(',').append(' ');
        buf.append("addressList").append('=').append(getAddressList()).append(',').append(' ');
        buf.append("otherAddressMap").append('=').append(getOtherAddressMap()).append(',').append(' ');
        buf.append("addressesList").append('=').append(getAddressesList()).append(',').append(' ');
        buf.append("mainAddress").append('=').append(getMainAddress());
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code ImmPerson}.
     */
    public static class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code forename} property.
         */
        private final MetaProperty<String> forename = DirectMetaProperty.ofReadOnly(
                this, "forename", ImmPerson.class, String.class);
        /**
         * The meta-property for the {@code surname} property.
         */
        private final MetaProperty<String> surname = DirectMetaProperty.ofReadOnly(
                this, "surname", ImmPerson.class, String.class);
        /**
         * The meta-property for the {@code numberOfCars} property.
         */
        private final MetaProperty<Integer> numberOfCars = DirectMetaProperty.ofReadOnly(
                this, "numberOfCars", ImmPerson.class, Integer.TYPE);
        /**
         * The meta-property for the {@code dateOfBirth} property.
         */
        private final MetaProperty<Date> dateOfBirth = DirectMetaProperty.ofReadOnly(
                this, "dateOfBirth", ImmPerson.class, Date.class);
        /**
         * The meta-property for the {@code middleNames} property.
         */
        private final MetaProperty<String[]> middleNames = DirectMetaProperty.ofReadOnly(
                this, "middleNames", ImmPerson.class, String[].class);
        /**
         * The meta-property for the {@code addressList} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<ImmutableList<Address>> addressList = DirectMetaProperty.ofReadOnly(
                this, "addressList", ImmPerson.class, (Class) ImmutableList.class);
        /**
         * The meta-property for the {@code otherAddressMap} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<Map<String, Address>> otherAddressMap = DirectMetaProperty.ofReadOnly(
                this, "otherAddressMap", ImmPerson.class, (Class) Map.class);
        /**
         * The meta-property for the {@code addressesList} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<List<List<Address>>> addressesList = DirectMetaProperty.ofReadOnly(
                this, "addressesList", ImmPerson.class, (Class) List.class);
        /**
         * The meta-property for the {@code mainAddress} property.
         */
        private final MetaProperty<ImmAddress> mainAddress = DirectMetaProperty.ofReadOnly(
                this, "mainAddress", ImmPerson.class, ImmAddress.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "forename",
                "surname",
                "numberOfCars",
                "dateOfBirth",
                "middleNames",
                "addressList",
                "otherAddressMap",
                "addressesList",
                "mainAddress");

        /**
         * Restricted constructor.
         */
        protected Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 467061063:  // forename
                    return forename;
                case -1852993317:  // surname
                    return surname;
                case 926656063:  // numberOfCars
                    return numberOfCars;
                case -386871910:  // dateOfBirth
                    return dateOfBirth;
                case 404996787:  // middleNames
                    return middleNames;
                case -1377524046:  // addressList
                    return addressList;
                case 1368089592:  // otherAddressMap
                    return otherAddressMap;
                case -226885792:  // addressesList
                    return addressesList;
                case -2032731141:  // mainAddress
                    return mainAddress;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public ImmPerson.Builder builder() {
            return new ImmPerson.Builder();
        }

        @Override
        public Class<? extends ImmPerson> beanType() {
            return ImmPerson.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code forename} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String> forename() {
            return forename;
        }

        /**
         * The meta-property for the {@code surname} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String> surname() {
            return surname;
        }

        /**
         * The meta-property for the {@code numberOfCars} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Integer> numberOfCars() {
            return numberOfCars;
        }

        /**
         * The meta-property for the {@code dateOfBirth} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Date> dateOfBirth() {
            return dateOfBirth;
        }

        /**
         * The meta-property for the {@code middleNames} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String[]> middleNames() {
            return middleNames;
        }

        /**
         * The meta-property for the {@code addressList} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<ImmutableList<Address>> addressList() {
            return addressList;
        }

        /**
         * The meta-property for the {@code otherAddressMap} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Map<String, Address>> otherAddressMap() {
            return otherAddressMap;
        }

        /**
         * The meta-property for the {@code addressesList} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<List<List<Address>>> addressesList() {
            return addressesList;
        }

        /**
         * The meta-property for the {@code mainAddress} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<ImmAddress> mainAddress() {
            return mainAddress;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 467061063:  // forename
                    return ((ImmPerson) bean).getForename();
                case -1852993317:  // surname
                    return ((ImmPerson) bean).getSurname();
                case 926656063:  // numberOfCars
                    return ((ImmPerson) bean).getNumberOfCars();
                case -386871910:  // dateOfBirth
                    return ((ImmPerson) bean).getDateOfBirth();
                case 404996787:  // middleNames
                    return ((ImmPerson) bean).getMiddleNames();
                case -1377524046:  // addressList
                    return ((ImmPerson) bean).getAddressList();
                case 1368089592:  // otherAddressMap
                    return ((ImmPerson) bean).getOtherAddressMap();
                case -226885792:  // addressesList
                    return ((ImmPerson) bean).getAddressesList();
                case -2032731141:  // mainAddress
                    return ((ImmPerson) bean).getMainAddress();
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            metaProperty(propertyName);
            if (quiet) {
                return;
            }
            throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
        }

    }

    //-----------------------------------------------------------------------
    /**
     * The bean-builder for {@code ImmPerson}.
     */
    public static class Builder extends BasicImmutableBeanBuilder<ImmPerson> {

        private String forename;
        private String surname;
        private int numberOfCars;
        private Date dateOfBirth;
        private String[] middleNames;
        private List<Address> addressList = new ArrayList<Address>();
        private Map<String, Address> otherAddressMap = new HashMap<String, Address>();
        private List<List<Address>> addressesList = new ArrayList<List<Address>>();
        private ImmAddress mainAddress;

        /**
         * Restricted constructor.
         */
        private Builder() {
            super(ImmPerson.Meta.INSTANCE);
        }

        /**
         * Restricted copy constructor.
         * @param beanToCopy  the bean to copy from, not null
         */
        private Builder(ImmPerson beanToCopy) {
            super(ImmPerson.Meta.INSTANCE);
            this.forename = beanToCopy.getForename();
            this.surname = beanToCopy.getSurname();
            this.numberOfCars = beanToCopy.getNumberOfCars();
            this.dateOfBirth = (beanToCopy.getDateOfBirth() != null ? (Date) beanToCopy.getDateOfBirth().clone() : null);
            this.middleNames = (beanToCopy.getMiddleNames() != null ? beanToCopy.getMiddleNames().clone() : null);
            this.addressList = new ArrayList<Address>(beanToCopy.getAddressList());
            this.otherAddressMap = new HashMap<String, Address>(beanToCopy.getOtherAddressMap());
            this.addressesList = new ArrayList<List<Address>>(beanToCopy.getAddressesList());
            this.mainAddress = beanToCopy.getMainAddress();
        }

        //-----------------------------------------------------------------------
        @SuppressWarnings("unchecked")
        @Override
        public Builder set(String propertyName, Object newValue) {
            switch (propertyName.hashCode()) {
                case 467061063:  // forename
                    this.forename = (String) newValue;
                    break;
                case -1852993317:  // surname
                    this.surname = (String) newValue;
                    break;
                case 926656063:  // numberOfCars
                    this.numberOfCars = (Integer) newValue;
                    break;
                case -386871910:  // dateOfBirth
                    this.dateOfBirth = (Date) newValue;
                    break;
                case 404996787:  // middleNames
                    this.middleNames = (String[]) newValue;
                    break;
                case -1377524046:  // addressList
                    this.addressList = (ImmutableList<Address>) newValue;
                    break;
                case 1368089592:  // otherAddressMap
                    this.otherAddressMap = (Map<String, Address>) newValue;
                    break;
                case -226885792:  // addressesList
                    this.addressesList = (List<List<Address>>) newValue;
                    break;
                case -2032731141:  // mainAddress
                    this.mainAddress = (ImmAddress) newValue;
                    break;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
            return this;
        }

        @Override
        public ImmPerson build() {
            return new ImmPerson(
                    this,
                    forename,
                    surname,
                    numberOfCars,
                    dateOfBirth,
                    middleNames,
                    addressList,
                    otherAddressMap,
                    addressesList,
                    mainAddress);
        }

        //-----------------------------------------------------------------------
        /**
         * Sets the {@code forename} property in the builder.
         * @param newValue  the new value, not null
         * @return this, for chaining, not null
         */
        public Builder forename(String newValue) {
            this.forename = newValue;
            return this;
        }

        /**
         * Sets the {@code surname} property in the builder.
         * @param newValue  the new value, not null
         * @return this, for chaining, not null
         */
        public Builder surname(String newValue) {
            this.surname = newValue;
            return this;
        }

        /**
         * Sets the {@code numberOfCars} property in the builder.
         * @param newValue  the new value, not null
         * @return this, for chaining, not null
         */
        public Builder numberOfCars(int newValue) {
            this.numberOfCars = newValue;
            return this;
        }

        /**
         * Sets the {@code dateOfBirth} property in the builder.
         * @param newValue  the new value, not null
         * @return this, for chaining, not null
         */
        public Builder dateOfBirth(Date newValue) {
            this.dateOfBirth = newValue;
            return this;
        }

        /**
         * Sets the {@code middleNames} property in the builder.
         * @param newValue  the new value, not null
         * @return this, for chaining, not null
         */
        public Builder middleNames(String[] newValue) {
            this.middleNames = newValue;
            return this;
        }

        /**
         * Sets the {@code addressList} property in the builder.
         * @param newValue  the new value, not null
         * @return this, for chaining, not null
         */
        public Builder addressList(List<Address> newValue) {
            this.addressList = newValue;
            return this;
        }

        /**
         * Sets the {@code otherAddressMap} property in the builder.
         * @param newValue  the new value, not null
         * @return this, for chaining, not null
         */
        public Builder otherAddressMap(Map<String, Address> newValue) {
            this.otherAddressMap = newValue;
            return this;
        }

        /**
         * Sets the {@code addressesList} property in the builder.
         * @param newValue  the new value, not null
         * @return this, for chaining, not null
         */
        public Builder addressesList(List<List<Address>> newValue) {
            this.addressesList = newValue;
            return this;
        }

        /**
         * Sets the {@code mainAddress} property in the builder.
         * @param newValue  the new value, not null
         * @return this, for chaining, not null
         */
        public Builder mainAddress(ImmAddress newValue) {
            this.mainAddress = newValue;
            return this;
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}
